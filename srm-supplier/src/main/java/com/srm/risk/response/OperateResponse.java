package com.srm.risk.response;

import com.srm.risk.domain.entity.OperateRisk;
import lombok.Data;

import java.util.List;

@Data
public class OperateResponse {

    private OperateResponse.Result result;
    private String reason;
    private int errorCode;

    // Getters and Setters

    @Data
    public static class Result {
        private int total;
        private List<OperateRisk> operateRisks;

        // Getters and Setters
    }


}
