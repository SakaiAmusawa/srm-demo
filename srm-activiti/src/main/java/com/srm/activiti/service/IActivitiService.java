package com.srm.activiti.service;

import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import org.activiti.engine.task.Task;

import java.util.List;

public interface IActivitiService {
    List<TaskVO> getAllTask();

    void completeTask(String taskId);

    void apply();

    String startProcess();

    void taskReject(String taskId);

    SupTaskVO getSupTaskBySupplierId(Long supplierId);
}
