package com.srm.supplier.domain;

import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 供应商评分模板指标关联对象 srm_supplier_scoring_template_criteria
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public class SrmSupplierScoringTemplateCriteria extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 模板ID
     */
    private Long templateId;

    /**
     * 指标ID
     */
    private Long id;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("templateId", getTemplateId())
                .append("Id", getId())
                .toString();
    }
}
