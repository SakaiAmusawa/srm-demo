package com.srm.activiti.controlller;

import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.service.ISupplierSurveyActivitiService;
import com.srm.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/supplier/survey")
public class SupplierActivitiController {

    @Autowired
    private ISupplierSurveyActivitiService service;

    /**
     * 发起调查流程
     */
    @PostMapping("/startSurveyProcess/{supplierName}")
    public AjaxResult startSurveyProcess(@PathVariable String supplierName) {
        StartProcessVO startProcessVO = service.startProcess(supplierName);
        return AjaxResult.success(startProcessVO);
    }

}
