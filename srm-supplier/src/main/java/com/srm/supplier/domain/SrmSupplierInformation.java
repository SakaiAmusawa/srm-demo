package com.srm.supplier.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 供应商信息对象 srm_supplier_information
 *
 * @author sakai
 * @date 2024-07-01
 */
public class SrmSupplierInformation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

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
     * 认证地区
     */
    @Excel(name = "认证地区")
    private Long certificationRegion;

    /**
     * 企业类型
     */
    @Excel(name = "企业类型")
    private Long enterpriseType;

    /**
     * 行业类型
     */
    @Excel(name = "行业类型")
    private String industryType;

    /**
     * 工商注册号
     */
    @Excel(name = "工商注册号")
    private String rsnum;

    /**
     * 统一社会信用代码
     */
    @Excel(name = "统一社会信用代码")
    private String socialCode;

    /**
     * 组织机构代码
     */
    @Excel(name = "组织机构代码")
    private String organizationalCode;

    /**
     * 注册资本
     */
    @Excel(name = "注册资本")
    private Long capital;

    /**
     * 纳税人标识
     */
    @Excel(name = "纳税人标识")
    private String taxpayerType;

    /**
     * 成立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date incorporationDate;

    /**
     * 法人
     */
    @Excel(name = "法人")
    private String legalPerson;

    /**
     * 营业期限
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "营业期限", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessTerm;

    /**
     * 经营性质
     */
    @Excel(name = "经营性质")
    private Long businessNature;

    /**
     * 上传营业执照
     */
    @Excel(name = "上传营业执照")
    private String businessLicense;

    /**
     * 注册状态
     */
    @Excel(name = "注册状态")
    private Long registrationStatus;

    /**
     * 邀请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "邀请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invitationTime;

    /**
     * 生命阶段
     */
    @Excel(name = "生命阶段")
    private Long lifeStage;

    /**
     * 是否加入黑名单
     */
    @Excel(name = "是否加入黑名单")
    private Long blackList;

    /**
     * 供应商联系人信息信息
     */
    private List<SrmSupplierContactInformation> srmSupplierContactInformationList;

    /**
     * 供应商地址信息信息
     */
    private List<SrmSupplierAddressInformation> srmSupplierAddressInformationList;

    /** 供应商银行信息信息 */
    private List<SrmSupplierBankInformation> srmSupplierBankInformationList;

    /** 供应商开票信息信息 */
    private List<SrmSupplierInvoiceInformation> srmSupplierInvoiceInformationList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setCertificationRegion(Long certificationRegion) {
        this.certificationRegion = certificationRegion;
    }

    public Long getCertificationRegion() {
        return certificationRegion;
    }

    public void setEnterpriseType(Long enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Long getEnterpriseType() {
        return enterpriseType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setRsnum(String rsnum) {
        this.rsnum = rsnum;
    }

    public String getRsnum() {
        return rsnum;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setOrganizationalCode(String organizationalCode) {
        this.organizationalCode = organizationalCode;
    }

    public String getOrganizationalCode() {
        return organizationalCode;
    }

    public void setCapital(Long capital) {
        this.capital = capital;
    }

    public Long getCapital() {
        return capital;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setIncorporationDate(Date incorporationDate) {
        this.incorporationDate = incorporationDate;
    }

    public Date getIncorporationDate() {
        return incorporationDate;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setBusinessTerm(Date businessTerm) {
        this.businessTerm = businessTerm;
    }

    public Date getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessNature(Long businessNature) {
        this.businessNature = businessNature;
    }

    public Long getBusinessNature() {
        return businessNature;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setRegistrationStatus(Long registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Long getRegistrationStatus() {
        return registrationStatus;
    }

    public void setInvitationTime(Date invitationTime) {
        this.invitationTime = invitationTime;
    }

    public Date getInvitationTime() {
        return invitationTime;
    }

    public void setLifeStage(Long lifeStage) {
        this.lifeStage = lifeStage;
    }

    public Long getLifeStage() {
        return lifeStage;
    }

    public void setBlackList(Long blackList) {
        this.blackList = blackList;
    }

    public Long getBlackList() {
        return blackList;
    }

    public List<SrmSupplierContactInformation> getSrmSupplierContactInformationList() {
        return srmSupplierContactInformationList;
    }

    public void setSrmSupplierContactInformationList(List<SrmSupplierContactInformation> srmSupplierContactInformationList) {
        this.srmSupplierContactInformationList = srmSupplierContactInformationList;
    }

    public List<SrmSupplierAddressInformation> getSrmSupplierAddressInformationList() {
        return srmSupplierAddressInformationList;
    }

    public void setSrmSupplierAddressInformationList(List<SrmSupplierAddressInformation> srmSupplierAddressInformationList) {
        this.srmSupplierAddressInformationList = srmSupplierAddressInformationList;
    }

    public List<SrmSupplierBankInformation> getSrmSupplierBankInformationList() {
        return srmSupplierBankInformationList;
    }

    public void setSrmSupplierBankInformationList(List<SrmSupplierBankInformation> srmSupplierBankInformationList) {
        this.srmSupplierBankInformationList = srmSupplierBankInformationList;
    }

    public List<SrmSupplierInvoiceInformation> getSrmSupplierInvoiceInformationList() {
        return srmSupplierInvoiceInformationList;
    }

    public void setSrmSupplierInvoiceInformationList(List<SrmSupplierInvoiceInformation> srmSupplierInvoiceInformationList) {
        this.srmSupplierInvoiceInformationList = srmSupplierInvoiceInformationList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("supplierCode", getSupplierCode())
                .append("supplierName", getSupplierName())
                .append("certificationRegion", getCertificationRegion())
                .append("enterpriseType", getEnterpriseType())
                .append("industryType", getIndustryType())
                .append("rsnum", getRsnum())
                .append("socialCode", getSocialCode())
                .append("organizationalCode", getOrganizationalCode())
                .append("capital", getCapital())
                .append("taxpayerType", getTaxpayerType())
                .append("incorporationDate", getIncorporationDate())
                .append("legalPerson", getLegalPerson())
                .append("businessTerm", getBusinessTerm())
                .append("businessNature", getBusinessNature())
                .append("businessLicense", getBusinessLicense())
                .append("registrationStatus", getRegistrationStatus())
                .append("invitationTime", getInvitationTime())
                .append("lifeStage", getLifeStage())
                .append("blackList", getBlackList())
                .append("srmSupplierContactInformationList", getSrmSupplierContactInformationList())
                .append("srmSupplierAddressInformationList", getSrmSupplierAddressInformationList())
                .append("srmSupplierBankInformationList", getSrmSupplierBankInformationList())
                .append("srmSupplierInvoiceInformationList", getSrmSupplierInvoiceInformationList())
                .toString();
    }
}
