package com.srm.activiti.controlller;

import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.service.ISupplierSurveyActivitiService;
import com.srm.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获取当前任务信息
     */
    @GetMapping("/getTaskInfo/{supplierName}")
    public AjaxResult getTaskInfo(@PathVariable String supplierName) {

        if (supplierName == null) {
            return AjaxResult.success();
        }

        StartProcessVO startProcessVO = service.getTaskInfoBySupplierName(supplierName);

        return AjaxResult.success(startProcessVO);
    }

    /**
     * 完成任务
     */
    @PostMapping("/completeTask/{supplierName}")
    public AjaxResult completeTask(@RequestBody StartProcessVO startProcessVO, @PathVariable String supplierName) {
        service.completeTaskByTaskId(startProcessVO, supplierName);
        return AjaxResult.success();
    }

}
