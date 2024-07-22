package com.srm.sample.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 送样方信息对象 srm_supplier_sample_sender
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public class SrmSupplierSampleSender extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 送样ID */
    @Excel(name = "送样ID")
    private Long sampleId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactsPhone;

    /** 送样方式分类 */
    @Excel(name = "送样方式分类")
    private Long sampleDeliveryMethod;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSampleId(Long sampleId) 
    {
        this.sampleId = sampleId;
    }

    public Long getSampleId() 
    {
        return sampleId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setContactsPhone(String contactsPhone) 
    {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsPhone() 
    {
        return contactsPhone;
    }
    public void setSampleDeliveryMethod(Long sampleDeliveryMethod) 
    {
        this.sampleDeliveryMethod = sampleDeliveryMethod;
    }

    public Long getSampleDeliveryMethod() 
    {
        return sampleDeliveryMethod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sampleId", getSampleId())
            .append("supplierName", getSupplierName())
            .append("contacts", getContacts())
            .append("contactsPhone", getContactsPhone())
            .append("sampleDeliveryMethod", getSampleDeliveryMethod())
            .toString();
    }
}
