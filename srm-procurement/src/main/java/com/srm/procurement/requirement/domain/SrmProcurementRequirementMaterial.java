package com.srm.procurement.requirement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 采购需求物料对象 srm_procurement_requirement_material
 * 
 * @author Sakai
 * @date 2024-08-07
 */
public class SrmProcurementRequirementMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 物料品类 */
    @Excel(name = "物料品类")
    private String categoryName;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long requirementNumber;

    /** 需求日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requirementDate;

    /** 币种 */
    @Excel(name = "币种")
    private String currency;

    /** 参考价格 */
    @Excel(name = "参考价格")
    private Long referencePrice;

    /** 预算单价（不含税） */
    @Excel(name = "预算单价", readConverterExp = "不=含税")
    private Long estimatedUnitPrice;

    /** 税率 */
    @Excel(name = "税率")
    private String taxRate;

    /** 税率值 */
    @Excel(name = "税率值")
    private Long taxRateValue;

    /** 预算金额 */
    @Excel(name = "预算金额")
    private Long estimatedPrice;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    /** 采购员 */
    @Excel(name = "采购员")
    private String buyer;

    /** 采购需求唯一标识 */
    @Excel(name = "采购需求唯一标识")
    private Long procurementRequirementId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setRequirementNumber(Long requirementNumber) 
    {
        this.requirementNumber = requirementNumber;
    }

    public Long getRequirementNumber() 
    {
        return requirementNumber;
    }
    public void setRequirementDate(Date requirementDate) 
    {
        this.requirementDate = requirementDate;
    }

    public Date getRequirementDate() 
    {
        return requirementDate;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setReferencePrice(Long referencePrice) 
    {
        this.referencePrice = referencePrice;
    }

    public Long getReferencePrice() 
    {
        return referencePrice;
    }
    public void setEstimatedUnitPrice(Long estimatedUnitPrice) 
    {
        this.estimatedUnitPrice = estimatedUnitPrice;
    }

    public Long getEstimatedUnitPrice() 
    {
        return estimatedUnitPrice;
    }
    public void setTaxRate(String taxRate) 
    {
        this.taxRate = taxRate;
    }

    public String getTaxRate() 
    {
        return taxRate;
    }
    public void setTaxRateValue(Long taxRateValue) 
    {
        this.taxRateValue = taxRateValue;
    }

    public Long getTaxRateValue() 
    {
        return taxRateValue;
    }
    public void setEstimatedPrice(Long estimatedPrice) 
    {
        this.estimatedPrice = estimatedPrice;
    }

    public Long getEstimatedPrice() 
    {
        return estimatedPrice;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setBuyer(String buyer) 
    {
        this.buyer = buyer;
    }

    public String getBuyer() 
    {
        return buyer;
    }
    public void setProcurementRequirementId(Long procurementRequirementId) 
    {
        this.procurementRequirementId = procurementRequirementId;
    }

    public Long getProcurementRequirementId() 
    {
        return procurementRequirementId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("categoryName", getCategoryName())
            .append("brand", getBrand())
            .append("unit", getUnit())
            .append("requirementNumber", getRequirementNumber())
            .append("requirementDate", getRequirementDate())
            .append("currency", getCurrency())
            .append("referencePrice", getReferencePrice())
            .append("estimatedUnitPrice", getEstimatedUnitPrice())
            .append("taxRate", getTaxRate())
            .append("taxRateValue", getTaxRateValue())
            .append("estimatedPrice", getEstimatedPrice())
            .append("remark", getRemark())
            .append("attachment", getAttachment())
            .append("buyer", getBuyer())
            .append("procurementRequirementId", getProcurementRequirementId())
            .toString();
    }
}
