package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商评分标准定义对象 srm_supplier_scoring_criteria_definition
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
public class SrmSupplierScoringCriteriaDefinition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 指标编码 */
    @Excel(name = "指标编码")
    private Long pointerCoding;

    /** 基准分值 */
    @Excel(name = "基准分值")
    private Double basePointTop;

    /** 指标名称 */
    @Excel(name = "指标名称")
    private String pointerName;

    /** 评分方式 */
    @Excel(name = "评分方式")
    private String scoringMethod;

    /** 指标类型 */
    @Excel(name = "指标类型")
    private Integer pointerType;

    /** 评分标准 */
    @Excel(name = "评分标准")
    private String standardEvaluation;

    /** 分值从 */
    @Excel(name = "分值从")
    private Double scoreFrom;

    /** 分值至 */
    @Excel(name = "分值至")
    private Double scoreTo;

    /** 系统评分 */
    @Excel(name = "系统评分")
    private Double systemScoring;

    /** 基准分值 */
    @Excel(name = "基准分值")
    private Double basePointLow;

    /** 配置 */
    @Excel(name = "配置")
    private Integer configuration;

    /** 评分人 */
    @Excel(name = "评分人")
    private String scorer;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPointerCoding(Long pointerCoding) 
    {
        this.pointerCoding = pointerCoding;
    }

    public Long getPointerCoding() 
    {
        return pointerCoding;
    }
    public void setBasePointTop(Double basePointTop) 
    {
        this.basePointTop = basePointTop;
    }

    public Double getBasePointTop() 
    {
        return basePointTop;
    }
    public void setPointerName(String pointerName) 
    {
        this.pointerName = pointerName;
    }

    public String getPointerName() 
    {
        return pointerName;
    }
    public void setScoringMethod(String scoringMethod) 
    {
        this.scoringMethod = scoringMethod;
    }

    public String getScoringMethod() 
    {
        return scoringMethod;
    }
    public void setPointerType(Integer pointerType) 
    {
        this.pointerType = pointerType;
    }

    public Integer getPointerType() 
    {
        return pointerType;
    }
    public void setStandardEvaluation(String standardEvaluation) 
    {
        this.standardEvaluation = standardEvaluation;
    }

    public String getStandardEvaluation() 
    {
        return standardEvaluation;
    }
    public void setScoreFrom(Double scoreFrom) 
    {
        this.scoreFrom = scoreFrom;
    }

    public Double getScoreFrom() 
    {
        return scoreFrom;
    }
    public void setScoreTo(Double scoreTo) 
    {
        this.scoreTo = scoreTo;
    }

    public Double getScoreTo() 
    {
        return scoreTo;
    }
    public void setSystemScoring(Double systemScoring) 
    {
        this.systemScoring = systemScoring;
    }

    public Double getSystemScoring() 
    {
        return systemScoring;
    }
    public void setBasePointLow(Double basePointLow) 
    {
        this.basePointLow = basePointLow;
    }

    public Double getBasePointLow() 
    {
        return basePointLow;
    }
    public void setConfiguration(Integer configuration) 
    {
        this.configuration = configuration;
    }

    public Integer getConfiguration() 
    {
        return configuration;
    }
    public void setScorer(String scorer) 
    {
        this.scorer = scorer;
    }

    public String getScorer() 
    {
        return scorer;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pointerCoding", getPointerCoding())
            .append("basePointTop", getBasePointTop())
            .append("pointerName", getPointerName())
            .append("scoringMethod", getScoringMethod())
            .append("pointerType", getPointerType())
            .append("standardEvaluation", getStandardEvaluation())
            .append("scoreFrom", getScoreFrom())
            .append("scoreTo", getScoreTo())
            .append("systemScoring", getSystemScoring())
            .append("basePointLow", getBasePointLow())
            .append("configuration", getConfiguration())
            .append("scorer", getScorer())
            .append("status", getStatus())
            .toString();
    }
}
