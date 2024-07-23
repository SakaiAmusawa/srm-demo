package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商经营风险记录对象 srm_supplier_operate_risk
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
public class SrmSupplierOperateRisk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 列入日期的时间戳 */
    @Excel(name = "列入日期的时间戳")
    private Long putDate;

    /** 列入经营异常名录原因 */
    @Excel(name = "列入经营异常名录原因")
    private String putReason;

    /** 作出决定机关 */
    @Excel(name = "作出决定机关")
    private String putDepartment;

    /** 决定移出部门 */
    @Excel(name = "决定移出部门")
    private String removeDepartment;

    /** 移出日期的时间戳 */
    @Excel(name = "移出日期的时间戳")
    private Long removeDate;

    /** 移出经营异常名录原因 */
    @Excel(name = "移出经营异常名录原因")
    private String removeReason;

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
    public void setPutDate(Long putDate) 
    {
        this.putDate = putDate;
    }

    public Long getPutDate() 
    {
        return putDate;
    }
    public void setPutReason(String putReason) 
    {
        this.putReason = putReason;
    }

    public String getPutReason() 
    {
        return putReason;
    }
    public void setPutDepartment(String putDepartment) 
    {
        this.putDepartment = putDepartment;
    }

    public String getPutDepartment() 
    {
        return putDepartment;
    }
    public void setRemoveDepartment(String removeDepartment) 
    {
        this.removeDepartment = removeDepartment;
    }

    public String getRemoveDepartment() 
    {
        return removeDepartment;
    }
    public void setRemoveDate(Long removeDate) 
    {
        this.removeDate = removeDate;
    }

    public Long getRemoveDate() 
    {
        return removeDate;
    }
    public void setRemoveReason(String removeReason) 
    {
        this.removeReason = removeReason;
    }

    public String getRemoveReason() 
    {
        return removeReason;
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
            .append("putDate", getPutDate())
            .append("putReason", getPutReason())
            .append("createTime", getCreateTime())
            .append("putDepartment", getPutDepartment())
            .append("removeDepartment", getRemoveDepartment())
            .append("removeDate", getRemoveDate())
            .append("removeReason", getRemoveReason())
            .append("supplierName", getSupplierName())
            .toString();
    }
}
