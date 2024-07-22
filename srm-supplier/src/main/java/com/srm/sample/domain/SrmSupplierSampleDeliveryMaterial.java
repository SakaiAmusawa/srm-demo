package com.srm.sample.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商送样物料对象 srm_supplier_sample_delivery_material
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public class SrmSupplierSampleDeliveryMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商送样id */
    @Excel(name = "供应商送样id")
    private Long sampleId;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String matertial;

    /** 供应商送样物料 */
    @Excel(name = "供应商送样物料")
    private String materialCode;

    /** 品类名称 */
    @Excel(name = "品类名称")
    private String categoryName;

    /** 品类编码 */
    @Excel(name = "品类编码")
    private String categoryCode;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 需求量 */
    @Excel(name = "需求量")
    private Long quantityDemanded;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 需求时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需求时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date quantityTime;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 收货人联系方式 */
    @Excel(name = "收货人联系方式")
    private String phone;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String quantityAddress;

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
    public void setSampleId(Long sampleId) 
    {
        this.sampleId = sampleId;
    }

    public Long getSampleId() 
    {
        return sampleId;
    }
    public void setMatertial(String matertial) 
    {
        this.matertial = matertial;
    }

    public String getMatertial() 
    {
        return matertial;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
    }
    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }
    public void setCategoryCode(String categoryCode) 
    {
        this.categoryCode = categoryCode;
    }

    public String getCategoryCode() 
    {
        return categoryCode;
    }
    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setQuantityDemanded(Long quantityDemanded) 
    {
        this.quantityDemanded = quantityDemanded;
    }

    public Long getQuantityDemanded() 
    {
        return quantityDemanded;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setQuantityTime(Date quantityTime) 
    {
        this.quantityTime = quantityTime;
    }

    public Date getQuantityTime() 
    {
        return quantityTime;
    }
    public void setConsignee(String consignee) 
    {
        this.consignee = consignee;
    }

    public String getConsignee() 
    {
        return consignee;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setQuantityAddress(String quantityAddress) 
    {
        this.quantityAddress = quantityAddress;
    }

    public String getQuantityAddress() 
    {
        return quantityAddress;
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
            .append("sampleId", getSampleId())
            .append("matertial", getMatertial())
            .append("materialCode", getMaterialCode())
            .append("categoryName", getCategoryName())
            .append("categoryCode", getCategoryCode())
            .append("specification", getSpecification())
            .append("model", getModel())
            .append("quantityDemanded", getQuantityDemanded())
            .append("unit", getUnit())
            .append("quantityTime", getQuantityTime())
            .append("consignee", getConsignee())
            .append("phone", getPhone())
            .append("quantityAddress", getQuantityAddress())
            .append("remarks", getRemarks())
            .toString();
    }
}
