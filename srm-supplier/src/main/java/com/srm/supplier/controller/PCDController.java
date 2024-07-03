package com.srm.supplier.controller;

import com.alibaba.fastjson2.JSON;
import com.srm.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/getJson")
public class PCDController {

    @GetMapping
    public AjaxResult getPCDJson() throws IOException {
        File file = new File("com/srm/supplier/json/pcd.json");
        String content = new String(Files.readAllBytes(file.toPath()));
        Object obj = JSON.parse(content);
        return AjaxResult.success(obj);
    }

}
