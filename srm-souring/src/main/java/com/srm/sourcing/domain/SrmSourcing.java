package com.srm.sourcing.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 询价台对象 srm_sourcing
 *
 * @author sakai
 * @date 2024-08-12
 */
public class SrmSourcing extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 寻源单号
     */
    @Excel(name = "寻源单号")
    private String sourcingSerial;

    /**
     * 寻源标题
     */
    @Excel(name = "寻源标题")
    private String sourcingTitle;

    /**
     * 寻源模板
     */
    @Excel(name = "寻源模板")
    private Long sourcingTemplate;

    /**
     * 寻源类别
     */
    @Excel(name = "寻源类别")
    private Long sourcingClass;

    /**
     * 公司
     */
    @Excel(name = "公司")
    private String company;

    /**
     * 采购组织
     */
    @Excel(name = "采购组织")
    private String purchasingOrganization;

    /**
     * 需求部门
     */
    @Excel(name = "需求部门")
    private String sectorDemand;

    /**
     * 创建人部门
     */
    @Excel(name = "创建人部门")
    private String creatorDept;

    /**
     * 轮次
     */
    @Excel(name = "轮次")
    private Long round;

    /**
     * 寻源类型
     */
    @Excel(name = "寻源类型")
    private Long sourcingType;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    /**
     * 预算金额
     */
    @Excel(name = "预算金额")
    private Long budgetAmount;

    /**
     * 币种
     */
    @Excel(name = "币种")
    private String currencyType;

    /**
     * 采购员
     */
    @Excel(name = "采购员")
    private String buyer;

    /**
     * 报价开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报价开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date quotationStartTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date quotationEndTime;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String creator;

    /**
     * 初审人员
     */
    @Excel(name = "初审人员")
    private String firstAuditor;

    /**
     * 核价人员
     */
    @Excel(name = "核价人员")
    private String priceAssessor;

    /**
     * 预留字段
     */
    @Excel(name = "预留字段")
    private Long reserved1;

    /**
     * 预留字段
     */
    @Excel(name = "预留字段")
    private Long reserved2;

    /**
     * 预留字段
     */
    @Excel(name = "预留字段")
    private Long reserved3;

    /**
     * 预留字段
     */
    @Excel(name = "预留字段")
    private Long reserved4;

    /**
     * 预留字段
     */
    @Excel(name = "预留字段")
    private Long reserved5;

    /**
     * 寻源物料明细信息
     */
    private List<SrmSourcingMaterialDetail> srmSourcingMaterialDetailList;

    /**
     * 寻源供应商明细信息
     */
    private List<SrmSourcingSupplierDetail> srmSourcingSupplierDetailList;

    /** 寻源附件信息 */
    private List<SrmSourcingAttachment> srmSourcingAttachmentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourcingSerial() {
        return sourcingSerial;
    }

    public void setSourcingSerial(String sourcingSerial) {
        this.sourcingSerial = sourcingSerial;
    }

    public String getSourcingTitle() {
        return sourcingTitle;
    }

    public void setSourcingTitle(String sourcingTitle) {
        this.sourcingTitle = sourcingTitle;
    }

    public Long getSourcingTemplate() {
        return sourcingTemplate;
    }

    public void setSourcingTemplate(Long sourcingTemplate) {
        this.sourcingTemplate = sourcingTemplate;
    }

    public Long getSourcingClass() {
        return sourcingClass;
    }

    public void setSourcingClass(Long sourcingClass) {
        this.sourcingClass = sourcingClass;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPurchasingOrganization() {
        return purchasingOrganization;
    }

    public void setPurchasingOrganization(String purchasingOrganization) {
        this.purchasingOrganization = purchasingOrganization;
    }

    public String getSectorDemand() {
        return sectorDemand;
    }

    public void setSectorDemand(String sectorDemand) {
        this.sectorDemand = sectorDemand;
    }

    public String getCreatorDept() {
        return creatorDept;
    }

    public void setCreatorDept(String creatorDept) {
        this.creatorDept = creatorDept;
    }

    public Long getRound() {
        return round;
    }

    public void setRound(Long round) {
        this.round = round;
    }

    public Long getSourcingType() {
        return sourcingType;
    }

    public void setSourcingType(Long sourcingType) {
        this.sourcingType = sourcingType;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Long budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Date getQuotationStartTime() {
        return quotationStartTime;
    }

    public void setQuotationStartTime(Date quotationStartTime) {
        this.quotationStartTime = quotationStartTime;
    }

    public Date getQuotationEndTime() {
        return quotationEndTime;
    }

    public void setQuotationEndTime(Date quotationEndTime) {
        this.quotationEndTime = quotationEndTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getFirstAuditor() {
        return firstAuditor;
    }

    public void setFirstAuditor(String firstAuditor) {
        this.firstAuditor = firstAuditor;
    }

    public String getPriceAssessor() {
        return priceAssessor;
    }

    public void setPriceAssessor(String priceAssessor) {
        this.priceAssessor = priceAssessor;
    }

    public Long getReserved1() {
        return reserved1;
    }

    public void setReserved1(Long reserved1) {
        this.reserved1 = reserved1;
    }

    public Long getReserved2() {
        return reserved2;
    }

    public void setReserved2(Long reserved2) {
        this.reserved2 = reserved2;
    }

    public Long getReserved3() {
        return reserved3;
    }

    public void setReserved3(Long reserved3) {
        this.reserved3 = reserved3;
    }

    public Long getReserved4() {
        return reserved4;
    }

    public void setReserved4(Long reserved4) {
        this.reserved4 = reserved4;
    }

    public Long getReserved5() {
        return reserved5;
    }

    public void setReserved5(Long reserved5) {
        this.reserved5 = reserved5;
    }

    public List<SrmSourcingMaterialDetail> getSrmSourcingMaterialDetailList() {
        return srmSourcingMaterialDetailList;
    }

    public void setSrmSourcingMaterialDetailList(List<SrmSourcingMaterialDetail> srmSourcingMaterialDetailList) {
        this.srmSourcingMaterialDetailList = srmSourcingMaterialDetailList;
    }

    public List<SrmSourcingSupplierDetail> getSrmSourcingSupplierDetailList() {
        return srmSourcingSupplierDetailList;
    }

    public void setSrmSourcingSupplierDetailList(List<SrmSourcingSupplierDetail> srmSourcingSupplierDetailList) {
        this.srmSourcingSupplierDetailList = srmSourcingSupplierDetailList;
    }

    public List<SrmSourcingAttachment> getSrmSourcingAttachmentList() {
        return srmSourcingAttachmentList;
    }

    public void setSrmSourcingAttachmentList(List<SrmSourcingAttachment> srmSourcingAttachmentList) {
        this.srmSourcingAttachmentList = srmSourcingAttachmentList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sourcingSerial", getSourcingSerial())
                .append("sourcingTitle", getSourcingTitle())
                .append("sourcingTemplate", getSourcingTemplate())
                .append("sourcingType", getSourcingClass())
                .append("company", getCompany())
                .append("purchasingOrganizationId", getPurchasingOrganization())
                .append("sectorDemandId", getSectorDemand())
                .append("creatorDeptId", getCreatorDept())
                .append("round", getRound())
                .append("sourcingType", getSourcingType())
                .append("state", getState())
                .append("budgetAmount", getBudgetAmount())
                .append("currencyType", getCurrencyType())
                .append("createTime", getCreateTime())
                .append("buyer", getBuyer())
                .append("quotationStartTime", getQuotationStartTime())
                .append("quotationEndTime", getQuotationEndTime())
                .append("creator", getCreator())
                .append("remark", getRemark())
                .append("firstAuditor", getFirstAuditor())
                .append("priceAssessor", getPriceAssessor())
                .append("reserved1", getReserved1())
                .append("reserved2", getReserved2())
                .append("reserved3", getReserved3())
                .append("reserved4", getReserved4())
                .append("reserved5", getReserved5())
                .append("srmSourcingMaterialDetailList", getSrmSourcingMaterialDetailList())
                .append("srmSourcingSupplierDetailList",getSrmSourcingSupplierDetailList())
                .append("srmSourcingAttachmentList",getSrmSourcingAttachmentList())
                .toString();
    }
}
