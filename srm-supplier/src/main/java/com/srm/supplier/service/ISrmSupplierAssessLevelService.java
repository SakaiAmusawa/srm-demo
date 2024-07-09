package com.srm.supplier.service;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierAssessLevel;

/**
 * 供应商评级定义Service接口
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
public interface ISrmSupplierAssessLevelService 
{
    /**
     * 查询供应商评级定义
     * 
     * @param id 供应商评级定义主键
     * @return 供应商评级定义
     */
    public SrmSupplierAssessLevel selectSrmSupplierAssessLevelById(Long id);

    /**
     * 查询供应商评级定义列表
     * 
     * @param srmSupplierAssessLevel 供应商评级定义
     * @return 供应商评级定义集合
     */
    public List<SrmSupplierAssessLevel> selectSrmSupplierAssessLevelList(SrmSupplierAssessLevel srmSupplierAssessLevel);

    /**
     * 新增供应商评级定义
     * 
     * @param srmSupplierAssessLevel 供应商评级定义
     * @return 结果
     */
    public int insertSrmSupplierAssessLevel(SrmSupplierAssessLevel srmSupplierAssessLevel);

    /**
     * 修改供应商评级定义
     * 
     * @param srmSupplierAssessLevel 供应商评级定义
     * @return 结果
     */
    public int updateSrmSupplierAssessLevel(SrmSupplierAssessLevel srmSupplierAssessLevel);

    /**
     * 批量删除供应商评级定义
     * 
     * @param ids 需要删除的供应商评级定义主键集合
     * @return 结果
     */
    public int deleteSrmSupplierAssessLevelByIds(Long[] ids);

    /**
     * 删除供应商评级定义信息
     * 
     * @param id 供应商评级定义主键
     * @return 结果
     */
    public int deleteSrmSupplierAssessLevelById(Long id);
}
