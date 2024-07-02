package com.srm.supplier.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CompanyInfo {

    @SerializedName("result")
    public Result result;

    @SerializedName("reason")
    private String reason;

    @SerializedName("error_code")
    private int errorCode;

    public static class Result {
        @SerializedName("historyNames")
        private String historyNames;
        @SerializedName("cancelDate")
        private Object cancelDate;
        @SerializedName("regStatus")
        private String regStatus;
        @SerializedName("regCapital")
        private String regCapital;
        @SerializedName("city")
        private String city;
        @SerializedName("staffNumRange")
        private String staffNumRange;
        @SerializedName("bondNum")
        private String bondNum;
        @SerializedName("historyNameList")
        private List<String> historyNameList;
        @SerializedName("industry")
        private String industry;
        @SerializedName("bondName")
        private String bondName;
        @SerializedName("revokeDate")
        private Object revokeDate;
        @SerializedName("type")
        private int type;
        @SerializedName("updateTimes")
        private long updateTimes;
        @SerializedName("legalPersonName")
        public String legalPersonName;
        @SerializedName("revokeReason")
        private String revokeReason;
        @SerializedName("compForm")
        private Object compForm;
        @SerializedName("regNumber")
        private String regNumber;
        @SerializedName("creditCode")
        private String creditCode;
        @SerializedName("property3")
        private String property3;
        @SerializedName("usedBondName")
        private String usedBondName;
        @SerializedName("approvedTime")
        private long approvedTime;
        @SerializedName("fromTime")
        private long fromTime;
        @SerializedName("socialStaffNum")
        private int socialStaffNum;
        @SerializedName("actualCapitalCurrency")
        private String actualCapitalCurrency;
        @SerializedName("alias")
        private String alias;
        @SerializedName("companyOrgType")
        private String companyOrgType;
        @SerializedName("id")
        private int id;
        @SerializedName("cancelReason")
        private String cancelReason;
        @SerializedName("orgNumber")
        private String orgNumber;
        @SerializedName("toTime")
        private Object toTime;
        @SerializedName("actualCapital")
        private String actualCapital;
        @SerializedName("estiblishTime")
        private long estiblishTime;
        @SerializedName("regInstitute")
        private String regInstitute;
        @SerializedName("businessScope")
        private String businessScope;
        @SerializedName("taxNumber")
        private String taxNumber;
        @SerializedName("regLocation")
        private String regLocation;
        @SerializedName("regCapitalCurrency")
        private String regCapitalCurrency;
        @SerializedName("tags")
        private String tags;
        @SerializedName("district")
        private String district;
        @SerializedName("bondType")
        private String bondType;
        @SerializedName("name")
        private String name;
        @SerializedName("percentileScore")
        private int percentileScore;
        @SerializedName("industryAll")
        private IndustryAll industryAll;
        @SerializedName("isMicroEnt")
        private int isMicroEnt;
        @SerializedName("base")
        private String base;

        public static class IndustryAll {
            @SerializedName("categoryMiddle")
            private String categoryMiddle;
            @SerializedName("categoryBig")
            private String categoryBig;
            @SerializedName("category")
            private String category;
            @SerializedName("categorySmall")
            private String categorySmall;
        }
    }
}