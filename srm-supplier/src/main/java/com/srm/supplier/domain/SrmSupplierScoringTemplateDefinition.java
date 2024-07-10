package com.srm.supplier.domain;

import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 评分模板定义对象 srm_supplier_scoring_template_definition
 *
 * @author ruoyi
 * @date 2024-07-10
 */
public class SrmSupplierScoringTemplateDefinition extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 模板编码
     */
    @Excel(name = "模板编码")
    private String templateCoding;

    /**
     * 评分模板名称
     */
    @Excel(name = "评分模板名称")
    private String templateName;

    /**
     * 模板状态
     */
    @Excel(name = "模板状态")
    private Long templateStatus;

    /**
     * 模板类型
     */
    @Excel(name = "模板类型")
    private Long templateType;

    /**
     * 供应商评分模板指标关联信息
     */
    private List<SrmSupplierScoringTemplateCriteria> srmSupplierScoringTemplateCriteriaList;
    private List<SrmSupplierScoringCriteriaDefinition> srmSupplierScoringCriteriaList;

    public List<SrmSupplierScoringCriteriaDefinition> getSrmSupplierScoringCriteriaList() {
        return srmSupplierScoringCriteriaList;
    }

    public void setSrmSupplierScoringCriteriaList(List<SrmSupplierScoringCriteriaDefinition> srmSupplierScoringCriteriaList) {
        this.srmSupplierScoringCriteriaList = srmSupplierScoringCriteriaList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplateCoding() {
        return templateCoding;
    }

    public void setTemplateCoding(String templateCoding) {
        this.templateCoding = templateCoding;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Long getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(Long templateStatus) {
        this.templateStatus = templateStatus;
    }

    public Long getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Long templateType) {
        this.templateType = templateType;
    }

    public List<SrmSupplierScoringTemplateCriteria> getSrmSupplierScoringTemplateCriteriaList() {
        return srmSupplierScoringTemplateCriteriaList;
    }

    public void setSrmSupplierScoringTemplateCriteriaList(List<SrmSupplierScoringTemplateCriteria> srmSupplierScoringTemplateCriteriaList) {
        this.srmSupplierScoringTemplateCriteriaList = srmSupplierScoringTemplateCriteriaList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("templateCoding", getTemplateCoding())
                .append("templateName", getTemplateName())
                .append("templateStatus", getTemplateStatus())
                .append("templateType", getTemplateType())
                .append("srmSupplierScoringTemplateCriteriaList", getSrmSupplierScoringTemplateCriteriaList())
                .toString();
    }
}
