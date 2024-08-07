package com.srm.procurement.requirement.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 采购需求对象 srm_procurement_requirement
 * 
 * @author Sakai
 * @date 2024-08-07
 */
public class SrmProcurementRequirement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 需求编号 */
    @Excel(name = "需求编号")
    private String requirementSerial;

    /** 需求标题 */
    @Excel(name = "需求标题")
    private String requirementTitle;

    /** 需求创建人 */
    @Excel(name = "需求创建人")
    private String requirementCreator;

    /** 创建部门 */
    @Excel(name = "创建部门")
    private String requirementDepartment;

    /** 需求人 */
    @Excel(name = "需求人")
    private String demander;

    /** 需求部门 */
    @Excel(name = "需求部门")
    private String sectorDemand;

    /** 公司 */
    @Excel(name = "公司")
    private String company;

    /** 需求类型 */
    @Excel(name = "需求类型")
    private Long requirementType;

    /** 预估总金额 */
    @Excel(name = "预估总金额")
    private Double estimatedAmount;

    /** 收货联系人 */
    @Excel(name = "收货联系人")
    private String receivingContact;

    /** 费用部门 */
    @Excel(name = "费用部门")
    private String expenseDepartment;

    /** 用途说明 */
    @Excel(name = "用途说明")
    private String useDescription;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String addressDetail;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInformation;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    /** 货币币种 */
    @Excel(name = "货币币种")
    private Long currency;

    /** 采购需求物料信息 */
    private List<SrmProcurementRequirementMaterial> srmProcurementRequirementMaterialList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRequirementSerial(String requirementSerial) 
    {
        this.requirementSerial = requirementSerial;
    }

    public String getRequirementSerial() 
    {
        return requirementSerial;
    }
    public void setRequirementTitle(String requirementTitle) 
    {
        this.requirementTitle = requirementTitle;
    }

    public String getRequirementTitle() 
    {
        return requirementTitle;
    }
    public void setRequirementCreator(String requirementCreator) 
    {
        this.requirementCreator = requirementCreator;
    }

    public String getRequirementCreator() 
    {
        return requirementCreator;
    }
    public void setRequirementDepartment(String requirementDepartment) 
    {
        this.requirementDepartment = requirementDepartment;
    }

    public String getRequirementDepartment() 
    {
        return requirementDepartment;
    }
    public void setDemander(String demander) 
    {
        this.demander = demander;
    }

    public String getDemander() 
    {
        return demander;
    }
    public void setSectorDemand(String sectorDemand) 
    {
        this.sectorDemand = sectorDemand;
    }

    public String getSectorDemand() 
    {
        return sectorDemand;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setRequirementType(Long requirementType) 
    {
        this.requirementType = requirementType;
    }

    public Long getRequirementType() 
    {
        return requirementType;
    }
    public void setEstimatedAmount(Double estimatedAmount) 
    {
        this.estimatedAmount = estimatedAmount;
    }

    public Double getEstimatedAmount() 
    {
        return estimatedAmount;
    }
    public void setReceivingContact(String receivingContact) 
    {
        this.receivingContact = receivingContact;
    }

    public String getReceivingContact() 
    {
        return receivingContact;
    }
    public void setExpenseDepartment(String expenseDepartment) 
    {
        this.expenseDepartment = expenseDepartment;
    }

    public String getExpenseDepartment() 
    {
        return expenseDepartment;
    }
    public void setUseDescription(String useDescription) 
    {
        this.useDescription = useDescription;
    }

    public String getUseDescription() 
    {
        return useDescription;
    }
    public void setAddressDetail(String addressDetail) 
    {
        this.addressDetail = addressDetail;
    }

    public String getAddressDetail() 
    {
        return addressDetail;
    }
    public void setContactInformation(String contactInformation) 
    {
        this.contactInformation = contactInformation;
    }

    public String getContactInformation() 
    {
        return contactInformation;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setCurrency(Long currency) 
    {
        this.currency = currency;
    }

    public Long getCurrency() 
    {
        return currency;
    }

    public List<SrmProcurementRequirementMaterial> getSrmProcurementRequirementMaterialList()
    {
        return srmProcurementRequirementMaterialList;
    }

    public void setSrmProcurementRequirementMaterialList(List<SrmProcurementRequirementMaterial> srmProcurementRequirementMaterialList)
    {
        this.srmProcurementRequirementMaterialList = srmProcurementRequirementMaterialList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("requirementSerial", getRequirementSerial())
            .append("requirementTitle", getRequirementTitle())
            .append("requirementCreator", getRequirementCreator())
            .append("requirementDepartment", getRequirementDepartment())
            .append("createTime", getCreateTime())
            .append("demander", getDemander())
            .append("sectorDemand", getSectorDemand())
            .append("company", getCompany())
            .append("requirementType", getRequirementType())
            .append("estimatedAmount", getEstimatedAmount())
            .append("receivingContact", getReceivingContact())
            .append("expenseDepartment", getExpenseDepartment())
            .append("useDescription", getUseDescription())
            .append("addressDetail", getAddressDetail())
            .append("contactInformation", getContactInformation())
            .append("attachment", getAttachment())
            .append("currency", getCurrency())
            .append("srmProcurementRequirementMaterialList", getSrmProcurementRequirementMaterialList())
            .toString();
    }
}
