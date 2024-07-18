package com.srm.unity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 计量单位定义对象 srm_unit_def
 * 
 * @author ruoyi
 * @date 2024-07-18
 */
public class SrmUnitDef extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 计量单位编码 */
    private Long unitCode;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String unit;

    /** 转换单位 */
    @Excel(name = "转换单位")
    private String convertUnit;

    /** 转换率 */
    @Excel(name = "转换率")
    private Long convertRate;

    /** 精度 */
    @Excel(name = "精度")
    private Long precision;

    /** 单位类型名称 */
    @Excel(name = "单位类型名称")
    private String unitTypeName;

    /** 来源系统 */
    @Excel(name = "来源系统")
    private String sourceSys;

    /** 状态 */
    @Excel(name = "状态")
    private Long unitStatus;

    public void setUnitCode(Long unitCode) 
    {
        this.unitCode = unitCode;
    }

    public Long getUnitCode() 
    {
        return unitCode;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setConvertUnit(String convertUnit) 
    {
        this.convertUnit = convertUnit;
    }

    public String getConvertUnit() 
    {
        return convertUnit;
    }
    public void setConvertRate(Long convertRate) 
    {
        this.convertRate = convertRate;
    }

    public Long getConvertRate() 
    {
        return convertRate;
    }
    public void setPrecision(Long precision) 
    {
        this.precision = precision;
    }

    public Long getPrecision() 
    {
        return precision;
    }
    public void setUnitTypeName(String unitTypeName) 
    {
        this.unitTypeName = unitTypeName;
    }

    public String getUnitTypeName() 
    {
        return unitTypeName;
    }
    public void setSourceSys(String sourceSys) 
    {
        this.sourceSys = sourceSys;
    }

    public String getSourceSys() 
    {
        return sourceSys;
    }
    public void setUnitStatus(Long unitStatus) 
    {
        this.unitStatus = unitStatus;
    }

    public Long getUnitStatus() 
    {
        return unitStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("unitCode", getUnitCode())
            .append("unit", getUnit())
            .append("convertUnit", getConvertUnit())
            .append("convertRate", getConvertRate())
            .append("precision", getPrecision())
            .append("unitTypeName", getUnitTypeName())
            .append("sourceSys", getSourceSys())
            .append("unitStatus", getUnitStatus())
            .toString();
    }
}
