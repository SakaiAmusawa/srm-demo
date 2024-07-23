package com.srm.risk.controller;

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


    @GetMapping("/tax-data")
    public TaxResponse taxData(@RequestParam String supplierName) {
        return riskService.executeGet(supplierName);
    }

    @GetMapping("/operate-data")
    public OperateResponse operateData(@RequestParam String supplierName) {
        OperateResponse operateResponse = riskService.executeGetOperate(supplierName);
        return operateResponse;
    }

    @GetMapping("/illegal-data")
    public IllegalResponse illegalData(@RequestParam String supplierName) {
        IllegalResponse illegalResponse = riskService.executeGetIllegal(supplierName);
        return illegalResponse;
    }
}
