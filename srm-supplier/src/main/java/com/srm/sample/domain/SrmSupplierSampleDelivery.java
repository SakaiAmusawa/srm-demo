package com.srm.sample.domain;

import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 供应商送样对象 srm_supplier_sample_delivery
 *
 * @author ruoyi
 * @date 2024-07-19
 */
public class SrmSupplierSampleDelivery extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 送样编码
     */
    @Excel(name = "送样编码")
    private String sampleCode;

    /**
     * 送样标题
     */
    @Excel(name = "送样标题")
    private String sampleTitle;

    /**
     * 公司编码
     */
    @Excel(name = "公司编码")
    private String companyCode;

    /**
     * 公司名称
     */
    @Excel(name = "公司名称")
    private String companyName;

    /**
     * 供应商编码
     */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /**
     * 供应商名称
     */
    @Excel(name = "供应商名称")
    private String supplierName;

    /**
     * 人员编码
     */
    @Excel(name = "人员编码")
    private String userCode;

    /**
     * 送样类型
     */
    @Excel(name = "送样类型")
    private Integer sampleType;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remarks;

    /**
     * 附件上传
     */
    @Excel(name = "附件上传")
    private String attachmentUpload;

    /**
     * 送样方信息信息
     */
    private List<SrmSupplierSampleSender> srmSupplierSampleSenderList;

    /**
     * 供应商送样物料信息
     */
    private List<SrmSupplierSampleDeliveryMaterial> srmSupplierSampleDeliveryMaterialList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getSampleTitle() {
        return sampleTitle;
    }

    public void setSampleTitle(String sampleTitle) {
        this.sampleTitle = sampleTitle;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getSampleType() {
        return sampleType;
    }

    public void setSampleType(Integer sampleType) {
        this.sampleType = sampleType;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAttachmentUpload() {
        return attachmentUpload;
    }

    public void setAttachmentUpload(String attachmentUpload) {
        this.attachmentUpload = attachmentUpload;
    }

    public List<SrmSupplierSampleSender> getSrmSupplierSampleSenderList() {
        return srmSupplierSampleSenderList;
    }

    public void setSrmSupplierSampleSenderList(List<SrmSupplierSampleSender> srmSupplierSampleSenderList) {
        this.srmSupplierSampleSenderList = srmSupplierSampleSenderList;
    }

    public List<SrmSupplierSampleDeliveryMaterial> getSrmSupplierSampleDeliveryMaterialList() {
        return srmSupplierSampleDeliveryMaterialList;
    }

    public void setSrmSupplierSampleDeliveryMaterialList(List<SrmSupplierSampleDeliveryMaterial> srmSupplierSampleDeliveryMaterialList) {
        this.srmSupplierSampleDeliveryMaterialList = srmSupplierSampleDeliveryMaterialList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sampleCode", getSampleCode())
                .append("sampleTitle", getSampleTitle())
                .append("companyCode", getCompanyCode())
                .append("companyName", getCompanyName())
                .append("supplierCode", getSupplierCode())
                .append("supplierName", getSupplierName())
                .append("userCode", getUserCode())
                .append("sampleType", getSampleType())
                .append("state", getState())
                .append("remarks", getRemarks())
                .append("attachmentUpload", getAttachmentUpload())
                .append("srmSupplierSampleSenderList", getSrmSupplierSampleSenderList())
                .append("srmSupplierSampleDeliveryMaterialList", getSrmSupplierSampleDeliveryMaterialList())
                .toString();
    }
}
