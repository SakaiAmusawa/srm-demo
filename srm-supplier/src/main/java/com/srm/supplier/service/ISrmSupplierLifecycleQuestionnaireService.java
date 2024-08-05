package com.srm.supplier.service;

import java.util.List;

import com.srm.common.core.domain.entity.SysDictData;
import com.srm.supplier.domain.SrmSupplierBasicInformation;
import com.srm.supplier.domain.SrmSupplierLifecycleQuestionnaire;

/**
 * 供应商生命周期调查Service接口
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public interface ISrmSupplierLifecycleQuestionnaireService 
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
     * 批量删除供应商生命周期调查
     * 
     * @param ids 需要删除的供应商生命周期调查主键集合
     * @return 结果
     */
    public int deleteSrmSupplierLifecycleQuestionnaireByIds(Long[] ids);

    /**
     * 删除供应商生命周期调查信息
     * 
     * @param id 供应商生命周期调查主键
     * @return 结果
     */
    public int deleteSrmSupplierLifecycleQuestionnaireById(Long id);

    List<SysDictData> selectDictDetail(String dictKey);
}
