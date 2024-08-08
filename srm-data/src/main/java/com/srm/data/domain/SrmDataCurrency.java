package com.srm.data.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 货币定义对象 srm_data_currency
 * 
 * @author sakai
 * @date 2024-08-08
 */
public class SrmDataCurrency extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 货币代码 */
    @Excel(name = "货币代码")
    private String currencyCode;

    /** 货币名称 */
    @Excel(name = "货币名称")
    private String currencyName;

    /** 国家/地区 */
    @Excel(name = "国家/地区")
    private String country;

    /** 精度 */
    @Excel(name = "精度")
    private Long currencyPrecision;

    /** 货币符号 */
    @Excel(name = "货币符号")
    private String currencySymbol;

    /** 状态 */
    @Excel(name = "状态")
    private Long currencyState;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCurrencyCode(String currencyCode) 
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() 
    {
        return currencyCode;
    }
    public void setCurrencyName(String currencyName) 
    {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() 
    {
        return currencyName;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setCurrencyPrecision(Long currencyPrecision) 
    {
        this.currencyPrecision = currencyPrecision;
    }

    public Long getCurrencyPrecision() 
    {
        return currencyPrecision;
    }
    public void setCurrencySymbol(String currencySymbol) 
    {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencySymbol() 
    {
        return currencySymbol;
    }
    public void setCurrencyState(Long currencyState) 
    {
        this.currencyState = currencyState;
    }

    public Long getCurrencyState() 
    {
        return currencyState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("currencyCode", getCurrencyCode())
            .append("currencyName", getCurrencyName())
            .append("country", getCountry())
            .append("currencyPrecision", getCurrencyPrecision())
            .append("currencySymbol", getCurrencySymbol())
            .append("currencyState", getCurrencyState())
            .toString();
    }
}
