package com.srm.sample.mapper;

import com.srm.sample.domain.SrmSupplierSampleDelivery;
import com.srm.sample.domain.SrmSupplierSampleDeliveryMaterial;
import com.srm.sample.domain.SrmSupplierSampleSender;
import com.srm.supplier.domain.SrmSupplierContactInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供应商送样Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-19
 */

@Repository
public interface SrmSupplierSampleDeliveryMapper {
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
     * 删除供应商送样
     *
     * @param id 供应商送样主键
     * @return 结果
     */
    public int deleteSrmSupplierSampleDeliveryById(Long id);

    /**
     * 批量删除供应商送样
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSampleDeliveryByIds(Long[] ids);

    /**
     * 批量删除送样方信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSampleSenderBySampleIds(Long[] ids);

    /**
     * 批量新增送样方信息
     *
     * @param srmSupplierSampleSenderList 送样方信息列表
     * @return 结果
     */
    public int batchSrmSupplierSampleSender(List<SrmSupplierSampleSender> srmSupplierSampleSenderList);


    /**
     * 通过供应商送样主键删除送样方信息信息
     *
     * @param id 供应商送样ID
     * @return 结果
     */
    public int deleteSrmSupplierSampleSenderBySampleId(Long id);


    /**
     * 批量删除供应商送样物料
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSampleDeliveryMaterialBySampleIds(Long[] ids);

    /**
     * 批量新增供应商送样物料
     *
     * @param srmSupplierSampleDeliveryMaterialList 供应商送样物料列表
     * @return 结果
     */
    public int batchSrmSupplierSampleDeliveryMaterial(List<SrmSupplierSampleDeliveryMaterial> srmSupplierSampleDeliveryMaterialList);


    /**
     * 通过供应商送样主键删除供应商送样物料信息
     *
     * @param id 供应商送样ID
     * @return 结果
     */
    public int deleteSrmSupplierSampleDeliveryMaterialBySampleId(Long id);

    SrmSupplierContactInformation selectSrmContactBySupplierId(Long id);
}
