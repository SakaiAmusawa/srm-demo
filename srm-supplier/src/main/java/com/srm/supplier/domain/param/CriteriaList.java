package com.srm.supplier.domain.param;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CriteriaList {

    Long id;
    Integer weight;
    Integer score;
    Double finalScore;
    Long kpId;

}
