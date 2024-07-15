package com.srm.supplier.service;

import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.domain.SrmSupplierPerformanceAppraisal;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.domain.SrmSupplierScoringTemplateDefinition;
import com.srm.supplier.domain.param.ScoreParam;
import com.srm.supplier.domain.vo.CalculateResultVO;

import java.util.List;

/**
 * 供应商绩效考评Service接口
 *
 * @author ruoyi
 * @date 2024-07-11
 */
public interface ISrmSupplierPerformanceAppraisalService {
    /**
     * 查询供应商绩效考评
     *
     * @param id 供应商绩效考评主键
     * @return 供应商绩效考评
     */
    public SrmSupplierPerformanceAppraisal selectSrmSupplierPerformanceAppraisalById(Long id);

    /**
     * 查询供应商绩效考评列表
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评
     * @return 供应商绩效考评集合
     */
    public List<SrmSupplierPerformanceAppraisal> selectSrmSupplierPerformanceAppraisalList(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal);

    /**
     * 新增供应商绩效考评
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评
     * @return 结果
     */
    public int insertSrmSupplierPerformanceAppraisal(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal);

    /**
     * 修改供应商绩效考评
     *
     * @param srmSupplierPerformanceAppraisal 供应商绩效考评
     * @return 结果
     */
    public int updateSrmSupplierPerformanceAppraisal(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal);

    /**
     * 批量删除供应商绩效考评
     *
     * @param ids 需要删除的供应商绩效考评主键集合
     * @return 结果
     */
    public int deleteSrmSupplierPerformanceAppraisalByIds(Long[] ids);

    /**
     * 删除供应商绩效考评信息
     *
     * @param id 供应商绩效考评主键
     * @return 结果
     */
    public int deleteSrmSupplierPerformanceAppraisalById(Long id);

    List<SrmSupplierInformation> selectSupplierList();

    List<SrmSupplierScoringTemplateDefinition> selectTemplateList();

    List<SrmSupplierScoringCriteriaDefinition> selectCriterList(Long id);

    List<SrmSupplierScoringCriteriaDefinition> selectCriterListByTemplateName(String templateName);

    CalculateResultVO getTotal(List<ScoreParam> scoreParams);
}
