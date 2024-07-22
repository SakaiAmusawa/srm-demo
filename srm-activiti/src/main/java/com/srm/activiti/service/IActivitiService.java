package com.srm.activiti.service;

import com.srm.activiti.domain.vo.TaskVO;

import java.util.List;

public interface IActivitiService {
    List<TaskVO> getAllTask();

    void completeTask();
}
