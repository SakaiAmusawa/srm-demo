package com.srm.supplier.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.srm.common.annotation.Excel;
import com.srm.common.core.domain.BaseEntity;

/**
 * 供应商基本信息对象 srm_supplier_basic_information
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public class SrmSupplierBasicInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商编码(自动生成) */
    @Excel(name = "供应商编码(自动生成)")
    private String supplierCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 总经理 */
    @Excel(name = "总经理")
    private String manager;

    /** 是否上市（0.未上市1.已上市） */
    @Excel(name = "是否上市", readConverterExp = "0=.未上市1.已上市")
    private Long isList;

    /** 股票代码 */
    @Excel(name = "股票代码")
    private String stockCode;

    /** 股票结构附件 */
    @Excel(name = "股票结构附件")
    private String stockLoad;

    /** 行业排名 */
    @Excel(name = "行业排名")
    private Long industryRanking;

    /** 是否愿意配合审计(0.否1.是) */
    @Excel(name = "是否愿意配合审计(0.否1.是)")
    private Long isAudit;

    /** 公司员工数 */
    @Excel(name = "公司员工数")
    private Long staffNum;

    /** 管理人员数 */
    @Excel(name = "管理人员数")
    private Long managerNum;

    /** 组织架构附件 */
    @Excel(name = "组织架构附件")
    private String structureLoad;

    /** 竞争对手 */
    @Excel(name = "竞争对手")
    private String competitors;

    /** 经营范围 */
    @Excel(name = "经营范围")
    private String business;

    /** 常用税率(%) */
    @Excel(name = "常用税率(%)")
    private Long taxRate;

    /** 常用货币 */
    @Excel(name = "常用货币")
    private String currency;

    /** 供货周期（天） */
    @Excel(name = "供货周期", readConverterExp = "天=")
    private Long supplyCycle;

    /** 运货方式 */
    @Excel(name = "运货方式")
    private String freightMethod;

    /** 交货及时率（%） */
    @Excel(name = "交货及时率", readConverterExp = "%=")
    private Long timeliness;

    /** 是否接受商业承诺(0否1是) */
    @Excel(name = "是否接受商业承诺(0否1是)")
    private Long isCommitment;

    /** 是否提供备货或预留库存(0否1是) */
    @Excel(name = "是否提供备货或预留库存(0否1是)")
    private Long isStockup;

    /** 可接受的付款进度及比例 */
    @Excel(name = "可接受的付款进度及比例")
    private String paymentProgress;

    /** 包装方式 */
    @Excel(name = "包装方式")
    private String packaging;

    /** 物料成本结构 */
    @Excel(name = "物料成本结构")
    private String materialCost;

    /** 成本控制措施 */
    @Excel(name = "成本控制措施")
    private String costControl;

    /** 调查表ID */
    @Excel(name = "调查表ID")
    private Long surveyId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }
    public void setIsList(Long isList) 
    {
        this.isList = isList;
    }

    public Long getIsList() 
    {
        return isList;
    }
    public void setStockCode(String stockCode) 
    {
        this.stockCode = stockCode;
    }

    public String getStockCode() 
    {
        return stockCode;
    }
    public void setStockLoad(String stockLoad) 
    {
        this.stockLoad = stockLoad;
    }

    public String getStockLoad() 
    {
        return stockLoad;
    }
    public void setIndustryRanking(Long industryRanking) 
    {
        this.industryRanking = industryRanking;
    }

    public Long getIndustryRanking() 
    {
        return industryRanking;
    }
    public void setIsAudit(Long isAudit) 
    {
        this.isAudit = isAudit;
    }

    public Long getIsAudit() 
    {
        return isAudit;
    }
    public void setStaffNum(Long staffNum) 
    {
        this.staffNum = staffNum;
    }

    public Long getStaffNum() 
    {
        return staffNum;
    }
    public void setManagerNum(Long managerNum) 
    {
        this.managerNum = managerNum;
    }

    public Long getManagerNum() 
    {
        return managerNum;
    }
    public void setStructureLoad(String structureLoad) 
    {
        this.structureLoad = structureLoad;
    }

    public String getStructureLoad() 
    {
        return structureLoad;
    }
    public void setCompetitors(String competitors) 
    {
        this.competitors = competitors;
    }

    public String getCompetitors() 
    {
        return competitors;
    }
    public void setBusiness(String business) 
    {
        this.business = business;
    }

    public String getBusiness() 
    {
        return business;
    }
    public void setTaxRate(Long taxRate) 
    {
        this.taxRate = taxRate;
    }

    public Long getTaxRate() 
    {
        return taxRate;
    }
    public void setCurrency(String currency) 
    {
        this.currency = currency;
    }

    public String getCurrency() 
    {
        return currency;
    }
    public void setSupplyCycle(Long supplyCycle) 
    {
        this.supplyCycle = supplyCycle;
    }

    public Long getSupplyCycle() 
    {
        return supplyCycle;
    }
    public void setFreightMethod(String freightMethod) 
    {
        this.freightMethod = freightMethod;
    }

    public String getFreightMethod() 
    {
        return freightMethod;
    }
    public void setTimeliness(Long timeliness) 
    {
        this.timeliness = timeliness;
    }

    public Long getTimeliness() 
    {
        return timeliness;
    }
    public void setIsCommitment(Long isCommitment) 
    {
        this.isCommitment = isCommitment;
    }

    public Long getIsCommitment() 
    {
        return isCommitment;
    }
    public void setIsStockup(Long isStockup) 
    {
        this.isStockup = isStockup;
    }

    public Long getIsStockup() 
    {
        return isStockup;
    }
    public void setPaymentProgress(String paymentProgress) 
    {
        this.paymentProgress = paymentProgress;
    }

    public String getPaymentProgress() 
    {
        return paymentProgress;
    }
    public void setPackaging(String packaging) 
    {
        this.packaging = packaging;
    }

    public String getPackaging() 
    {
        return packaging;
    }
    public void setMaterialCost(String materialCost) 
    {
        this.materialCost = materialCost;
    }

    public String getMaterialCost() 
    {
        return materialCost;
    }
    public void setCostControl(String costControl) 
    {
        this.costControl = costControl;
    }

    public String getCostControl() 
    {
        return costControl;
    }
    public void setSurveyId(Long surveyId) 
    {
        this.surveyId = surveyId;
    }

    public Long getSurveyId() 
    {
        return surveyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierCode", getSupplierCode())
            .append("supplierName", getSupplierName())
            .append("manager", getManager())
            .append("isList", getIsList())
            .append("stockCode", getStockCode())
            .append("stockLoad", getStockLoad())
            .append("industryRanking", getIndustryRanking())
            .append("isAudit", getIsAudit())
            .append("staffNum", getStaffNum())
            .append("managerNum", getManagerNum())
            .append("structureLoad", getStructureLoad())
            .append("competitors", getCompetitors())
            .append("business", getBusiness())
            .append("taxRate", getTaxRate())
            .append("currency", getCurrency())
            .append("supplyCycle", getSupplyCycle())
            .append("freightMethod", getFreightMethod())
            .append("timeliness", getTimeliness())
            .append("isCommitment", getIsCommitment())
            .append("isStockup", getIsStockup())
            .append("paymentProgress", getPaymentProgress())
            .append("packaging", getPackaging())
            .append("materialCost", getMaterialCost())
            .append("costControl", getCostControl())
            .append("surveyId", getSurveyId())
            .toString();
    }
}
