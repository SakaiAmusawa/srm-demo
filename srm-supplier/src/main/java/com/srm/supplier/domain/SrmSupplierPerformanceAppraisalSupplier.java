package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 绩效考评参评供应商对象 srm_supplier_performance_appraisal_supplier
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class SrmSupplierPerformanceAppraisalSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 绩效考评ID */
    @Excel(name = "绩效考评ID")
    private Long performanceAppraisalId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPerformanceAppraisalId(Long performanceAppraisalId) 
    {
        this.performanceAppraisalId = performanceAppraisalId;
    }

    public Long getPerformanceAppraisalId() 
    {
        return performanceAppraisalId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierCode(String supplierCode) 
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() 
    {
        return supplierCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("performanceAppraisalId", getPerformanceAppraisalId())
            .append("supplierName", getSupplierName())
            .append("supplierCode", getSupplierCode())
            .toString();
    }
}
