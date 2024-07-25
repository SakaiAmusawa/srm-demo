package com.srm.activiti.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskMapDTO {

    Map<Long, String> taskMap;

}
