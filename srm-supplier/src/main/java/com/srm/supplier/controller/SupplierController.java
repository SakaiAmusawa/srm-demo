package com.srm.supplier.controller;

import com.srm.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @PostMapping("/register")
    public AjaxResult supplierRegister() {
        return AjaxResult.success();
    }

}
