package com.srm.supply_anagement.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供货管理对象 srm_supply_management
 * 
 * @author sakai
 * @date 2024-07-17
 */
public class SrmSupplyManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String companyCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String enterprise;

    /** 生命周期 */
    @Excel(name = "生命周期")
    private String lifecycle;

    /** 公司 */
    @Excel(name = "公司")
    private String company;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 创建人部门 */
    @Excel(name = "创建人部门")
    private String creatorDept;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 物料信息信息 */
    private List<SrmMaterialInformation> srmMaterialInformationList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCompanyCode(String companyCode) 
    {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() 
    {
        return companyCode;
    }
    public void setEnterprise(String enterprise) 
    {
        this.enterprise = enterprise;
    }

    public String getEnterprise() 
    {
        return enterprise;
    }
    public void setLifecycle(String lifecycle) 
    {
        this.lifecycle = lifecycle;
    }

    public String getLifecycle() 
    {
        return lifecycle;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setCreatorDept(String creatorDept) 
    {
        this.creatorDept = creatorDept;
    }

    public String getCreatorDept() 
    {
        return creatorDept;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    public List<SrmMaterialInformation> getSrmMaterialInformationList()
    {
        return srmMaterialInformationList;
    }

    public void setSrmMaterialInformationList(List<SrmMaterialInformation> srmMaterialInformationList)
    {
        this.srmMaterialInformationList = srmMaterialInformationList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyCode", getCompanyCode())
            .append("enterprise", getEnterprise())
            .append("lifecycle", getLifecycle())
            .append("company", getCompany())
            .append("creator", getCreator())
            .append("creatorDept", getCreatorDept())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remarks", getRemarks())
            .append("srmMaterialInformationList", getSrmMaterialInformationList())
            .toString();
    }
}
