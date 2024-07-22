package com.srm.activiti.service;

import com.srm.activiti.domain.vo.TaskVO;
import org.activiti.engine.task.Task;

import java.util.List;

public interface IActivitiService {
    List<TaskVO> getAllTask();

    void completeTask();

    void apply();

    List<Task> getTask();
}
