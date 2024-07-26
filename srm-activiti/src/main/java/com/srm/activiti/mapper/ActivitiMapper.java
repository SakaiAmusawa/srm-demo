package com.srm.activiti.mapper;

import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ActivitiMapper {
    SupTaskVO getTaskBySupplierId(Long supplierId);
}
