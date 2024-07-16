package com.srm.inspect.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商现场考察人员对象 srm_supplier_site_visit_user
 * 
 * @author sakai
 * @date 2024-07-16
 */
public class SrmSupplierSiteVisitUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商现场考察id */
    @Excel(name = "供应商现场考察id")
    private Long investigateId;

    /** 人员编码 */
    @Excel(name = "人员编码")
    private String userCode;

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
    public void setUserCode(String userCode) 
    {
        this.userCode = userCode;
    }

    public String getUserCode() 
    {
        return userCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("investigateId", getInvestigateId())
            .append("userCode", getUserCode())
            .toString();
    }
}
