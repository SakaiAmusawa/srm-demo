package com.srm.risk.controller;

import com.srm.common.core.domain.AjaxResult;
import com.srm.risk.response.IllegalResponse;
import com.srm.risk.response.OperateResponse;
import com.srm.risk.response.TaxResponse;
import com.srm.risk.service.IRiskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/risk/tax")
public class RiskController {

    @Autowired
    private IRiskService riskService;

    /**
     * 获取税务风险
     *
     * @param supplierName 供应商名称
     * @return TaxResponse
     */
    @GetMapping("/tax-data")
    public AjaxResult taxData(@RequestParam String supplierName) {
        TaxResponse taxResponse = riskService.executeGet(supplierName);
        return AjaxResult.success(taxResponse);
    }

    /**
     * 获取经营风险
     *
     * @param supplierName 供应商名称
     * @return OperateResponse
     */
    @GetMapping("/operate-data")
    public AjaxResult operateData(@RequestParam String supplierName) {
        OperateResponse operateResponse = riskService.executeGetOperate(supplierName);
        return AjaxResult.success(operateResponse);
    }

    /**
     * 获取违法风险
     *
     * @param supplierName 供应商名称
     * @return IllegalResponse
     */
    @GetMapping("/illegal-data")
    public AjaxResult illegalData(@RequestParam String supplierName) {
        IllegalResponse illegalResponse = riskService.executeGetIllegal(supplierName);
        return AjaxResult.success(illegalResponse);
    }
}
