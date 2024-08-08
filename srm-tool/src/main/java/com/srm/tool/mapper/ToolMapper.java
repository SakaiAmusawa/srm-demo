package com.srm.tool.mapper;

import com.srm.tool.domain.DeptVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolMapper {
    List<DeptVO> selectTopDept();

    List<DeptVO> selectLowDept();

    Long selectDeptIdByUserName(String userName);

    String selectDeptNameByDeptId(Long deptId);
}
