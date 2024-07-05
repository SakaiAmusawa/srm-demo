package com.srm.supplier.service;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierClassDefinition;

/**
 * 供应商分类定义Service接口
 * 
 * @author ruoyi
 * @date 2024-07-05
 */
public interface ISrmSupplierClassDefinitionService 
{
    /**
     * 查询供应商分类定义
     * 
     * @param id 供应商分类定义主键
     * @return 供应商分类定义
     */
    public SrmSupplierClassDefinition selectSrmSupplierClassDefinitionById(Long id);

    /**
     * 查询供应商分类定义列表
     * 
     * @param srmSupplierClassDefinition 供应商分类定义
     * @return 供应商分类定义集合
     */
    public List<SrmSupplierClassDefinition> selectSrmSupplierClassDefinitionList(SrmSupplierClassDefinition srmSupplierClassDefinition);

    /**
     * 新增供应商分类定义
     * 
     * @param srmSupplierClassDefinition 供应商分类定义
     * @return 结果
     */
    public int insertSrmSupplierClassDefinition(SrmSupplierClassDefinition srmSupplierClassDefinition);

    /**
     * 修改供应商分类定义
     * 
     * @param srmSupplierClassDefinition 供应商分类定义
     * @return 结果
     */
    public int updateSrmSupplierClassDefinition(SrmSupplierClassDefinition srmSupplierClassDefinition);

    /**
     * 批量删除供应商分类定义
     * 
     * @param ids 需要删除的供应商分类定义主键集合
     * @return 结果
     */
    public int deleteSrmSupplierClassDefinitionByIds(Long[] ids);

    /**
     * 删除供应商分类定义信息
     * 
     * @param id 供应商分类定义主键
     * @return 结果
     */
    public int deleteSrmSupplierClassDefinitionById(Long id);
}
