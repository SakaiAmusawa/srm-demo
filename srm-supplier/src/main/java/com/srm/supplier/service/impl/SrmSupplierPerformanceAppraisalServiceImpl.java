package com.srm.supplier.service.impl;

import com.srm.common.utils.DateUtils;
import com.srm.common.utils.StringUtils;
import com.srm.supplier.domain.*;
import com.srm.supplier.mapper.SrmSupplierPerformanceAppraisalMapper;
import com.srm.supplier.service.ISrmSupplierPerformanceAppraisalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 供应商绩效考评Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-11
 */
@Slf4j
@Service
public class SrmSupplierPerformanceAppraisalServiceImpl implements ISrmSupplierPerformanceAppraisalService {
    @Autowired
    private SrmSupplierPerformanceAppraisalMapper srmSupplierPerformanceAppraisalMapper;

    /**
     * 查询供应商绩效考评
     *
     * @param id 供应商绩效考评主键
     * @return 供应商绩效考评
     */
    @Override
    public SrmSupplierPerformanceAppraisal selectSrmSupplierPerformanceAppraisalById(Long id) {
        return srmSupplierPerformanceAppraisalMapper.selectSrmSupplierPerformanceAppraisalById(id);
    }

    /**
     * 查询供应商绩效考评列表
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评
     * @return 供应商绩效考评
     */
    @Override
    public List<SrmSupplierPerformanceAppraisal> selectSrmSupplierPerformanceAppraisalList(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal) {
        return srmSupplierPerformanceAppraisalMapper.selectSrmSupplierPerformanceAppraisalList(srmSupplierPerformanceAppraisal);
    }

    /**
     * 新增供应商绩效考评
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierPerformanceAppraisal(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal) {
        srmSupplierPerformanceAppraisal.setCreateTime(DateUtils.getNowDate());
        int rows = srmSupplierPerformanceAppraisalMapper.insertSrmSupplierPerformanceAppraisal(srmSupplierPerformanceAppraisal);
        insertSrmSupplierPerformanceAppraisalSupplier(srmSupplierPerformanceAppraisal);
        return rows;
    }

    /**
     * 修改供应商绩效考评
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierPerformanceAppraisal(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal) {
        srmSupplierPerformanceAppraisalMapper.deleteSrmSupplierPerformanceAppraisalSupplierByPerformanceAppraisalId(srmSupplierPerformanceAppraisal.getId());
        insertSrmSupplierPerformanceAppraisalSupplier(srmSupplierPerformanceAppraisal);
        return srmSupplierPerformanceAppraisalMapper.updateSrmSupplierPerformanceAppraisal(srmSupplierPerformanceAppraisal);
    }

    /**
     * 批量删除供应商绩效考评
     *
     * @param ids 需要删除的供应商绩效考评主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierPerformanceAppraisalByIds(Long[] ids) {
        srmSupplierPerformanceAppraisalMapper.deleteSrmSupplierPerformanceAppraisalSupplierByPerformanceAppraisalIds(ids);
        return srmSupplierPerformanceAppraisalMapper.deleteSrmSupplierPerformanceAppraisalByIds(ids);
    }

    /**
     * 删除供应商绩效考评信息
     *
     * @param id 供应商绩效考评主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierPerformanceAppraisalById(Long id) {
        srmSupplierPerformanceAppraisalMapper.deleteSrmSupplierPerformanceAppraisalSupplierByPerformanceAppraisalId(id);
        return srmSupplierPerformanceAppraisalMapper.deleteSrmSupplierPerformanceAppraisalById(id);
    }

    @Override
    public List<SrmSupplierInformation> selectSupplierList() {
        return srmSupplierPerformanceAppraisalMapper.selectSupplierList();
    }

    @Override
    public List<SrmSupplierScoringTemplateDefinition> selectTemplateList() {
        return srmSupplierPerformanceAppraisalMapper.selectTemplateList();
    }

    @Override
    public List<SrmSupplierScoringCriteriaDefinition> selectCriterList(Long id) {
        List<Long> criteriaIds = srmSupplierPerformanceAppraisalMapper.selectCriterIdByTemplateId(id);
        log.debug("criteriaIds:{}", criteriaIds);
        List<SrmSupplierScoringCriteriaDefinition> supplierScoringCriteriaDefinitions = new ArrayList<>();
        for (Long criteriaId : criteriaIds) {
            supplierScoringCriteriaDefinitions.add(srmSupplierPerformanceAppraisalMapper.selectCriteriaById(criteriaId));
        }
        return supplierScoringCriteriaDefinitions;
    }

    @Override
    public List<SrmSupplierScoringCriteriaDefinition> selectCriterListByTemplateName(String templateName) {
        //根据名字找ID
        Long id = srmSupplierPerformanceAppraisalMapper.selectTemplateIdByTemplateName(templateName);
        List<Long> criteriaIds = srmSupplierPerformanceAppraisalMapper.selectCriterIdByTemplateId(id);
        log.debug("criteriaIds:{}", criteriaIds);
        List<SrmSupplierScoringCriteriaDefinition> supplierScoringCriteriaDefinitions = new ArrayList<>();
        for (Long criteriaId : criteriaIds) {
            supplierScoringCriteriaDefinitions.add(srmSupplierPerformanceAppraisalMapper.selectCriteriaById(criteriaId));
        }
        return supplierScoringCriteriaDefinitions;
    }

    /**
     * 新增绩效考评参评供应商信息
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评对象
     */
    public void insertSrmSupplierPerformanceAppraisalSupplier(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal) {
        List<SrmSupplierPerformanceAppraisalSupplier> srmSupplierPerformanceAppraisalSupplierList = srmSupplierPerformanceAppraisal.getSrmSupplierPerformanceAppraisalSupplierList();
        Long id = srmSupplierPerformanceAppraisal.getId();
        if (StringUtils.isNotNull(srmSupplierPerformanceAppraisalSupplierList)) {
            List<SrmSupplierPerformanceAppraisalSupplier> list = new ArrayList<SrmSupplierPerformanceAppraisalSupplier>();
            for (SrmSupplierPerformanceAppraisalSupplier srmSupplierPerformanceAppraisalSupplier : srmSupplierPerformanceAppraisalSupplierList) {
                srmSupplierPerformanceAppraisalSupplier.setPerformanceAppraisalId(id);
                list.add(srmSupplierPerformanceAppraisalSupplier);
            }
            if (list.size() > 0) {
                srmSupplierPerformanceAppraisalMapper.batchSrmSupplierPerformanceAppraisalSupplier(list);
            }
        }
    }
}
