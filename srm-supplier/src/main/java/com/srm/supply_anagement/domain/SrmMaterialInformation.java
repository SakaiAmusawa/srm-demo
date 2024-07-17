package com.srm.supply_anagement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 物料信息对象 srm_material_information
 * 
 * @author sakai
 * @date 2024-07-17
 */
public class SrmMaterialInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String material;

    /** 品类编码 */
    @Excel(name = "品类编码")
    private String categoryCode;

    /** 品类名称 */
    @Excel(name = "品类名称")
    private String category;

    /** 是否可供(0否，1是) */
    @Excel(name = "是否可供(0否，1是)")
    private Long available;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String manufacturer;

    /** 是否免检(0否，1是) */
    @Excel(name = "是否免检(0否，1是)")
    private Long isInspection;

    /** 供货能力评级 */
    @Excel(name = "供货能力评级")
    private String rating;

    /** 供货能力评分 */
    @Excel(name = "供货能力评分")
    private Long capability;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 附件 */
    @Excel(name = "附件")
    private String attachment;

    /** 供货管理ID */
    @Excel(name = "供货管理ID")
    private Long supplyId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
    }
    public void setMaterial(String material) 
    {
        this.material = material;
    }

    public String getMaterial() 
    {
        return material;
    }
    public void setCategoryCode(String categoryCode) 
    {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() 
    {
        return categoryCode;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setAvailable(Long available) 
    {
        this.available = available;
    }

    public Long getAvailable() 
    {
        return available;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setIsInspection(Long isInspection) 
    {
        this.isInspection = isInspection;
    }

    public Long getIsInspection() 
    {
        return isInspection;
    }
    public void setRating(String rating) 
    {
        this.rating = rating;
    }

    public String getRating() 
    {
        return rating;
    }
    public void setCapability(Long capability) 
    {
        this.capability = capability;
    }

    public Long getCapability() 
    {
        return capability;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setSupplyId(Long supplyId) 
    {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() 
    {
        return supplyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialCode", getMaterialCode())
            .append("material", getMaterial())
            .append("categoryCode", getCategoryCode())
            .append("category", getCategory())
            .append("available", getAvailable())
            .append("manufacturer", getManufacturer())
            .append("isInspection", getIsInspection())
            .append("rating", getRating())
            .append("capability", getCapability())
            .append("remarks", getRemarks())
            .append("attachment", getAttachment())
            .append("supplyId", getSupplyId())
            .toString();
    }
}
