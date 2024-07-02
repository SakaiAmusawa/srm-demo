package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商地址信息对象 srm_supplier_address_information
 * 
 * @author sakai
 * @date 2024-07-01
 */
public class SrmSupplierAddressInformation extends BaseEntity
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

    /** 省/市/区 */
    @Excel(name = "省/市/区")
    private String pcd;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailedAddress;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String zipcode;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

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
    public void setPcd(String pcd) 
    {
        this.pcd = pcd;
    }

    public String getPcd() 
    {
        return pcd;
    }
    public void setDetailedAddress(String detailedAddress) 
    {
        this.detailedAddress = detailedAddress;
    }

    public String getDetailedAddress() 
    {
        return detailedAddress;
    }
    public void setZipcode(String zipcode) 
    {
        this.zipcode = zipcode;
    }

    public String getZipcode() 
    {
        return zipcode;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierId", getSupplierId())
            .append("country", getCountry())
            .append("pcd", getPcd())
            .append("detailedAddress", getDetailedAddress())
            .append("zipcode", getZipcode())
            .append("remarks", getRemarks())
            .toString();
    }
}
