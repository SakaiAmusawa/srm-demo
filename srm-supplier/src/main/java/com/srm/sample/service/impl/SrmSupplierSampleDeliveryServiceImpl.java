package com.srm.sample.service.impl;

import com.srm.common.utils.StringUtils;
import com.srm.sample.domain.SrmSupplierSampleDelivery;
import com.srm.sample.domain.SrmSupplierSampleDeliveryMaterial;
import com.srm.sample.domain.SrmSupplierSampleSender;
import com.srm.sample.mapper.SrmSupplierSampleDeliveryMapper;
import com.srm.sample.service.ISrmSupplierSampleDeliveryService;
import com.srm.supplier.domain.SrmSupplierContactInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商送样Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-19
 */
@Service
public class SrmSupplierSampleDeliveryServiceImpl implements ISrmSupplierSampleDeliveryService {
    @Autowired
    private SrmSupplierSampleDeliveryMapper srmSupplierSampleDeliveryMapper;

    /**
     * 查询供应商送样
     *
     * @param id 供应商送样主键
     * @return 供应商送样
     */
    @Override
    public SrmSupplierSampleDelivery selectSrmSupplierSampleDeliveryById(Long id) {
        return srmSupplierSampleDeliveryMapper.selectSrmSupplierSampleDeliveryById(id);
    }

    /**
     * 查询供应商送样列表
     *
     * @param srmSupplierSampleDelivery 供应商送样
     * @return 供应商送样
     */
    @Override
    public List<SrmSupplierSampleDelivery> selectSrmSupplierSampleDeliveryList(SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        return srmSupplierSampleDeliveryMapper.selectSrmSupplierSampleDeliveryList(srmSupplierSampleDelivery);
    }

    /**
     * 新增供应商送样
     *
     * @param srmSupplierSampleDelivery 供应商送样
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierSampleDelivery(SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        int rows = srmSupplierSampleDeliveryMapper.insertSrmSupplierSampleDelivery(srmSupplierSampleDelivery);
        insertSrmSupplierSampleSender(srmSupplierSampleDelivery);
        insertSrmSupplierSampleDeliveryMaterial(srmSupplierSampleDelivery);
        return rows;
    }

    /**
     * 修改供应商送样
     *
     * @param srmSupplierSampleDelivery 供应商送样
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierSampleDelivery(SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleSenderBySampleId(srmSupplierSampleDelivery.getId());
        insertSrmSupplierSampleSender(srmSupplierSampleDelivery);
        srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleDeliveryMaterialBySampleId(srmSupplierSampleDelivery.getId());
        insertSrmSupplierSampleDeliveryMaterial(srmSupplierSampleDelivery);
        return srmSupplierSampleDeliveryMapper.updateSrmSupplierSampleDelivery(srmSupplierSampleDelivery);
    }

    /**
     * 批量删除供应商送样
     *
     * @param ids 需要删除的供应商送样主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierSampleDeliveryByIds(Long[] ids) {
        srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleSenderBySampleIds(ids);
        srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleDeliveryMaterialBySampleIds(ids);
        return srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleDeliveryByIds(ids);
    }

    /**
     * 删除供应商送样信息
     *
     * @param id 供应商送样主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierSampleDeliveryById(Long id) {
        srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleSenderBySampleId(id);
        srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleDeliveryMaterialBySampleId(id);
        return srmSupplierSampleDeliveryMapper.deleteSrmSupplierSampleDeliveryById(id);
    }

    @Override
    public SrmSupplierContactInformation selectContactById(Long id) {
        SrmSupplierContactInformation srmSupplierContactInformation = srmSupplierSampleDeliveryMapper.selectSrmContactBySupplierId(id);
        return srmSupplierContactInformation;
    }

    /**
     * 新增送样方信息信息
     *
     * @param srmSupplierSampleDelivery 供应商送样对象
     */
    public void insertSrmSupplierSampleSender(SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        List<SrmSupplierSampleSender> srmSupplierSampleSenderList = srmSupplierSampleDelivery.getSrmSupplierSampleSenderList();
        Long id = srmSupplierSampleDelivery.getId();
        if (StringUtils.isNotNull(srmSupplierSampleSenderList)) {
            List<SrmSupplierSampleSender> list = new ArrayList<SrmSupplierSampleSender>();
            for (SrmSupplierSampleSender srmSupplierSampleSender : srmSupplierSampleSenderList) {
                srmSupplierSampleSender.setSampleId(id);
                list.add(srmSupplierSampleSender);
            }
            if (list.size() > 0) {
                srmSupplierSampleDeliveryMapper.batchSrmSupplierSampleSender(list);
            }
        }
    }

    /**
     * 新增供应商送样物料信息
     *
     * @param srmSupplierSampleDelivery 供应商送样对象
     */
    public void insertSrmSupplierSampleDeliveryMaterial(SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        List<SrmSupplierSampleDeliveryMaterial> srmSupplierSampleDeliveryMaterialList = srmSupplierSampleDelivery.getSrmSupplierSampleDeliveryMaterialList();
        Long id = srmSupplierSampleDelivery.getId();
        if (StringUtils.isNotNull(srmSupplierSampleDeliveryMaterialList)) {
            List<SrmSupplierSampleDeliveryMaterial> list = new ArrayList<SrmSupplierSampleDeliveryMaterial>();
            for (SrmSupplierSampleDeliveryMaterial srmSupplierSampleDeliveryMaterial : srmSupplierSampleDeliveryMaterialList) {
                srmSupplierSampleDeliveryMaterial.setSampleId(id);
                list.add(srmSupplierSampleDeliveryMaterial);
            }
            if (list.size() > 0) {
                srmSupplierSampleDeliveryMapper.batchSrmSupplierSampleDeliveryMaterial(list);
            }
        }
    }
}
