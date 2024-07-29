package com.srm.activiti.service;

import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import org.activiti.engine.task.Task;

import java.io.InputStream;
import java.util.List;

public interface IActivitiService {
    List<TaskVO> getAllTask();

    void completeTask(String taskId);

    void apply();

    StartProcessVO startProcess(Long supplierId);

    void taskReject(String taskId);

    SupTaskVO getSupTaskBySupplierId(Long supplierId);

    InputStream getBpmn(Long supplierId);
}
