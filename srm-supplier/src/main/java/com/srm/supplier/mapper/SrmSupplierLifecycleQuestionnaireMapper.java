package com.srm.supplier.mapper;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierLifecycleQuestionnaire;
import com.srm.supplier.domain.SrmSupplierBasicInformation;

/**
 * 供应商生命周期调查Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public interface SrmSupplierLifecycleQuestionnaireMapper 
{
    /**
     * 查询供应商生命周期调查
     * 
     * @param id 供应商生命周期调查主键
     * @return 供应商生命周期调查
     */
    public SrmSupplierLifecycleQuestionnaire selectSrmSupplierLifecycleQuestionnaireById(Long id);

    /**
     * 查询供应商生命周期调查列表
     * 
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查
     * @return 供应商生命周期调查集合
     */
    public List<SrmSupplierLifecycleQuestionnaire> selectSrmSupplierLifecycleQuestionnaireList(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire);

    /**
     * 新增供应商生命周期调查
     * 
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查
     * @return 结果
     */
    public int insertSrmSupplierLifecycleQuestionnaire(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire);

    /**
     * 修改供应商生命周期调查
     * 
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查
     * @return 结果
     */
    public int updateSrmSupplierLifecycleQuestionnaire(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire);

    /**
     * 删除供应商生命周期调查
     * 
     * @param id 供应商生命周期调查主键
     * @return 结果
     */
    public int deleteSrmSupplierLifecycleQuestionnaireById(Long id);

    /**
     * 批量删除供应商生命周期调查
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierLifecycleQuestionnaireByIds(Long[] ids);

    /**
     * 批量删除供应商基本信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierBasicInformationBySurveyIds(Long[] ids);
    
    /**
     * 批量新增供应商基本信息
     * 
     * @param srmSupplierBasicInformationList 供应商基本信息列表
     * @return 结果
     */
    public int batchSrmSupplierBasicInformation(List<SrmSupplierBasicInformation> srmSupplierBasicInformationList);
    

    /**
     * 通过供应商生命周期调查主键删除供应商基本信息信息
     * 
     * @param id 供应商生命周期调查ID
     * @return 结果
     */
    public int deleteSrmSupplierBasicInformationBySurveyId(Long id);
}
