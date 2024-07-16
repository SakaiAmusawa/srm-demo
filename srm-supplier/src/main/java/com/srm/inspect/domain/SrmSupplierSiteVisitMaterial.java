package com.srm.inspect.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商现场考察物料对象 srm_supplier_site_visit_material
 * 
 * @author sakai
 * @date 2024-07-16
 */
public class SrmSupplierSiteVisitMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商现场考察id */
    @Excel(name = "供应商现场考察id")
    private Long investigateId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCode;

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
    public void setInvestigateId(Long investigateId) 
    {
        this.investigateId = investigateId;
    }

    public Long getInvestigateId() 
    {
        return investigateId;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
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
            .append("investigateId", getInvestigateId())
            .append("materialCode", getMaterialCode())
            .append("remarks", getRemarks())
            .toString();
    }
}
