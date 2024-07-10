package com.srm.supplier.mapper;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;

/**
 * 供应商评分标准定义Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
public interface SrmSupplierScoringCriteriaDefinitionMapper 
{
    /**
     * 查询供应商评分标准定义
     * 
     * @param id 供应商评分标准定义主键
     * @return 供应商评分标准定义
     */
    public SrmSupplierScoringCriteriaDefinition selectSrmSupplierScoringCriteriaDefinitionById(Long id);

    /**
     * 查询供应商评分标准定义列表
     * 
     * @param srmSupplierScoringCriteriaDefinition 供应商评分标准定义
     * @return 供应商评分标准定义集合
     */
    public List<SrmSupplierScoringCriteriaDefinition> selectSrmSupplierScoringCriteriaDefinitionList(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition);

    /**
     * 新增供应商评分标准定义
     * 
     * @param srmSupplierScoringCriteriaDefinition 供应商评分标准定义
     * @return 结果
     */
    public int insertSrmSupplierScoringCriteriaDefinition(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition);

    /**
     * 修改供应商评分标准定义
     * 
     * @param srmSupplierScoringCriteriaDefinition 供应商评分标准定义
     * @return 结果
     */
    public int updateSrmSupplierScoringCriteriaDefinition(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition);

    /**
     * 删除供应商评分标准定义
     * 
     * @param id 供应商评分标准定义主键
     * @return 结果
     */
    public int deleteSrmSupplierScoringCriteriaDefinitionById(Long id);

    /**
     * 批量删除供应商评分标准定义
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierScoringCriteriaDefinitionByIds(Long[] ids);
}
