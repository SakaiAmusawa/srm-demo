package com.srm.risk.domain.entity;

import lombok.Data;

@Data
public class OperateRisk {

    private Long id;
    private Long putDate;
    private String putReason;
    private Long createTime;
    private String putDepartment;
    private String removeDepartment;
    private Long removeDate;
    private String removeReason;
    private String supplierName;

}
