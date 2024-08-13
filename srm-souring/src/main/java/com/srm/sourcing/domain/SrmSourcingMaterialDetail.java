package com.srm.sourcing.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 寻源物料明细对象 srm_sourcing_material_detail
 *
 * @author sakai
 * @date 2024-08-12
 */
public class SrmSourcingMaterialDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 物料名称
     */
    @Excel(name = "物料名称")
    private String materialName;

    /**
     * 物料编码
     */
    @Excel(name = "物料编码")
    private String materialCode;

    /**
     * 物料名称
     */
    @Excel(name = "物料名称")
    private String categoryName;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unit;

    /**
     * 参考价格
     */
    @Excel(name = "参考价格")
    private Long referencePrice;

    /**
     * 需求数量
     */
    @Excel(name = "需求数量")
    private Long requirementNumber;

    /**
     * 预估单价（不含税）
     */
    @Excel(name = "预估单价", readConverterExp = "不=含税")
    private Long estimatedUnitPrice;

    /**
     * 税率代码
     */
    @Excel(name = "税率代码")
    private String taxCode;

    /**
     * 税率值（%）
     */
    @Excel(name = "税率值", readConverterExp = "%=")
    private Long taxRate;

    /**
     * 需求日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requirementDate;

    /**
     * 申请行号
     */
    @Excel(name = "申请行号")
    private Long requestLineNumber;

    /**
     * 采购申请行号
     */
    @Excel(name = "采购申请行号")
    private Long purchaseRequestLineNumber;

    /**
     * 询价单附件
     */
    @Excel(name = "询价单附件")
    private String inquiryListAttachment;

    /**
     * 寻源ID
     */
    @Excel(name = "寻源ID")
    private Long sourcingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(Long referencePrice) {
        this.referencePrice = referencePrice;
    }

    public Long getRequirementNumber() {
        return requirementNumber;
    }

    public void setRequirementNumber(Long requirementNumber) {
        this.requirementNumber = requirementNumber;
    }

    public Long getEstimatedUnitPrice() {
        return estimatedUnitPrice;
    }

    public void setEstimatedUnitPrice(Long estimatedUnitPrice) {
        this.estimatedUnitPrice = estimatedUnitPrice;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public Date getRequirementDate() {
        return requirementDate;
    }

    public void setRequirementDate(Date requirementDate) {
        this.requirementDate = requirementDate;
    }

    public Long getRequestLineNumber() {
        return requestLineNumber;
    }

    public void setRequestLineNumber(Long requestLineNumber) {
        this.requestLineNumber = requestLineNumber;
    }

    public Long getPurchaseRequestLineNumber() {
        return purchaseRequestLineNumber;
    }

    public void setPurchaseRequestLineNumber(Long purchaseRequestLineNumber) {
        this.purchaseRequestLineNumber = purchaseRequestLineNumber;
    }

    public String getInquiryListAttachment() {
        return inquiryListAttachment;
    }

    public void setInquiryListAttachment(String inquiryListAttachment) {
        this.inquiryListAttachment = inquiryListAttachment;
    }

    public Long getSourcingId() {
        return sourcingId;
    }

    public void setSourcingId(Long sourcingId) {
        this.sourcingId = sourcingId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("materialName", getMaterialName())
                .append("materialCode", getMaterialCode())
                .append("categoryName", getCategoryName())
                .append("unit", getUnit())
                .append("referencePrice", getReferencePrice())
                .append("requirementNumber", getRequirementNumber())
                .append("estimatedUnitPrice", getEstimatedUnitPrice())
                .append("taxCode", getTaxCode())
                .append("taxRate", getTaxRate())
                .append("requirementDate", getRequirementDate())
                .append("requestLineNumber", getRequestLineNumber())
                .append("purchaseRequestLineNumber", getPurchaseRequestLineNumber())
                .append("inquiryListAttachment", getInquiryListAttachment())
                .append("sourcingId", getSourcingId())
                .toString();
    }
}
