package com.srm.activiti.service.impl;

import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.mapper.ActivitiMapper;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.utils.SecurityUtils;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiServiceImpl implements IActivitiService {

    @Autowired
    private ActivitiMapper activitiMapper;

    @Override
    public List<TaskVO> getAllTask() {
        String username = SecurityUtils.getUsername();
        return activitiMapper.selectAllTaskByUserName(username);
    }

    @Override
    public void completeTask() {
        String username = SecurityUtils.getUsername();
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(username).list();
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                taskService.complete(task.getId());
            }
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
    public List<Task> getTask() {

        String username = SecurityUtils.getUsername();

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        //对应act_ru_task这张表的记录
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(username).list();
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                String id = task.getId();
                System.out.println("id = " + id);
                String name = task.getName();
                System.out.println("name = " + name);
            }
        }
        return tasks;
    }
}
