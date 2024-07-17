package com.srm.unity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 计量单位类型定义对象 srm_unit_type_definition
 * 
 * @author ruoyi
 * @date 2024-07-17
 */
public class SrmUnitTypeDefinition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 单位类型代码 */
    private Long id;

    /** 单位类型名称 */
    @Excel(name = "单位类型名称")
    private String unitTypeName;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUnitTypeName(String unitTypeName) 
    {
        this.unitTypeName = unitTypeName;
    }

    public String getUnitTypeName() 
    {
        return unitTypeName;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("unitTypeName", getUnitTypeName())
            .append("status", getStatus())
            .toString();
    }
}
