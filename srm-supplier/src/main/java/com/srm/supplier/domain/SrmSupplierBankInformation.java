package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商银行信息对象 srm_supplier_bank_information
 * 
 * @author sakai
 * @date 2024-07-01
 */
public class SrmSupplierBankInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商信息主键 */
    @Excel(name = "供应商信息主键")
    private Long supplierId;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 银行代码 */
    @Excel(name = "银行代码")
    private String bankCode;

    /** 银行名称 */
    @Excel(name = "银行名称")
    private String bankName;

    /** 联行行号 */
    @Excel(name = "联行行号")
    private String interbankAccount;

    /** 开户行名称 */
    @Excel(name = "开户行名称")
    private String firstBank;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String account;

    /** 银行账号 */
    @Excel(name = "银行账号")
    private String bankAccount;

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
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setBankCode(String bankCode) 
    {
        this.bankCode = bankCode;
    }

    public String getBankCode() 
    {
        return bankCode;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setInterbankAccount(String interbankAccount) 
    {
        this.interbankAccount = interbankAccount;
    }

    public String getInterbankAccount() 
    {
        return interbankAccount;
    }
    public void setFirstBank(String firstBank) 
    {
        this.firstBank = firstBank;
    }

    public String getFirstBank() 
    {
        return firstBank;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setBankAccount(String bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() 
    {
        return bankAccount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierId", getSupplierId())
            .append("country", getCountry())
            .append("bankCode", getBankCode())
            .append("bankName", getBankName())
            .append("interbankAccount", getInterbankAccount())
            .append("firstBank", getFirstBank())
            .append("account", getAccount())
            .append("bankAccount", getBankAccount())
            .toString();
    }
}
