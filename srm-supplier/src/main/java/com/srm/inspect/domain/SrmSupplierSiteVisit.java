package com.srm.inspect.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商现场考察对象 srm_supplier_site_visit
 * 
 * @author sakai
 * @date 2024-07-16
 */
public class SrmSupplierSiteVisit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 考察编码（自动生成） */
    @Excel(name = "考察编码", readConverterExp = "自=动生成")
    private String investigateCode;

    /** 考察标题 */
    @Excel(name = "考察标题")
    private String investigateTitle;

    /** 公司编码 */
    @Excel(name = "公司编码")
    private String companyCode;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 考察起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考察起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date investigatesDate;

    /** 考察结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考察结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date investigateeDate;

    /** 考察地址 */
    @Excel(name = "考察地址")
    private String investigateAddress;

    /** 考察结果 */
    @Excel(name = "考察结果")
    private Long investigateRes;

    /** 考察得分 */
    @Excel(name = "考察得分")
    private Long investigateScore;

    /** 考察等级 */
    @Excel(name = "考察等级")
    private String investigateGrade;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 附件上传 */
    @Excel(name = "附件上传")
    private String attachmentUpload;

    /** 申请人 */
    @Excel(name = "申请人")
    private String userCode;

    /** 供应商现场考察物料信息 */
    private List<SrmSupplierSiteVisitMaterial> srmSupplierSiteVisitMaterialList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInvestigateCode(String investigateCode) 
    {
        this.investigateCode = investigateCode;
    }

    public String getInvestigateCode() 
    {
        return investigateCode;
    }
    public void setInvestigateTitle(String investigateTitle) 
    {
        this.investigateTitle = investigateTitle;
    }

    public String getInvestigateTitle() 
    {
        return investigateTitle;
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
    public void setInvestigatesDate(Date investigatesDate) 
    {
        this.investigatesDate = investigatesDate;
    }

    public Date getInvestigatesDate() 
    {
        return investigatesDate;
    }
    public void setInvestigateeDate(Date investigateeDate) 
    {
        this.investigateeDate = investigateeDate;
    }

    public Date getInvestigateeDate() 
    {
        return investigateeDate;
    }
    public void setInvestigateAddress(String investigateAddress) 
    {
        this.investigateAddress = investigateAddress;
    }

    public String getInvestigateAddress() 
    {
        return investigateAddress;
    }
    public void setInvestigateRes(Long investigateRes) 
    {
        this.investigateRes = investigateRes;
    }

    public Long getInvestigateRes() 
    {
        return investigateRes;
    }
    public void setInvestigateScore(Long investigateScore) 
    {
        this.investigateScore = investigateScore;
    }

    public Long getInvestigateScore() 
    {
        return investigateScore;
    }
    public void setInvestigateGrade(String investigateGrade) 
    {
        this.investigateGrade = investigateGrade;
    }

    public String getInvestigateGrade() 
    {
        return investigateGrade;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setAttachmentUpload(String attachmentUpload) 
    {
        this.attachmentUpload = attachmentUpload;
    }

    public String getAttachmentUpload() 
    {
        return attachmentUpload;
    }
    public void setUserCode(String userCode) 
    {
        this.userCode = userCode;
    }

    public String getUserCode() 
    {
        return userCode;
    }

    public List<SrmSupplierSiteVisitMaterial> getSrmSupplierSiteVisitMaterialList()
    {
        return srmSupplierSiteVisitMaterialList;
    }

    public void setSrmSupplierSiteVisitMaterialList(List<SrmSupplierSiteVisitMaterial> srmSupplierSiteVisitMaterialList)
    {
        this.srmSupplierSiteVisitMaterialList = srmSupplierSiteVisitMaterialList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("investigateCode", getInvestigateCode())
            .append("investigateTitle", getInvestigateTitle())
            .append("companyCode", getCompanyCode())
            .append("companyName", getCompanyName())
            .append("supplierCode", getSupplierCode())
            .append("supplierName", getSupplierName())
            .append("investigatesDate", getInvestigatesDate())
            .append("investigateeDate", getInvestigateeDate())
            .append("investigateAddress", getInvestigateAddress())
            .append("investigateRes", getInvestigateRes())
            .append("investigateScore", getInvestigateScore())
            .append("investigateGrade", getInvestigateGrade())
            .append("remarks", getRemarks())
            .append("attachmentUpload", getAttachmentUpload())
            .append("userCode", getUserCode())
            .append("srmSupplierSiteVisitMaterialList", getSrmSupplierSiteVisitMaterialList())
            .toString();
    }
}
