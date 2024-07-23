package com.srm.risk.service;

import com.srm.risk.response.TaxResponse;

public interface IRiskService {
    TaxResponse executeGet(String supplierName);
}
