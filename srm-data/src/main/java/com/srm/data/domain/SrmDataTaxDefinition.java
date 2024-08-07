package com.srm.data.domain;

import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 税率定义对象 srm_data_tax_definition
 *
 * @author sakai
 * @date 2024-08-07
 */
@Getter
public class SrmDataTaxDefinition extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 税种代码
     */
    @Excel(name = "税种代码")
    private String taxCode;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 税率
     */
    @Excel(name = "税率")
    private BigDecimal taxRate;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("taxCode", getTaxCode())
                .append("describe", getDescription())
                .append("taxRate", getTaxRate())
                .append("state", getState())
                .toString();
    }
}
