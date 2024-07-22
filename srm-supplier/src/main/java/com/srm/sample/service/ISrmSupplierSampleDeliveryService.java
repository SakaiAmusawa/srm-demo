package com.srm.sample.service;

import java.util.List;
import com.srm.sample.domain.SrmSupplierSampleDelivery;
import com.srm.supplier.domain.SrmSupplierContactInformation;

/**
 * 供应商送样Service接口
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public interface ISrmSupplierSampleDeliveryService 
{
    /**
     * 查询供应商送样
     * 
     * @param id 供应商送样主键
     * @return 供应商送样
     */
    public SrmSupplierSampleDelivery selectSrmSupplierSampleDeliveryById(Long id);

    /**
     * 查询供应商送样列表
     * 
     * @param srmSupplierSampleDelivery 供应商送样
     * @return 供应商送样集合
     */
    public List<SrmSupplierSampleDelivery> selectSrmSupplierSampleDeliveryList(SrmSupplierSampleDelivery srmSupplierSampleDelivery);

    /**
     * 新增供应商送样
     * 
     * @param srmSupplierSampleDelivery 供应商送样
     * @return 结果
     */
    public int insertSrmSupplierSampleDelivery(SrmSupplierSampleDelivery srmSupplierSampleDelivery);

    /**
     * 修改供应商送样
     * 
     * @param srmSupplierSampleDelivery 供应商送样
     * @return 结果
     */
    public int updateSrmSupplierSampleDelivery(SrmSupplierSampleDelivery srmSupplierSampleDelivery);

    /**
     * 批量删除供应商送样
     * 
     * @param ids 需要删除的供应商送样主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSampleDeliveryByIds(Long[] ids);

    /**
     * 删除供应商送样信息
     * 
     * @param id 供应商送样主键
     * @return 结果
     */
    public int deleteSrmSupplierSampleDeliveryById(Long id);

    SrmSupplierContactInformation selectContactById(Long id);
}
