package com.srm.supplier.controller;

import com.srm.common.core.domain.AjaxResult;
import com.srm.supplier.service.ISrmSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISrmSupplierService srmSupplierService;

    @PostMapping("/register")
    public AjaxResult supplierRegister() {
        srmSupplierService.supplierRegister();
        return AjaxResult.success();
    }

}
