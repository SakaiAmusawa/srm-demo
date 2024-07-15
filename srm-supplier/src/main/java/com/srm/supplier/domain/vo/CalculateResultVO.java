package com.srm.supplier.domain.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculateResultVO {
    Double totalScore;
    String level;
}
