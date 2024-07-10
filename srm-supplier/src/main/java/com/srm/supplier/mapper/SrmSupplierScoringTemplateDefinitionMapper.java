package com.srm.supplier.mapper;

import java.util.List;

import com.srm.supplier.domain.SrmSupplierClassDefinition;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.domain.SrmSupplierScoringTemplateDefinition;
import com.srm.supplier.domain.SrmSupplierScoringTemplateCriteria;

/**
 * 评分模板定义Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-10
 */
public interface SrmSupplierScoringTemplateDefinitionMapper 
{
    /**
     * 查询评分模板定义
     * 
     * @param id 评分模板定义主键
     * @return 评分模板定义
     */
    public SrmSupplierScoringTemplateDefinition selectSrmSupplierScoringTemplateDefinitionById(Long id);

    /**
     * 查询评分模板定义列表
     * 
     * @param srmSupplierScoringTemplateDefinition 评分模板定义
     * @return 评分模板定义集合
     */
    public List<SrmSupplierScoringTemplateDefinition> selectSrmSupplierScoringTemplateDefinitionList(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition);

    /**
     * 新增评分模板定义
     * 
     * @param srmSupplierScoringTemplateDefinition 评分模板定义
     * @return 结果
     */
    public int insertSrmSupplierScoringTemplateDefinition(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition);

    /**
     * 修改评分模板定义
     * 
     * @param srmSupplierScoringTemplateDefinition 评分模板定义
     * @return 结果
     */
    public int updateSrmSupplierScoringTemplateDefinition(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition);

    /**
     * 删除评分模板定义
     * 
     * @param id 评分模板定义主键
     * @return 结果
     */
    public int deleteSrmSupplierScoringTemplateDefinitionById(Long id);

    /**
     * 批量删除评分模板定义
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierScoringTemplateDefinitionByIds(Long[] ids);

    /**
     * 批量删除供应商评分模板指标关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierScoringTemplateCriteriaByTemplateIds(Long[] ids);
    
    /**
     * 批量新增供应商评分模板指标关联
     * 
     * @param srmSupplierScoringTemplateCriteriaList 供应商评分模板指标关联列表
     * @return 结果
     */
    public int batchSrmSupplierScoringTemplateCriteria(List<SrmSupplierScoringTemplateCriteria> srmSupplierScoringTemplateCriteriaList);
    

    /**
     * 通过评分模板定义主键删除供应商评分模板指标关联信息
     * 
     * @param id 评分模板定义ID
     * @return 结果
     */
    public int deleteSrmSupplierScoringTemplateCriteriaByTemplateId(Long id);

    List<SrmSupplierScoringCriteriaDefinition> selectCriteria();

    List<SrmSupplierScoringTemplateCriteria> selectSrmSupplierScoringTemplateCriteriaByTemplateId(Long id);

    SrmSupplierScoringCriteriaDefinition getCriteria(Long criteriaId);
}
