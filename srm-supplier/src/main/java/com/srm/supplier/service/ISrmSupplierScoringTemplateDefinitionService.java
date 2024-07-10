package com.srm.supplier.service;

import java.util.List;

import com.srm.supplier.domain.SrmSupplierClassDefinition;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.domain.SrmSupplierScoringTemplateDefinition;

/**
 * 评分模板定义Service接口
 * 
 * @author ruoyi
 * @date 2024-07-10
 */
public interface ISrmSupplierScoringTemplateDefinitionService 
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
     * 批量删除评分模板定义
     * 
     * @param ids 需要删除的评分模板定义主键集合
     * @return 结果
     */
    public int deleteSrmSupplierScoringTemplateDefinitionByIds(Long[] ids);

    /**
     * 删除评分模板定义信息
     * 
     * @param id 评分模板定义主键
     * @return 结果
     */
    public int deleteSrmSupplierScoringTemplateDefinitionById(Long id);

    List<SrmSupplierScoringCriteriaDefinition> getCriteria();
}
