package com.srm.tool;

import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.domain.model.LoginUser;
import com.srm.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sakai/tool")
public class YunFengRuoYiToolController {

    @GetMapping("/userInfo")
    public AjaxResult getUserInfo() {

        LoginUser loginUser = SecurityUtils.getLoginUser();

        return AjaxResult.success(loginUser);
    }

}
