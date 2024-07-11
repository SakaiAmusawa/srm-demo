package com.srm.supplier.domain;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商绩效考评对象 srm_supplier_performance_appraisal
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
public class SrmSupplierPerformanceAppraisal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编码 */
    private Long id;

    /** 考评编码 */
    @Excel(name = "考评编码")
    private Long kpCode;

    /** 考评名称 */
    @Excel(name = "考评名称")
    private String kpName;

    /** 考评状态 */
    @Excel(name = "考评状态")
    private Long kpStatus;

    /** 考评模板编码 */
    @Excel(name = "考评模板编码")
    private String templateCoding;

    /** 考评模板名称 */
    @Excel(name = "考评模板名称")
    private String templateName;

    /** 考评方式 */
    @Excel(name = "考评方式")
    private Long kpType;

    /** 考评负责人 */
    @Excel(name = "考评负责人")
    private String kpPrincipal;

    /** 部门 */
    @Excel(name = "部门")
    private String department;

    /** 考评周期 */
    @Excel(name = "考评周期")
    private Long kpPeriod;

    /** 考评开始时间 */
    @Excel(name = "考评开始时间")
    private Date kpStartTime;

    /** 考评截至日期 */
    @Excel(name = "考评截至日期")
    private Date kpEndTime;

    /** 考评说明 */
    @Excel(name = "考评说明")
    private String kpExplain;

    /** 考评附件 */
    @Excel(name = "考评附件")
    private String kpAttachment;

    /** 绩效考评参评供应商信息 */
    private List<SrmSupplierPerformanceAppraisalSupplier> srmSupplierPerformanceAppraisalSupplierList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setKpCode(Long kpCode) 
    {
        this.kpCode = kpCode;
    }

    public Long getKpCode() 
    {
        return kpCode;
    }
    public void setKpName(String kpName) 
    {
        this.kpName = kpName;
    }

    public String getKpName() 
    {
        return kpName;
    }
    public void setKpStatus(Long kpStatus) 
    {
        this.kpStatus = kpStatus;
    }

    public Long getKpStatus() 
    {
        return kpStatus;
    }


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setKpType(Long kpType)
    {
        this.kpType = kpType;
    }

    public Long getKpType() 
    {
        return kpType;
    }
    public void setKpPrincipal(String kpPrincipal) 
    {
        this.kpPrincipal = kpPrincipal;
    }

    public String getKpPrincipal() 
    {
        return kpPrincipal;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setKpPeriod(Long kpPeriod) 
    {
        this.kpPeriod = kpPeriod;
    }

    public Long getKpPeriod() 
    {
        return kpPeriod;
    }

    public Date getKpStartTime() {
        return kpStartTime;
    }

    public void setKpStartTime(Date kpStartTime) {
        this.kpStartTime = kpStartTime;
    }

    public Date getKpEndTime() {
        return kpEndTime;
    }

    public void setKpEndTime(Date kpEndTime) {
        this.kpEndTime = kpEndTime;
    }

    public void setKpExplain(String kpExplain)
    {
        this.kpExplain = kpExplain;
    }

    public String getKpExplain() 
    {
        return kpExplain;
    }
    public void setKpAttachment(String kpAttachment) 
    {
        this.kpAttachment = kpAttachment;
    }

    public String getKpAttachment() 
    {
        return kpAttachment;
    }

    public List<SrmSupplierPerformanceAppraisalSupplier> getSrmSupplierPerformanceAppraisalSupplierList()
    {
        return srmSupplierPerformanceAppraisalSupplierList;
    }

    public void setSrmSupplierPerformanceAppraisalSupplierList(List<SrmSupplierPerformanceAppraisalSupplier> srmSupplierPerformanceAppraisalSupplierList)
    {
        this.srmSupplierPerformanceAppraisalSupplierList = srmSupplierPerformanceAppraisalSupplierList;
    }

    public String getTemplateCoding() {
        return templateCoding;
    }

    public void setTemplateCoding(String templateCoding) {
        this.templateCoding = templateCoding;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("kpCode", getKpCode())
            .append("kpName", getKpName())
            .append("kpStatus", getKpStatus())
            .append("templateCode", getTemplateCoding())
            .append("templateName", getTemplateName())
            .append("kpType", getKpType())
            .append("kpPrincipal", getKpPrincipal())
            .append("department", getDepartment())
            .append("kpPeriod", getKpPeriod())
            .append("kpStartTime", getKpStartTime())
            .append("kpEndTime", getKpEndTime())
            .append("kpExplain", getKpExplain())
            .append("createTime", getCreateTime())
            .append("kpAttachment", getKpAttachment())
            .append("srmSupplierPerformanceAppraisalSupplierList", getSrmSupplierPerformanceAppraisalSupplierList())
            .toString();
    }
}
