package com.srm.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商联系人信息对象 srm_supplier_contact_information
 * 
 * @author ruoyi
 * @date 2024-07-01
 */
public class SrmSupplierContactInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Long gender;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 部门 */
    @Excel(name = "部门")
    private String department;

    /** 固定电话 */
    @Excel(name = "固定电话")
    private String telephone;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private String documentType;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String documentCode;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 供应商信息主键 */
    @Excel(name = "供应商信息主键")
    private Long supplierId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setDocumentType(String documentType) 
    {
        this.documentType = documentType;
    }

    public String getDocumentType() 
    {
        return documentType;
    }
    public void setDocumentCode(String documentCode) 
    {
        this.documentCode = documentCode;
    }

    public String getDocumentCode() 
    {
        return documentCode;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("gender", getGender())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("department", getDepartment())
            .append("telephone", getTelephone())
            .append("documentType", getDocumentType())
            .append("documentCode", getDocumentCode())
            .append("remarks", getRemarks())
            .append("supplierId", getSupplierId())
            .toString();
    }
}
