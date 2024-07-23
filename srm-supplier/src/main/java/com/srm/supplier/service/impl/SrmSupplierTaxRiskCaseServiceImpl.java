package com.srm.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.supplier.mapper.SrmSupplierTaxRiskCaseMapper;
import com.srm.supplier.domain.SrmSupplierTaxRiskCase;
import com.srm.supplier.service.ISrmSupplierTaxRiskCaseService;

/**
 * 供应商税收违法风险Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
@Service
public class SrmSupplierTaxRiskCaseServiceImpl implements ISrmSupplierTaxRiskCaseService 
{
    @Autowired
    private SrmSupplierTaxRiskCaseMapper srmSupplierTaxRiskCaseMapper;

    /**
     * 查询供应商税收违法风险
     * 
     * @param id 供应商税收违法风险主键
     * @return 供应商税收违法风险
     */
    @Override
    public SrmSupplierTaxRiskCase selectSrmSupplierTaxRiskCaseById(Long id)
    {
        return srmSupplierTaxRiskCaseMapper.selectSrmSupplierTaxRiskCaseById(id);
    }

    /**
     * 查询供应商税收违法风险列表
     * 
     * @param srmSupplierTaxRiskCase 供应商税收违法风险
     * @return 供应商税收违法风险
     */
    @Override
    public List<SrmSupplierTaxRiskCase> selectSrmSupplierTaxRiskCaseList(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        return srmSupplierTaxRiskCaseMapper.selectSrmSupplierTaxRiskCaseList(srmSupplierTaxRiskCase);
    }

    /**
     * 新增供应商税收违法风险
     * 
     * @param srmSupplierTaxRiskCase 供应商税收违法风险
     * @return 结果
     */
    @Override
    public int insertSrmSupplierTaxRiskCase(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        return srmSupplierTaxRiskCaseMapper.insertSrmSupplierTaxRiskCase(srmSupplierTaxRiskCase);
    }

    /**
     * 修改供应商税收违法风险
     * 
     * @param srmSupplierTaxRiskCase 供应商税收违法风险
     * @return 结果
     */
    @Override
    public int updateSrmSupplierTaxRiskCase(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        return srmSupplierTaxRiskCaseMapper.updateSrmSupplierTaxRiskCase(srmSupplierTaxRiskCase);
    }

    /**
     * 批量删除供应商税收违法风险
     * 
     * @param ids 需要删除的供应商税收违法风险主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierTaxRiskCaseByIds(Long[] ids)
    {
        return srmSupplierTaxRiskCaseMapper.deleteSrmSupplierTaxRiskCaseByIds(ids);
    }

    /**
     * 删除供应商税收违法风险信息
     * 
     * @param id 供应商税收违法风险主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierTaxRiskCaseById(Long id)
    {
        return srmSupplierTaxRiskCaseMapper.deleteSrmSupplierTaxRiskCaseById(id);
    }
}
