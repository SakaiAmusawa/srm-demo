package com.srm.unity.domain;

import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 计量单位定义对象 srm_unit_def
 *
 * @author ruoyi
 * @date 2024-07-18
 */
public class SrmUnitDef extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 计量单位编码
     */
    private Long unitCode;

    /**
     * 计量单位
     */
    @Excel(name = "计量单位")
    private String unit;

    /**
     * 转换单位
     */
    @Excel(name = "转换单位")
    private String convertUnit;

    /**
     * 转换率
     */
    @Excel(name = "转换率")
    private Double convertRate;

    /**
     * 精度
     */
    @Excel(name = "精度")
    private Long unitPrecision;

    /**
     * 单位类型名称
     */
    @Excel(name = "单位类型名称")
    private String unitTypeName;

    /**
     * 来源系统
     */
    @Excel(name = "来源系统")
    private String sourceSys;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long unitStatus;

    @Excel(name = "用途描述")
    private String useDescribe;

    public Long getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Long unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getConvertUnit() {
        return convertUnit;
    }

    public void setConvertUnit(String convertUnit) {
        this.convertUnit = convertUnit;
    }

    public Double getConvertRate() {
        return convertRate;
    }

    public void setConvertRate(Double convertRate) {
        this.convertRate = convertRate;
    }

    public Long getUnitPrecision() {
        return unitPrecision;
    }

    public void setUnitPrecision(Long unitPrecision) {
        this.unitPrecision = unitPrecision;
    }

    public String getUnitTypeName() {
        return unitTypeName;
    }

    public void setUnitTypeName(String unitTypeName) {
        this.unitTypeName = unitTypeName;
    }

    public String getSourceSys() {
        return sourceSys;
    }

    public void setSourceSys(String sourceSys) {
        this.sourceSys = sourceSys;
    }

    public Long getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(Long unitStatus) {
        this.unitStatus = unitStatus;
    }

    public String getUseDescribe() {
        return useDescribe;
    }

    public void setUseDescribe(String useDescribe) {
        this.useDescribe = useDescribe;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("unitCode", getUnitCode())
                .append("unit", getUnit())
                .append("convertUnit", getConvertUnit())
                .append("convertRate", getConvertRate())
                .append("unitPrecision", getUnitPrecision())
                .append("unitTypeName", getUnitTypeName())
                .append("sourceSys", getSourceSys())
                .append("unitStatus", getUnitStatus())
                .append("useDescribe", getUseDescribe())
                .toString();
    }
}
