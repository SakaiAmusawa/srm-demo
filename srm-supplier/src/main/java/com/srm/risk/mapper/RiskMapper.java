package com.srm.risk.mapper;

import com.srm.risk.domain.entity.TaxRisk;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskMapper {
    void insertTaskRisk(TaxRisk item);
}
