package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商开票信息对象 srm_supplier_invoice_information
 * 
 * @author sakai
 * @date 2024-07-01
 */
public class SrmSupplierInvoiceInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商信息主键 */
    @Excel(name = "供应商信息主键")
    private Long supplierId;

    /** 发票头 */
    @Excel(name = "发票头")
    private String invoiceHeader;

    /** 税务登记号 */
    @Excel(name = "税务登记号")
    private String taxRegistration;

    /** 开户行账号 */
    @Excel(name = "开户行账号")
    private String firstBankNum;

    /** 开户行名称 */
    @Excel(name = "开户行名称")
    private String firstBank;

    /** 税务登记地址 */
    @Excel(name = "税务登记地址")
    private String taxRegistrationAdd;

    /** 税务登记电话 */
    @Excel(name = "税务登记电话")
    private String taxRegistrationPhone;

    /** 收票人邮箱 */
    @Excel(name = "收票人邮箱")
    private String recipientEmail;

    /** 收票人手机号 */
    @Excel(name = "收票人手机号")
    private String recipientPhone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setInvoiceHeader(String invoiceHeader) 
    {
        this.invoiceHeader = invoiceHeader;
    }

    public String getInvoiceHeader() 
    {
        return invoiceHeader;
    }
    public void setTaxRegistration(String taxRegistration) 
    {
        this.taxRegistration = taxRegistration;
    }

    public String getTaxRegistration() 
    {
        return taxRegistration;
    }
    public void setFirstBankNum(String firstBankNum) 
    {
        this.firstBankNum = firstBankNum;
    }

    public String getFirstBankNum() 
    {
        return firstBankNum;
    }
    public void setFirstBank(String firstBank) 
    {
        this.firstBank = firstBank;
    }

    public String getFirstBank() 
    {
        return firstBank;
    }
    public void setTaxRegistrationAdd(String taxRegistrationAdd) 
    {
        this.taxRegistrationAdd = taxRegistrationAdd;
    }

    public String getTaxRegistrationAdd() 
    {
        return taxRegistrationAdd;
    }
    public void setTaxRegistrationPhone(String taxRegistrationPhone) 
    {
        this.taxRegistrationPhone = taxRegistrationPhone;
    }

    public String getTaxRegistrationPhone() 
    {
        return taxRegistrationPhone;
    }
    public void setRecipientEmail(String recipientEmail) 
    {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientEmail() 
    {
        return recipientEmail;
    }
    public void setRecipientPhone(String recipientPhone) 
    {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientPhone() 
    {
        return recipientPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierId", getSupplierId())
            .append("invoiceHeader", getInvoiceHeader())
            .append("taxRegistration", getTaxRegistration())
            .append("firstBankNum", getFirstBankNum())
            .append("firstBank", getFirstBank())
            .append("taxRegistrationAdd", getTaxRegistrationAdd())
            .append("taxRegistrationPhone", getTaxRegistrationPhone())
            .append("recipientEmail", getRecipientEmail())
            .append("recipientPhone", getRecipientPhone())
            .toString();
    }
}
