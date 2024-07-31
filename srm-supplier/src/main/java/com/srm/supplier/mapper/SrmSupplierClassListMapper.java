package com.srm.supplier.mapper;

import com.srm.supplier.domain.SrmSupplierClassList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供应商分类Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-05
 */

@Repository
public interface SrmSupplierClassListMapper {
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
     * 删除供应商分类
     *
     * @param id 供应商分类主键
     * @return 结果
     */
    public int deleteSrmSupplierClassListById(Long id);

    /**
     * 批量删除供应商分类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierClassListByIds(Long[] ids);

    void insertSrmClassList(SrmSupplierClassList srmSupplierClassList);

    List<SrmSupplierClassList> selectClassList();
}
