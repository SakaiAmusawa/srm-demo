package com.srm.activiti.service.impl;

import com.srm.activiti.domain.dto.ActivitiInfoDTO;
import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.mapper.ActivitiMapper;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.exception.ServiceException;
import com.srm.common.utils.SecurityUtils;
import com.srm.supplier.mapper.SrmSupplierInformationMapper;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Transactional
@Slf4j
@Service
public class ActivitiServiceImpl implements IActivitiService {

    private final String prefix = "supplier_processInstance:";
    @Autowired
    private ActivitiMapper activitiMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private SrmSupplierInformationMapper supMapper;
    @Autowired
    private RuntimeService rTimeServer;
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 查询所有代办信息
     *
     * @return 代办信息
     */
    @Override
    public List<TaskVO> getAllTask() {

        //创建一个VO对象，储存所有查询到的代办信息
        List<TaskVO> taskVOList = new ArrayList<>();
        //获取当前登入人信息
        String assignee = SecurityUtils.getUsername();
        //根据当前登入人获取代办信息
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(assignee).list();


        for (Task task : taskList) {
            String processInstanceId = task.getProcessInstanceId();
            Long supplierId = activitiMapper.querySupplierId(processInstanceId);
            String deploymentName = getDeploymentNameByProcessInstanceId(processInstanceId);
            TaskVO taskVO = new TaskVO();
            taskVO.setDeployName(deploymentName);
            taskVO.setSupplierId(supplierId);
            taskVO.setTaskId(task.getId());
            taskVO.setTaskName(task.getName());
            taskVOList.add(taskVO);
        }

        return taskVOList;
    }


    @Override
    public void completeTask(Long supplierId) {

        String supId = supplierId.toString();

        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        String processInstanceId = (String) operations.get(prefix + supId);

        //进行审批操作
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        String taskId = task.getId();

        taskService.complete(taskId);

        //通过历史服务，判断任务是否结束
        log.debug("processInstanceId:{}", processInstanceId);
        //todo 根据流程实例ID查询结果出现问题
        HistoryService historyService = engine.getHistoryService();
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        boolean isEnded = historicProcessInstance != null && historicProcessInstance.getEndTime() != null;
        if (isEnded) {
            supMapper.updateRegStatusBySupplierId(supplierId);
        }

    }

    @Override
    public void apply() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //发起流程
        RuntimeService runtimeService = engine.getRuntimeService();
        //通过流程定义ID来启动流程，获取流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("test01:1:4");
    }

    @Override
    public StartProcessVO startProcess(Long supplierId) {

        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();

        //创建VO对象用于接受返回值
        StartProcessVO startProcessVO = new StartProcessVO();
        //将Long类型的supplierId转化为String类型的数据用于存储到Redis中
        String supplierIdStr = supplierId.toString();
        //尝试根据supplierId获取processInstanceId
        String processInstanceId = (String) operations.get(prefix + supplierIdStr);

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();

        //如果Redis中没有这个值，那么表明着个流程尚未发起或已过期
        if (processInstanceId == null) {

            //发起流程
            RuntimeService runtimeService = engine.getRuntimeService();
            //设置第二级审批人
            Map<String, Object> assigneeMap = new HashMap<>();
            assigneeMap.put("manager", "admin");

            //通过流程定义ID来启动流程，获取流程实例
            ProcessInstance processInstance = runtimeService.startProcessInstanceById("access_approval:1:4", assigneeMap);

            //获取流程ID
            processInstanceId = processInstance.getId();

            //将数据存放到Redis
            operations.set(prefix + supplierIdStr, processInstanceId, 3, TimeUnit.DAYS);

            //储存supplierId和processInstanceId
            ActivitiInfoDTO activitiInfoDTO = new ActivitiInfoDTO();
            activitiInfoDTO.setSupplierId(supplierId);
            activitiInfoDTO.setProcessInstanceId(processInstanceId);
            activitiMapper.saveActivitiInfo(activitiInfoDTO);
        }

        //根据供应商ID获取流程ID
        processInstanceId = (String) operations.get(prefix + supplierIdStr);

        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        if (task == null) {
            throw new ServiceException("流程已预期结束，不应在此处执行该操作.");
        }

        String assignee = task.getAssignee();
        String taskId = task.getId();

        startProcessVO.setAssignee(assignee);
        startProcessVO.setTaskId(taskId);

        return startProcessVO;
    }

    @Override
    public void taskReject(String taskId) {

        //流程的拒绝
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        Map<String, Object> variables = new HashMap<>();
        variables.put("rejected", true);  // 自定义变量，标识任务被拒绝
        taskService.complete(taskId, variables);

    }

    @Override
    public SupTaskVO getSupTaskBySupplierId(Long supplierId) {

        return activitiMapper.getTaskBySupplierId(supplierId);
    }

    /**
     * 获取当前流程图
     *
     * @param supplierId 供应商ID
     * @return 流程图
     */
    @Override
    public InputStream getBpmn(Long supplierId) {

        String supId = supplierId.toString();

        ValueOperations<Object, Object> redisOperation = redisTemplate.opsForValue();

        String processInstanceId = (String) redisOperation.get(prefix + supId);

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        if (processInstanceId == null) {
            return null;
        }

        RepositoryService repositoryService = engine.getRepositoryService();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        List<String> activeActivityIds = runtimeService.getActiveActivityIds(processInstanceId);

        ProcessDiagramGenerator diagramGenerator = new DefaultProcessDiagramGenerator();
        return diagramGenerator.generateDiagram(
                bpmnModel,
                "png",
                activeActivityIds,
                Collections.emptyList(),
                "宋体", // 设置支持中文的字体
                "宋体",
                "宋体",
                null,
                1.0);
    }

    public String getDeploymentNameByProcessInstanceId(String processInstanceId) {
        // 通过流程实例ID获取流程实例对象
        ProcessInstance processInstance = rTimeServer.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        if (processInstance == null) {
            // 如果流程实例不存在，可能流程实例ID无效或流程已结束
            return null;
        }

        // 从流程实例中获取流程定义key
        String processDefinitionKey = processInstance.getProcessDefinitionKey();

        // 使用流程定义key和流程实例的版本号获取流程定义对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey)
                .processDefinitionId(processInstance.getProcessDefinitionId())
                .singleResult();

        if (processDefinition == null) {
            // 如果流程定义不存在，可能流程定义已被删除
            return null;
        }

        // 从流程定义对象中获取部署ID
        String deploymentId = processDefinition.getDeploymentId();

        // 通过部署ID获取部署对象
        Deployment deployment = repositoryService.createDeploymentQuery()
                .deploymentId(deploymentId)
                .singleResult();

        if (deployment == null) {
            // 如果部署对象不存在，可能部署已被删除
            return null;
        }

        // 返回部署名称
        return deployment.getName();
    }
}
