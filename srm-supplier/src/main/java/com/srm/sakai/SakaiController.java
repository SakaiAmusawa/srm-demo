package com.srm.sakai;

import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.domain.model.LoginUser;
import com.srm.common.utils.SecurityUtils;
import com.srm.sakai.mapper.SakaiMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sakai")
public class SakaiController {

    @Autowired
    private SakaiMapper sakaiMapper;

    @GetMapping("/user/getUserInfo")
    public AjaxResult getUserInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        log.debug("loginUser:{}", loginUser);
        UserVO userVO = new UserVO();
        userVO.setUsername(loginUser.getUsername());
        Long deptId = loginUser.getDeptId();
        String departmentName = sakaiMapper.selectDeptNameByDeptId(deptId);
        userVO.setDeptName(departmentName);
        return AjaxResult.success(userVO);
    }

}
