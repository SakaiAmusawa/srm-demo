package com.srm.supplier.domain.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppraisalResult {

    Long kpId;
    List<CriteriaList> criteriaList;
    @JsonProperty("supplierInfo")
    String supplierCode;
    Double totalScore;
    String level;

}
