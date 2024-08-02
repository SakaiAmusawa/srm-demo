package com.srm.activiti.service;

import com.srm.activiti.domain.vo.StartProcessVO;

public interface ISupplierSurveyActivitiService {
    StartProcessVO startProcess(String supplierName);
}
