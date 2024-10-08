package com.srm.activiti.service.impl;

import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.listener.survey.SupplierListener;
import com.srm.activiti.service.ISupplierSurveyActivitiService;
import com.srm.common.exception.ServiceException;
import com.srm.common.utils.SecurityUtils;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SupplierSurveyActivitiImpl implements ISupplierSurveyActivitiService {

    private final static String PREFIX = "supplier_survey:";
    private final static String PROCESS_INSTANCE_ID = "supplier_life_survey:1:10004";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public StartProcessVO startProcess(String supplierName) {

        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        //尝试获取流程实例ID
        String processInstanceId = (String) operations.get(PREFIX + supplierName);

        if (processInstanceId == null) {
            //将供应商名称传递给监听器
            new SupplierListener(supplierName);
            //发起流程
            ProcessInstance processInstance = runtimeService.startProcessInstanceById(PROCESS_INSTANCE_ID);
            //获取流程ID
            processInstanceId = processInstance.getId();
            //存放到缓存中
            operations.set(PREFIX + supplierName, processInstanceId);
        }

        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        StartProcessVO startProcessVO = new StartProcessVO();

        if (task != null) {
            startProcessVO.setTaskId(task.getId());
            startProcessVO.setAssignee(task.getAssignee());
        }
        return startProcessVO;

    }

    @Override
    public StartProcessVO getTaskInfoBySupplierName(String supplierName) {

        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();

        String processInstanceId = (String) operations.get(PREFIX + supplierName);

        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        if (task == null) {
            return null;
        }

        StartProcessVO startProcessVO = new StartProcessVO();
        startProcessVO.setAssignee(task.getAssignee());
        startProcessVO.setTaskId(task.getId());

        return startProcessVO;
    }

    @Override
    public void completeTaskByTaskId(StartProcessVO startProcessVO, String supplierName) {

        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        String taskId = startProcessVO.getTaskId();
        if (taskId == null) {
            String processInstanceId = (String) operations.get(PREFIX + supplierName);
            if (processInstanceId == null) {
                throw new ServiceException("当前流程已结束");
            }
            Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
            startProcessVO.setTaskId(task.getId());
            startProcessVO.setAssignee(task.getAssignee());
        }

        String username = SecurityUtils.getUsername();
        if (!Objects.equals(username, startProcessVO.getAssignee())) {
            throw new ServiceException("当前无权审批");
        }

        taskService.complete(taskId);

        String processInstanceId = (String) operations.get(PREFIX + supplierName);
        if (processInstanceId == null) {
            throw new ServiceException("sakai-error");
        }

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        if (processInstance == null) {
            redisTemplate.delete(PREFIX + supplierName);
        }

    }
}
