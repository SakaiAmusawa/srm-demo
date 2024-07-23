package com.srm.supplier.mapper;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierTaxRiskCase;

/**
 * 供应商税收违法风险Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
public interface SrmSupplierTaxRiskCaseMapper 
{
    /**
     * 查询供应商税收违法风险
     * 
     * @param id 供应商税收违法风险主键
     * @return 供应商税收违法风险
     */
    public SrmSupplierTaxRiskCase selectSrmSupplierTaxRiskCaseById(Long id);

    /**
     * 查询供应商税收违法风险列表
     * 
     * @param srmSupplierTaxRiskCase 供应商税收违法风险
     * @return 供应商税收违法风险集合
     */
    public List<SrmSupplierTaxRiskCase> selectSrmSupplierTaxRiskCaseList(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase);

    /**
     * 新增供应商税收违法风险
     * 
     * @param srmSupplierTaxRiskCase 供应商税收违法风险
     * @return 结果
     */
    public int insertSrmSupplierTaxRiskCase(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase);

    /**
     * 修改供应商税收违法风险
     * 
     * @param srmSupplierTaxRiskCase 供应商税收违法风险
     * @return 结果
     */
    public int updateSrmSupplierTaxRiskCase(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase);

    /**
     * 删除供应商税收违法风险
     * 
     * @param id 供应商税收违法风险主键
     * @return 结果
     */
    public int deleteSrmSupplierTaxRiskCaseById(Long id);

    /**
     * 批量删除供应商税收违法风险
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierTaxRiskCaseByIds(Long[] ids);
}
