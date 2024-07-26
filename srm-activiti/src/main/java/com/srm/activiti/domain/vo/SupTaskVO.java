package com.srm.activiti.domain.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupTaskVO {

    Long supplierId;
    String taskId;

}
