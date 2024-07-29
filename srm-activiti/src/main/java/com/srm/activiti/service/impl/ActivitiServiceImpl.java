package com.srm.activiti.service.impl;

import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.mapper.ActivitiMapper;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ActivitiServiceImpl implements IActivitiService {

    @Autowired
    private ActivitiMapper activitiMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

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
            TaskVO taskVO = new TaskVO();
            taskVO.setTaskId(task.getId());
            taskVO.setTaskName(task.getName());
            taskVOList.add(taskVO);
        }

        log.debug("任务列表视图:{}", taskList);
        return taskVOList;
    }

    @Override
    public void completeTask(String taskId) {

        log.debug("taskId:{}", taskId);

        //进行审批操作
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        taskService.complete(taskId);
        log.debug("该任务节点已完成");


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
        //todo 更改错误逻辑

        //创建VO对象用于接受返回值
        StartProcessVO startProcessVO = new StartProcessVO();
        //将Long类型的supplierId转化为String类型的数据用于存储到Redis中
        String supplierIdStr = supplierId.toString();
        //尝试根据supplierId获取processInstanceId
        String processInstanceId = (String) redisTemplate.opsForValue().get(supplierIdStr);

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = engine.getTaskService();

        //如果Redis中没有这个值，那么表明着个流程尚未发起或已过期
        if (processInstanceId == null) {

            //发起流程
            RuntimeService runtimeService = engine.getRuntimeService();

            Map<String, Object> assigneeMap = new HashMap<>();
            assigneeMap.put("manager", "admin");

            //通过流程定义ID来启动流程，获取流程实例
            ProcessInstance processInstance = runtimeService.startProcessInstanceById("access_approval:1:4", assigneeMap);

            //获取流程ID
            processInstanceId = processInstance.getId();

            //将数据存放到Redis
            redisTemplate.opsForValue().set(supplierIdStr, processInstanceId, 12, TimeUnit.HOURS);
        }

        //根据供应商ID获取流程ID
        processInstanceId = (String) redisTemplate.opsForValue().get(supplierIdStr);

        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

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

        String processInstanceId = (String) redisOperation.get(supId);

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

}
