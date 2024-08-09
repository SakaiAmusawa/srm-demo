package com.srm.sourcing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 询报价模板定义对象 srm_inquiry_quotation_template
 * 
 * @author sakai
 * @date 2024-08-09
 */
public class SrmInquiryQuotationTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 模板编码 */
    @Excel(name = "模板编码")
    private String templateCode;

    /** 模板名称 */
    @Excel(name = "模板名称")
    private String templateName;

    /** 寻源类别 */
    @Excel(name = "寻源类别")
    private Long sourceClass;

    /** 版本 */
    @Excel(name = "版本")
    private Long version;

    /** 状态 */
    @Excel(name = "状态")
    private Long templateState;

    /** 模板描述 */
    @Excel(name = "模板描述")
    private String templateDescription;

    /** 寻源初审 */
    @Excel(name = "寻源初审")
    private Long sourceFirstReview;

    /** 资格预审 */
    @Excel(name = "资格预审")
    private Long prequalification;

    /** 多轮报价规则 */
    @Excel(name = "多轮报价规则")
    private Long multipleRoundOfferRules;

    /** 结果审批 */
    @Excel(name = "结果审批")
    private Long resultApproval;

    /** 寻源方式 */
    @Excel(name = "寻源方式")
    private Long sourceMethod;

    /** 报价范围 */
    @Excel(name = "报价范围")
    private Long offerRange;

    /** 寻源类型 */
    @Excel(name = "寻源类型")
    private Long sourceType;

    /** 报价方向 */
    @Excel(name = "报价方向")
    private Long offerType;

    /** 密封报价 */
    @Excel(name = "密封报价")
    private Long sealedBid;

    /** 最大供应商数量 */
    @Excel(name = "最大供应商数量")
    private Long maxSupplierNumber;

    /** 最小供应商数量 */
    @Excel(name = "最小供应商数量")
    private Long minSupplierNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTemplateCode(String templateCode) 
    {
        this.templateCode = templateCode;
    }

    public String getTemplateCode() 
    {
        return templateCode;
    }
    public void setTemplateName(String templateName) 
    {
        this.templateName = templateName;
    }

    public String getTemplateName() 
    {
        return templateName;
    }
    public void setSourceClass(Long sourceClass) 
    {
        this.sourceClass = sourceClass;
    }

    public Long getSourceClass() 
    {
        return sourceClass;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }
    public void setTemplateState(Long templateState) 
    {
        this.templateState = templateState;
    }

    public Long getTemplateState() 
    {
        return templateState;
    }
    public void setTemplateDescription(String templateDescription) 
    {
        this.templateDescription = templateDescription;
    }

    public String getTemplateDescription() 
    {
        return templateDescription;
    }
    public void setSourceFirstReview(Long sourceFirstReview) 
    {
        this.sourceFirstReview = sourceFirstReview;
    }

    public Long getSourceFirstReview() 
    {
        return sourceFirstReview;
    }
    public void setPrequalification(Long prequalification) 
    {
        this.prequalification = prequalification;
    }

    public Long getPrequalification() 
    {
        return prequalification;
    }
    public void setMultipleRoundOfferRules(Long multipleRoundOfferRules) 
    {
        this.multipleRoundOfferRules = multipleRoundOfferRules;
    }

    public Long getMultipleRoundOfferRules() 
    {
        return multipleRoundOfferRules;
    }
    public void setResultApproval(Long resultApproval) 
    {
        this.resultApproval = resultApproval;
    }

    public Long getResultApproval() 
    {
        return resultApproval;
    }
    public void setSourceMethod(Long sourceMethod) 
    {
        this.sourceMethod = sourceMethod;
    }

    public Long getSourceMethod() 
    {
        return sourceMethod;
    }
    public void setOfferRange(Long offerRange) 
    {
        this.offerRange = offerRange;
    }

    public Long getOfferRange() 
    {
        return offerRange;
    }
    public void setSourceType(Long sourceType) 
    {
        this.sourceType = sourceType;
    }

    public Long getSourceType() 
    {
        return sourceType;
    }
    public void setOfferType(Long offerType) 
    {
        this.offerType = offerType;
    }

    public Long getOfferType() 
    {
        return offerType;
    }
    public void setSealedBid(Long sealedBid) 
    {
        this.sealedBid = sealedBid;
    }

    public Long getSealedBid() 
    {
        return sealedBid;
    }
    public void setMaxSupplierNumber(Long maxSupplierNumber) 
    {
        this.maxSupplierNumber = maxSupplierNumber;
    }

    public Long getMaxSupplierNumber() 
    {
        return maxSupplierNumber;
    }
    public void setMinSupplierNumber(Long minSupplierNumber) 
    {
        this.minSupplierNumber = minSupplierNumber;
    }

    public Long getMinSupplierNumber() 
    {
        return minSupplierNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("templateCode", getTemplateCode())
            .append("templateName", getTemplateName())
            .append("sourceClass", getSourceClass())
            .append("version", getVersion())
            .append("templateState", getTemplateState())
            .append("templateDescription", getTemplateDescription())
            .append("sourceFirstReview", getSourceFirstReview())
            .append("prequalification", getPrequalification())
            .append("multipleRoundOfferRules", getMultipleRoundOfferRules())
            .append("resultApproval", getResultApproval())
            .append("sourceMethod", getSourceMethod())
            .append("offerRange", getOfferRange())
            .append("sourceType", getSourceType())
            .append("offerType", getOfferType())
            .append("sealedBid", getSealedBid())
            .append("maxSupplierNumber", getMaxSupplierNumber())
            .append("minSupplierNumber", getMinSupplierNumber())
            .toString();
    }
}
