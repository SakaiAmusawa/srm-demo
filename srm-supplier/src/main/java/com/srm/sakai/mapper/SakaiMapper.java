package com.srm.sakai.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface SakaiMapper {

    String selectDeptNameByDeptId(Long deptId);
}
