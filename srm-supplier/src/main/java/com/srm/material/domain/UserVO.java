package com.srm.material.domain;

import com.srm.common.core.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserVO extends BaseEntity {

    Long userId;
    String userName;
    String phoneNumber;

}
