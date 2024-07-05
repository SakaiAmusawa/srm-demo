package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商分类定义对象 srm_supplier_class_definition
 * 
 * @author ruoyi
 * @date 2024-07-05
 */
public class SrmSupplierClassDefinition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商分类信息 */
    @Excel(name = "供应商分类信息")
    private String supplierClass;

    /** 供应商分类编码 */
    @Excel(name = "供应商分类编码")
    private String supplierClassCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierClass(String supplierClass) 
    {
        this.supplierClass = supplierClass;
    }

    public String getSupplierClass() 
    {
        return supplierClass;
    }
    public void setSupplierClassCode(String supplierClassCode) 
    {
        this.supplierClassCode = supplierClassCode;
    }

    public String getSupplierClassCode() 
    {
        return supplierClassCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierClass", getSupplierClass())
            .append("supplierClassCode", getSupplierClassCode())
            .toString();
    }
}
