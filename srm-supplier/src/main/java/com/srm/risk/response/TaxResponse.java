package com.srm.risk.response;

import com.srm.risk.domain.entity.TaxRisk;
import lombok.Data;

import java.util.List;

@Data
public class TaxResponse {

    private Result result;
    private String reason;
    private int errorCode;

    // Getters and Setters

    @Data
    public static class Result {
        private int total;
        private List<TaxRisk> items;

        // Getters and Setters
    }

}
