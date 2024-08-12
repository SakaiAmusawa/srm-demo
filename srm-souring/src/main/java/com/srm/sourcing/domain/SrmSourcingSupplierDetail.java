package com.srm.sourcing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 寻源供应商明细对象 srm_sourcing_supplier_detail
 * 
 * @author sakai
 * @date 2024-08-12
 */
public class SrmSourcingSupplierDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 生命周期 */
    @Excel(name = "生命周期")
    private Long lifeStage;

    /** 风险扫描 */
    @Excel(name = "风险扫描")
    private Long risk;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String telephone;

    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String email;

    /** 寻源ID */
    @Excel(name = "寻源ID")
    private Long sourcingId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierCode(String supplierCode) 
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() 
    {
        return supplierCode;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setLifeStage(Long lifeStage) 
    {
        this.lifeStage = lifeStage;
    }

    public Long getLifeStage() 
    {
        return lifeStage;
    }
    public void setRisk(Long risk) 
    {
        this.risk = risk;
    }

    public Long getRisk() 
    {
        return risk;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setSourcingId(Long sourcingId) 
    {
        this.sourcingId = sourcingId;
    }

    public Long getSourcingId() 
    {
        return sourcingId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierCode", getSupplierCode())
            .append("supplierName", getSupplierName())
            .append("lifeStage", getLifeStage())
            .append("risk", getRisk())
            .append("contacts", getContacts())
            .append("telephone", getTelephone())
            .append("email", getEmail())
            .append("sourcingId", getSourcingId())
            .toString();
    }
}
