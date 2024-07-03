package com.srm.supplier.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商证照信息对象 srm_supplier_license_information
 * 
 * @author sakai
 * @date 2024-07-03
 */
public class SrmSupplierLicenseInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 附件类型 */
    @Excel(name = "附件类型")
    private String attachment;

    /** 供应商信息主键 */
    @Excel(name = "供应商信息主键")
    private Long supplierId;

    /** 附件描述 */
    @Excel(name = "附件描述")
    private String describe;

    /** 文件失效期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文件失效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expirationPeriod;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 附件上传 */
    @Excel(name = "附件上传")
    private String attachmentUpload;

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
    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
    }
    public void setExpirationPeriod(Date expirationPeriod) 
    {
        this.expirationPeriod = expirationPeriod;
    }

    public Date getExpirationPeriod() 
    {
        return expirationPeriod;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setAttachmentUpload(String attachmentUpload) 
    {
        this.attachmentUpload = attachmentUpload;
    }

    public String getAttachmentUpload() 
    {
        return attachmentUpload;
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
            .append("attachment", getAttachment())
            .append("supplierId", getSupplierId())
            .append("describe", getDescribe())
            .append("expirationPeriod", getExpirationPeriod())
            .append("updateDate", getUpdateDate())
            .append("attachmentUpload", getAttachmentUpload())
            .append("remarks", getRemarks())
            .toString();
    }
}
