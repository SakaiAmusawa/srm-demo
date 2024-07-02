package com.srm.supplier.service.impl;

import com.srm.common.utils.StringUtils;
import com.srm.supplier.domain.*;
import com.srm.supplier.mapper.SrmSupplierInformationMapper;
import com.srm.supplier.service.ISrmSupplierInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商信息Service业务层处理
 *
 * @author sakai
 * @date 2024-07-01
 */
@Service
public class SrmSupplierInformationServiceImpl implements ISrmSupplierInformationService {
    @Autowired
    private SrmSupplierInformationMapper srmSupplierInformationMapper;

    /**
     * 查询供应商信息
     *
     * @param id 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public SrmSupplierInformation selectSrmSupplierInformationById(Long id) {
        return srmSupplierInformationMapper.selectSrmSupplierInformationById(id);
    }

    /**
     * 查询供应商信息列表
     *
     * @param srmSupplierInformation 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<SrmSupplierInformation> selectSrmSupplierInformationList(SrmSupplierInformation srmSupplierInformation) {
        return srmSupplierInformationMapper.selectSrmSupplierInformationList(srmSupplierInformation);
    }

    /**
     * 新增供应商信息
     *
     * @param srmSupplierInformation 供应商信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation) {
        int rows = srmSupplierInformationMapper.insertSrmSupplierInformation(srmSupplierInformation);
        insertSrmSupplierContactInformation(srmSupplierInformation);
        insertSrmSupplierAddressInformation(srmSupplierInformation);
        insertSrmSupplierBankInformation(srmSupplierInformation);
        insertSrmSupplierInvoiceInformation(srmSupplierInformation);
        return rows;
    }

    /**
     * 修改供应商信息
     *
     * @param srmSupplierInformation 供应商信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation) {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierId(srmSupplierInformation.getId());
        insertSrmSupplierContactInformation(srmSupplierInformation);
        insertSrmSupplierAddressInformation(srmSupplierInformation);
        insertSrmSupplierBankInformation(srmSupplierInformation);
        insertSrmSupplierInvoiceInformation(srmSupplierInformation);
        return srmSupplierInformationMapper.updateSrmSupplierInformation(srmSupplierInformation);
    }

    /**
     * 批量删除供应商信息
     *
     * @param ids 需要删除的供应商信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierInformationByIds(Long[] ids) {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierIds(ids);
        srmSupplierInformationMapper.deleteSrmSupplierAddressInformationBySupplierIds(ids);
        srmSupplierInformationMapper.deleteSrmSupplierInformationByIds(ids);
        srmSupplierInformationMapper.deleteSrmSupplierInvoiceInformationBySupplierIds(ids);
        return srmSupplierInformationMapper.deleteSrmSupplierInformationByIds(ids);
    }

    /**
     * 删除供应商信息信息
     *
     * @param id 供应商信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierInformationById(Long id) {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierId(id);
        srmSupplierInformationMapper.deleteSrmSupplierAddressInformationBySupplierId(id);
        srmSupplierInformationMapper.deleteSrmSupplierInformationById(id);
        srmSupplierInformationMapper.deleteSrmSupplierInvoiceInformationBySupplierId(id);
        return srmSupplierInformationMapper.deleteSrmSupplierInformationById(id);
    }

    /**
     * 新增供应商联系人信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierContactInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierContactInformation> srmSupplierContactInformationList = srmSupplierInformation.getSrmSupplierContactInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierContactInformationList)) {
            List<SrmSupplierContactInformation> list = new ArrayList<SrmSupplierContactInformation>();
            for (SrmSupplierContactInformation srmSupplierContactInformation : srmSupplierContactInformationList) {
                srmSupplierContactInformation.setSupplierId(id);
                list.add(srmSupplierContactInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierContactInformation(list);
            }
        }
    }

    /**
     * 新增供应商地址信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierAddressInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierAddressInformation> srmSupplierAddressInformationList = srmSupplierInformation.getSrmSupplierAddressInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierAddressInformationList)) {
            List<SrmSupplierAddressInformation> list = new ArrayList<SrmSupplierAddressInformation>();
            for (SrmSupplierAddressInformation srmSupplierAddressInformation : srmSupplierAddressInformationList) {
                srmSupplierAddressInformation.setSupplierId(id);
                list.add(srmSupplierAddressInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierAddressInformation(list);
            }
        }
    }


    /**
     * 新增供应商银行信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierBankInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierBankInformation> srmSupplierBankInformationList = srmSupplierInformation.getSrmSupplierBankInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierBankInformationList)) {
            List<SrmSupplierBankInformation> list = new ArrayList<SrmSupplierBankInformation>();
            for (SrmSupplierBankInformation srmSupplierBankInformation : srmSupplierBankInformationList) {
                srmSupplierBankInformation.setSupplierId(id);
                list.add(srmSupplierBankInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierBankInformation(list);
            }
        }
    }

    /**
     * 新增供应商开票信息信息
     *
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierInvoiceInformation(SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierInvoiceInformation> srmSupplierInvoiceInformationList = srmSupplierInformation.getSrmSupplierInvoiceInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierInvoiceInformationList)) {
            List<SrmSupplierInvoiceInformation> list = new ArrayList<SrmSupplierInvoiceInformation>();
            for (SrmSupplierInvoiceInformation srmSupplierInvoiceInformation : srmSupplierInvoiceInformationList) {
                srmSupplierInvoiceInformation.setSupplierId(id);
                list.add(srmSupplierInvoiceInformation);
            }
            if (list.size() > 0) {
                srmSupplierInformationMapper.batchSrmSupplierInvoiceInformation(list);
            }
        }
    }
}
