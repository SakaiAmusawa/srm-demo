package com.srm.supplier.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassDTO {

    String companyCode;
    String enterprise;

}
