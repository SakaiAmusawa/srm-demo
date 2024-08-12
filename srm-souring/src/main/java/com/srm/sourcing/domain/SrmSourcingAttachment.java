package com.srm.sourcing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 寻源附件对象 srm_sourcing_attachment
 * 
 * @author sakai
 * @date 2024-08-12
 */
public class SrmSourcingAttachment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 商务附件 */
    @Excel(name = "商务附件")
    private String businessAttachment;

    /** 技术附件 */
    @Excel(name = "技术附件")
    private String technicalAppendix;

    /** 寻源ID */
    @Excel(name = "寻源ID")
    private Long sourcingId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBusinessAttachment(String businessAttachment) 
    {
        this.businessAttachment = businessAttachment;
    }

    public String getBusinessAttachment() 
    {
        return businessAttachment;
    }
    public void setTechnicalAppendix(String technicalAppendix) 
    {
        this.technicalAppendix = technicalAppendix;
    }

    public String getTechnicalAppendix() 
    {
        return technicalAppendix;
    }
    public void setSourcingId(Long sourcingId) 
    {
        this.sourcingId = sourcingId;
    }

    public Long getSourcingId() 
    {
        return sourcingId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("businessAttachment", getBusinessAttachment())
            .append("technicalAppendix", getTechnicalAppendix())
            .append("sourcingId", getSourcingId())
            .toString();
    }
}
