package com.srm.risk.domain.entity;

import lombok.Data;

@Data
public class IllegalRisk {

    private Long putDate; // 列入日期
    private String putReason; // 列入原因
    private String putDepartment; // 决定列入部门(作出决定机关)
    private String removeDepartment; // 决定移除部门
    private Long removeDate; // 移除日期
    private String removeReason; // 移除原因
    private String supplierName;

}
