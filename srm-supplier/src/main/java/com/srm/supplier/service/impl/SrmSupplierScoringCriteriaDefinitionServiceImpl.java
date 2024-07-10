package com.srm.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.supplier.mapper.SrmSupplierScoringCriteriaDefinitionMapper;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.service.ISrmSupplierScoringCriteriaDefinitionService;

/**
 * 供应商评分标准定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
@Service
public class SrmSupplierScoringCriteriaDefinitionServiceImpl implements ISrmSupplierScoringCriteriaDefinitionService 
{
    @Autowired
    private SrmSupplierScoringCriteriaDefinitionMapper srmSupplierScoringCriteriaDefinitionMapper;

    /**
     * 查询供应商评分标准定义
     * 
     * @param id 供应商评分标准定义主键
     * @return 供应商评分标准定义
     */
    @Override
    public SrmSupplierScoringCriteriaDefinition selectSrmSupplierScoringCriteriaDefinitionById(Long id)
    {
        return srmSupplierScoringCriteriaDefinitionMapper.selectSrmSupplierScoringCriteriaDefinitionById(id);
    }

    /**
     * 查询供应商评分标准定义列表
     * 
     * @param srmSupplierScoringCriteriaDefinition 供应商评分标准定义
     * @return 供应商评分标准定义
     */
    @Override
    public List<SrmSupplierScoringCriteriaDefinition> selectSrmSupplierScoringCriteriaDefinitionList(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        return srmSupplierScoringCriteriaDefinitionMapper.selectSrmSupplierScoringCriteriaDefinitionList(srmSupplierScoringCriteriaDefinition);
    }

    /**
     * 新增供应商评分标准定义
     * 
     * @param srmSupplierScoringCriteriaDefinition 供应商评分标准定义
     * @return 结果
     */
    @Override
    public int insertSrmSupplierScoringCriteriaDefinition(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        return srmSupplierScoringCriteriaDefinitionMapper.insertSrmSupplierScoringCriteriaDefinition(srmSupplierScoringCriteriaDefinition);
    }

    /**
     * 修改供应商评分标准定义
     * 
     * @param srmSupplierScoringCriteriaDefinition 供应商评分标准定义
     * @return 结果
     */
    @Override
    public int updateSrmSupplierScoringCriteriaDefinition(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        return srmSupplierScoringCriteriaDefinitionMapper.updateSrmSupplierScoringCriteriaDefinition(srmSupplierScoringCriteriaDefinition);
    }

    /**
     * 批量删除供应商评分标准定义
     * 
     * @param ids 需要删除的供应商评分标准定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierScoringCriteriaDefinitionByIds(Long[] ids)
    {
        return srmSupplierScoringCriteriaDefinitionMapper.deleteSrmSupplierScoringCriteriaDefinitionByIds(ids);
    }

    /**
     * 删除供应商评分标准定义信息
     * 
     * @param id 供应商评分标准定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierScoringCriteriaDefinitionById(Long id)
    {
        return srmSupplierScoringCriteriaDefinitionMapper.deleteSrmSupplierScoringCriteriaDefinitionById(id);
    }
}
