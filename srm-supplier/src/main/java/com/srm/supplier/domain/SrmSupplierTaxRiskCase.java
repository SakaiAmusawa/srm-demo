package com.srm.supplier.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商税收违法风险对象 srm_supplier_tax_risk_case
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
public class SrmSupplierTaxRiskCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 案件性质 */
    @Excel(name = "案件性质")
    private String caseType;

    /** 所属税务机关 */
    @Excel(name = "所属税务机关")
    private String department;

    /** 纳税人名称 */
    @Excel(name = "纳税人名称")
    private String taxpayerName;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }
    public void setCaseType(String caseType) 
    {
        this.caseType = caseType;
    }

    public String getCaseType() 
    {
        return caseType;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setTaxpayerName(String taxpayerName) 
    {
        this.taxpayerName = taxpayerName;
    }

    public String getTaxpayerName() 
    {
        return taxpayerName;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("publishTime", getPublishTime())
            .append("caseType", getCaseType())
            .append("department", getDepartment())
            .append("taxpayerName", getTaxpayerName())
            .append("supplierName", getSupplierName())
            .toString();
    }
}
