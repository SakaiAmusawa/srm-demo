package com.srm.supplier.service.impl;

import com.srm.common.utils.StringUtils;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.domain.SrmSupplierScoringTemplateCriteria;
import com.srm.supplier.domain.SrmSupplierScoringTemplateDefinition;
import com.srm.supplier.mapper.SrmSupplierScoringTemplateDefinitionMapper;
import com.srm.supplier.service.ISrmSupplierScoringTemplateDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 评分模板定义Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-10
 */
@Service
public class SrmSupplierScoringTemplateDefinitionServiceImpl implements ISrmSupplierScoringTemplateDefinitionService {
    @Autowired
    private SrmSupplierScoringTemplateDefinitionMapper srmSupplierScoringTemplateDefinitionMapper;

    /**
     * 查询评分模板定义
     *
     * @param id 评分模板定义主键
     * @return 评分模板定义
     */
    @Override
    public SrmSupplierScoringTemplateDefinition selectSrmSupplierScoringTemplateDefinitionById(Long id) {
        SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition = srmSupplierScoringTemplateDefinitionMapper.selectSrmSupplierScoringTemplateDefinitionById(id);

        List<SrmSupplierScoringTemplateCriteria> srmSupplierScoringTemplateCriteria = srmSupplierScoringTemplateDefinitionMapper.selectSrmSupplierScoringTemplateCriteriaByTemplateId(id);

        List<SrmSupplierScoringCriteriaDefinition> srmSupplierScoringCriteria = new ArrayList<>();
        for (SrmSupplierScoringTemplateCriteria srmSupplierScoringTemplateCriterion : srmSupplierScoringTemplateCriteria) {
            Long criteriaId = srmSupplierScoringTemplateCriterion.getId();
            SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition = srmSupplierScoringTemplateDefinitionMapper.getCriteria(criteriaId);
            srmSupplierScoringCriteria.add(srmSupplierScoringCriteriaDefinition);
        }

        srmSupplierScoringTemplateDefinition.setSrmSupplierScoringCriteriaList(srmSupplierScoringCriteria);

        return srmSupplierScoringTemplateDefinition;
    }

    /**
     * 查询评分模板定义列表
     *
     * @param srmSupplierScoringTemplateDefinition 评分模板定义
     * @return 评分模板定义
     */
    @Override
    public List<SrmSupplierScoringTemplateDefinition> selectSrmSupplierScoringTemplateDefinitionList(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        return srmSupplierScoringTemplateDefinitionMapper.selectSrmSupplierScoringTemplateDefinitionList(srmSupplierScoringTemplateDefinition);
    }

    /**
     * 新增评分模板定义
     *
     * @param srmSupplierScoringTemplateDefinition 评分模板定义
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierScoringTemplateDefinition(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        int rows = srmSupplierScoringTemplateDefinitionMapper.insertSrmSupplierScoringTemplateDefinition(srmSupplierScoringTemplateDefinition);
        insertSrmSupplierScoringTemplateCriteria(srmSupplierScoringTemplateDefinition);
        return rows;
    }

    /**
     * 修改评分模板定义
     *
     * @param srmSupplierScoringTemplateDefinition 评分模板定义
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierScoringTemplateDefinition(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        srmSupplierScoringTemplateDefinitionMapper.deleteSrmSupplierScoringTemplateCriteriaByTemplateId(srmSupplierScoringTemplateDefinition.getId());
        insertSrmSupplierScoringTemplateCriteria(srmSupplierScoringTemplateDefinition);
        return srmSupplierScoringTemplateDefinitionMapper.updateSrmSupplierScoringTemplateDefinition(srmSupplierScoringTemplateDefinition);
    }

    /**
     * 批量删除评分模板定义
     *
     * @param ids 需要删除的评分模板定义主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierScoringTemplateDefinitionByIds(Long[] ids) {
        srmSupplierScoringTemplateDefinitionMapper.deleteSrmSupplierScoringTemplateCriteriaByTemplateIds(ids);
        return srmSupplierScoringTemplateDefinitionMapper.deleteSrmSupplierScoringTemplateDefinitionByIds(ids);
    }

    /**
     * 删除评分模板定义信息
     *
     * @param id 评分模板定义主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierScoringTemplateDefinitionById(Long id) {
        srmSupplierScoringTemplateDefinitionMapper.deleteSrmSupplierScoringTemplateCriteriaByTemplateId(id);
        return srmSupplierScoringTemplateDefinitionMapper.deleteSrmSupplierScoringTemplateDefinitionById(id);
    }

    @Override
    public List<SrmSupplierScoringCriteriaDefinition> getCriteria() {
        return srmSupplierScoringTemplateDefinitionMapper.selectCriteria();
    }

    /**
     * 新增供应商评分模板指标关联信息
     *
     * @param srmSupplierScoringTemplateDefinition 评分模板定义对象
     */
    public void insertSrmSupplierScoringTemplateCriteria(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        List<SrmSupplierScoringTemplateCriteria> srmSupplierScoringTemplateCriteriaList = srmSupplierScoringTemplateDefinition.getSrmSupplierScoringTemplateCriteriaList();
        Long id = srmSupplierScoringTemplateDefinition.getId();
        if (StringUtils.isNotNull(srmSupplierScoringTemplateCriteriaList)) {
            List<SrmSupplierScoringTemplateCriteria> list = new ArrayList<SrmSupplierScoringTemplateCriteria>();
            for (SrmSupplierScoringTemplateCriteria srmSupplierScoringTemplateCriteria : srmSupplierScoringTemplateCriteriaList) {
                srmSupplierScoringTemplateCriteria.setTemplateId(id);
                list.add(srmSupplierScoringTemplateCriteria);
            }
            if (list.size() > 0) {
                srmSupplierScoringTemplateDefinitionMapper.batchSrmSupplierScoringTemplateCriteria(list);
            }
        }
    }
}
