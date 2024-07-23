package com.srm.risk.mapper;

import com.srm.risk.domain.entity.IllegalRisk;
import com.srm.risk.domain.entity.OperateRisk;
import com.srm.risk.domain.entity.TaxRisk;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiskMapper {
    void insertTaskRisk(TaxRisk item);

    void insertOperateRisk(List<OperateRisk> operateRisks);

    void insertIllegalRisk(IllegalRisk illegalRisk);
}
