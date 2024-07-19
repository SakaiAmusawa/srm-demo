package com.srm.material.domain;

import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物料管理对象 srm_material_management
 *
 * @author ruoyi
 * @date 2024-07-18
 */
public class SrmMaterialManagement extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 物料编码
     */
    @Excel(name = "物料编码")
    private String materialCode;

    /**
     * 物料名称
     */
    @Excel(name = "物料名称")
    private String materialName;

    /**
     * 基本计量单位
     */
    @Excel(name = "基本计量单位")
    private String unit;

    /**
     * 品牌
     */
    @Excel(name = "品牌")
    private String brand;

    /**
     * 物料图片
     */
    @Excel(name = "物料图片")
    private String materialPicture;

    /**
     * 物料属性
     */
    @Excel(name = "物料属性")
    private String materialProp;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long status;

    @Excel(name = "品类编码")
    private String categoryCode;

    @Excel(name = "品类名称")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterialPicture() {
        return materialPicture;
    }

    public void setMaterialPicture(String materialPicture) {
        this.materialPicture = materialPicture;
    }

    public String getMaterialProp() {
        return materialProp;
    }

    public void setMaterialProp(String materialProp) {
        this.materialProp = materialProp;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("materialCode", getMaterialCode())
                .append("materialName", getMaterialName())
                .append("unit", getUnit())
                .append("brand", getBrand())
                .append("materialPicture", getMaterialPicture())
                .append("materialProp", getMaterialProp())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .append("categoryCode", getCategoryCode())
                .append("categoryName", getCategoryName())
                .toString();
    }
}
