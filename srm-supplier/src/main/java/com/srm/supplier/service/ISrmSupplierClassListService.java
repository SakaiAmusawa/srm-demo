package com.srm.supplier.service;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierClassList;
import com.srm.supplier.domain.SrmSupplierInformation;

/**
 * 供应商分类Service接口
 * 
 * @author ruoyi
 * @date 2024-07-05
 */
public interface ISrmSupplierClassListService 
{
    /**
     * 查询供应商分类
     * 
     * @param id 供应商分类主键
     * @return 供应商分类
     */
    public SrmSupplierClassList selectSrmSupplierClassListById(Long id);

    /**
     * 查询供应商分类列表
     * 
     * @param srmSupplierClassList 供应商分类
     * @return 供应商分类集合
     */
    public List<SrmSupplierClassList> selectSrmSupplierClassListList(SrmSupplierClassList srmSupplierClassList);

    /**
     * 新增供应商分类
     * 
     * @param srmSupplierClassList 供应商分类
     * @return 结果
     */
    public int insertSrmSupplierClassList(SrmSupplierClassList srmSupplierClassList);

    /**
     * 修改供应商分类
     * 
     * @param srmSupplierClassList 供应商分类
     * @return 结果
     */
    public int updateSrmSupplierClassList(SrmSupplierClassList srmSupplierClassList);

    /**
     * 批量删除供应商分类
     * 
     * @param ids 需要删除的供应商分类主键集合
     * @return 结果
     */
    public int deleteSrmSupplierClassListByIds(Long[] ids);

    /**
     * 删除供应商分类信息
     * 
     * @param id 供应商分类主键
     * @return 结果
     */
    public int deleteSrmSupplierClassListById(Long id);

    List<SrmSupplierInformation> querySupplierInfor();

    void insertClass(SrmSupplierClassList srmSupplierClassList);
}
