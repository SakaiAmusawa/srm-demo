package com.srm.risk.domain.entity;

import com.srm.common.core.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaxRisk extends BaseEntity {

    Long id;
    String publishTime;
    String caseType;
    String department;
    String taxpayerName;
    String supplierName;

}
