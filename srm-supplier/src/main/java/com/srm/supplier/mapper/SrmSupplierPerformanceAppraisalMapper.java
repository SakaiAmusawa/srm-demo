package com.srm.supplier.mapper;

import com.srm.supplier.domain.*;
import com.srm.supplier.domain.param.AppraisalResult;
import com.srm.supplier.domain.param.CriteriaList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供应商绩效考评Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-11
 */
@Repository
public interface SrmSupplierPerformanceAppraisalMapper {
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
     * 删除供应商绩效考评
     *
     * @param id 供应商绩效考评主键
     * @return 结果
     */
    public int deleteSrmSupplierPerformanceAppraisalById(Long id);

    /**
     * 批量删除供应商绩效考评
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierPerformanceAppraisalByIds(Long[] ids);

    /**
     * 批量删除绩效考评参评供应商
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierPerformanceAppraisalSupplierByPerformanceAppraisalIds(Long[] ids);

    /**
     * 批量新增绩效考评参评供应商
     *
     * @param srmSupplierPerformanceAppraisalSupplierList 绩效考评参评供应商列表
     * @return 结果
     */
    public int batchSrmSupplierPerformanceAppraisalSupplier(List<SrmSupplierPerformanceAppraisalSupplier> srmSupplierPerformanceAppraisalSupplierList);


    /**
     * 通过供应商绩效考评主键删除绩效考评参评供应商信息
     *
     * @param id 供应商绩效考评ID
     * @return 结果
     */
    public int deleteSrmSupplierPerformanceAppraisalSupplierByPerformanceAppraisalId(Long id);

    List<SrmSupplierInformation> selectSupplierList();

    List<SrmSupplierScoringTemplateDefinition> selectTemplateList();

    List<Long> selectCriterIdByTemplateId(Long id);

    SrmSupplierScoringCriteriaDefinition selectCriteriaById(Long criteriaId);

    Long selectTemplateIdByTemplateName(String templateName);

    void saveCriteriaList(CriteriaList list);

    void saveAppraisalResult(AppraisalResult appraisalResult);

    void changeKpStatusByKpId(Long kpId);
}
