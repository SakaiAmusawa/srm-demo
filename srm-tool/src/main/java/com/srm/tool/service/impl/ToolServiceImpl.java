package com.srm.tool.service.impl;

import com.srm.tool.domain.DeptVO;
import com.srm.tool.mapper.ToolMapper;
import com.srm.tool.service.IToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolServiceImpl implements IToolService {

    @Autowired
    private ToolMapper toolMapper;

    @Override
    public List<DeptVO> getTopCompanyList() {
        List<DeptVO> deptVOList = toolMapper.selectTopDept();
        return deptVOList;
    }

    @Override
    public List<DeptVO> getDepartmentList() {
        List<DeptVO> deptVOList = toolMapper.selectLowDept();
        return deptVOList;
    }
}
