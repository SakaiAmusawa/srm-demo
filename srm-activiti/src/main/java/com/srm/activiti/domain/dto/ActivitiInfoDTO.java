package com.srm.activiti.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivitiInfoDTO {

    Long supplierId;
    String processInstanceId;

}
