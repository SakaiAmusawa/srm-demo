package com.srm.tool.controller;

import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.domain.model.LoginUser;
import com.srm.common.utils.SecurityUtils;
import com.srm.tool.domain.DeptVO;
import com.srm.tool.service.IToolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sakai/tool")
public class YunFengRuoYiToolController {

    @Autowired
    private IToolService toolService;

    /**
     * 获取当前用户信息
     *
     * @return LoginUser 当前登录用户信息：用户ID 部门ID 权限列表 用户详情
     */
    @GetMapping("/userInfo")
    public AjaxResult getUserInfo() {

        LoginUser loginUser = SecurityUtils.getLoginUser();

        return AjaxResult.success(loginUser);
    }

    /**
     * 获取顶级公司名称
     */
    @GetMapping("/topCompanyList")
    public AjaxResult companyList() {

        List<DeptVO> deptVOList = toolService.getTopCompanyList();

        return AjaxResult.success(deptVOList);

    }

    /**
     * 获取部门列表
     */
    @GetMapping("/departmentList")
    public AjaxResult departmentList() {

        List<DeptVO> deptVOList = toolService.getDepartmentList();
        return AjaxResult.success(deptVOList);

    }

}
