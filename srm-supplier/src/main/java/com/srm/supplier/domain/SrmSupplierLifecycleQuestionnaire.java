package com.srm.supplier.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商生命周期调查对象 srm_supplier_lifecycle_questionnaire
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public class SrmSupplierLifecycleQuestionnaire extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 调查表编码（自动生成） */
    @Excel(name = "调查表编码", readConverterExp = "自=动生成")
    private String surveyCode;

    /** 调查表标题 */
    @Excel(name = "调查表标题")
    private String surveyTitle;

    /** 调查表状态（1.待供方填写2.待采访预审3.通过4.不通过5.供方拒绝6.采方拒绝） */
    @Excel(name = "调查表状态", readConverterExp = "1=.待供方填写2.待采访预审3.通过4.不通过5.供方拒绝6.采方拒绝")
    private Long surveyState;

    /** 调查表类型 */
    @Excel(name = "调查表类型")
    private Long surveyType;

    /** 公司编码 */
    @Excel(name = "公司编码")
    private String companyCode;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 供应商编码(自动生成) */
    @Excel(name = "供应商编码(自动生成)")
    private String supplierCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商联系人 */
    @Excel(name = "供应商联系人")
    private String supplierContacts;

    /** 手机号 */
    @Excel(name = "手机号")
    private String supplierPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String supplierEmil;

    /** 附件上传 */
    @Excel(name = "附件上传")
    private String attachmentUpload;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 供应商基本信息信息 */
    private List<SrmSupplierBasicInformation> srmSupplierBasicInformationList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSurveyCode(String surveyCode) 
    {
        this.surveyCode = surveyCode;
    }

    public String getSurveyCode() 
    {
        return surveyCode;
    }
    public void setSurveyTitle(String surveyTitle) 
    {
        this.surveyTitle = surveyTitle;
    }

    public String getSurveyTitle() 
    {
        return surveyTitle;
    }
    public void setSurveyState(Long surveyState) 
    {
        this.surveyState = surveyState;
    }

    public Long getSurveyState() 
    {
        return surveyState;
    }

    public Long getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(Long surveyType) {
        this.surveyType = surveyType;
    }

    public void setCompanyCode(String companyCode)
    {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() 
    {
        return companyCode;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setSupplierCode(String supplierCode) 
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() 
    {
        return supplierCode;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierContacts(String supplierContacts) 
    {
        this.supplierContacts = supplierContacts;
    }

    public String getSupplierContacts() 
    {
        return supplierContacts;
    }
    public void setSupplierPhone(String supplierPhone) 
    {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierPhone() 
    {
        return supplierPhone;
    }
    public void setSupplierEmil(String supplierEmil) 
    {
        this.supplierEmil = supplierEmil;
    }

    public String getSupplierEmil() 
    {
        return supplierEmil;
    }
    public void setAttachmentUpload(String attachmentUpload) 
    {
        this.attachmentUpload = attachmentUpload;
    }

    public String getAttachmentUpload() 
    {
        return attachmentUpload;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<SrmSupplierBasicInformation> getSrmSupplierBasicInformationList()
    {
        return srmSupplierBasicInformationList;
    }

    public void setSrmSupplierBasicInformationList(List<SrmSupplierBasicInformation> srmSupplierBasicInformationList)
    {
        this.srmSupplierBasicInformationList = srmSupplierBasicInformationList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("surveyCode", getSurveyCode())
            .append("surveyTitle", getSurveyTitle())
            .append("surveyState", getSurveyState())
            .append("surveyType", getSurveyType())
            .append("companyCode", getCompanyCode())
            .append("companyName", getCompanyName())
            .append("supplierCode", getSupplierCode())
            .append("supplierName", getSupplierName())
            .append("supplierContacts", getSupplierContacts())
            .append("supplierPhone", getSupplierPhone())
            .append("supplierEmil", getSupplierEmil())
            .append("attachmentUpload", getAttachmentUpload())
            .append("remarks", getRemarks())
            .append("srmSupplierBasicInformationList", getSrmSupplierBasicInformationList())
            .toString();
    }
}
