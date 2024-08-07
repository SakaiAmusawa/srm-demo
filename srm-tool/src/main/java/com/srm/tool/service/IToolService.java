package com.srm.tool.service;

import com.srm.tool.domain.DeptVO;

import java.util.List;

public interface IToolService {
    List<DeptVO> getTopCompanyList();

    List<DeptVO> getDepartmentList();
}
