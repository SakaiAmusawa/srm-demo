package com.srm.supplier.domain;

import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 品类定义对象 srm_category_definition
 *
 * @author ruoyi
 * @date 2024-07-17
 */
public class SrmCategoryDefinition extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 品类编码
     */
    @Excel(name = "品类编码")
    private String categoryCode;

    /**
     * 品类名称
     */
    @Excel(name = "品类名称")
    private String categoryName;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String unity;

    /**
     * 超量（0允许，1不允许）
     */
    @Excel(name = "超量", readConverterExp = "0=允许，1不允许")
    private Long excess;

    /**
     * 要求
     */
    @Excel(name = "要求")
    private Integer categoryRequire;

    /**
     * 采购员
     */
    @Excel(name = "采购员")
    private String buyer;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public Long getExcess() {
        return excess;
    }

    public void setExcess(Long excess) {
        this.excess = excess;
    }

    public Integer getCategoryRequire() {
        return categoryRequire;
    }

    public void setCategoryRequire(Integer categoryRequire) {
        this.categoryRequire = categoryRequire;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("categoryCode", getCategoryCode())
                .append("categoryName", getCategoryName())
                .append("unity", getUnity())
                .append("updateBy", getUpdateBy())
                .append("excess", getExcess())
                .append("parentId", getParentId())
                .append("categoryRequire", getCategoryRequire())
                .append("buyer", getBuyer())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .append("status", getStatus())
                .toString();
    }
}
