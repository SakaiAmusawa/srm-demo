package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商评分模板指标关联对象 srm_supplier_scoring_template_criteria
 * 
 * @author ruoyi
 * @date 2024-07-10
 */
public class SrmSupplierScoringTemplateCriteria extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 模板ID */
    private Long templateId;

    /** 指标ID */
    private Long criteriaId;

    public void setTemplateId(Long templateId) 
    {
        this.templateId = templateId;
    }

    public Long getTemplateId() 
    {
        return templateId;
    }
    public void setCriteriaId(Long criteriaId) 
    {
        this.criteriaId = criteriaId;
    }

    public Long getCriteriaId() 
    {
        return criteriaId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("templateId", getTemplateId())
            .append("criteriaId", getCriteriaId())
            .toString();
    }
}
