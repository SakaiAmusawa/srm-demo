package com.srm.activiti.service.impl;

import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.mapper.ActivitiMapper;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.exception.ServiceException;
import com.srm.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ActivitiServiceImpl implements IActivitiService {

    @Autowired
    private ActivitiMapper activitiMapper;

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

}
