package com.srm.activiti.service.impl;

import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.mapper.ActivitiMapper;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActivitiServiceImpl implements IActivitiService {

    @Autowired
    private ActivitiMapper activitiMapper;

    @Override
    public List<TaskVO> getAllTask() {
        String username = SecurityUtils.getUsername();
        log.debug("username:{}", username);
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
}
