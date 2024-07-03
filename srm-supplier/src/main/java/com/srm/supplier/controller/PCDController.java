package com.srm.supplier.controller;

import com.alibaba.fastjson2.JSON;
import com.srm.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Api(tags = "获取JSON数据")
@RestController
@RequestMapping("/dev-api/getJson")
public class PCDController {

    @ApiOperation("获取省市区JSON数据")
    @GetMapping
    public AjaxResult getPCDJson() throws IOException {
        //todo 使用了绝对路径 注意后期修改
        File file = new File("D:\\SRM-DEMO\\SRM\\srm-supplier\\src\\main\\java\\com\\srm\\supplier\\json\\pcd.json");
        String content = new String(Files.readAllBytes(file.toPath()));
        Object obj = JSON.parse(content);
        return AjaxResult.success(obj);
    }

}
