package com.srm.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.srm.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.srm.supplier.domain.SrmSupplierContactInformation;
import com.srm.supplier.mapper.SrmSupplierInformationMapper;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.service.ISrmSupplierInformationService;

/**
 * 供应商信息Service业务层处理
 * 
 * @author sakai
 * @date 2024-07-01
 */
@Service
public class SrmSupplierInformationServiceImpl implements ISrmSupplierInformationService 
{
    @Autowired
    private SrmSupplierInformationMapper srmSupplierInformationMapper;

    /**
     * 查询供应商信息
     * 
     * @param id 供应商信息主键
     * @return 供应商信息
     */
    @Override
    public SrmSupplierInformation selectSrmSupplierInformationById(Long id)
    {
        return srmSupplierInformationMapper.selectSrmSupplierInformationById(id);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param srmSupplierInformation 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<SrmSupplierInformation> selectSrmSupplierInformationList(SrmSupplierInformation srmSupplierInformation)
    {
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
    public int insertSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation)
    {
        int rows = srmSupplierInformationMapper.insertSrmSupplierInformation(srmSupplierInformation);
        insertSrmSupplierContactInformation(srmSupplierInformation);
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
    public int updateSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation)
    {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierId(srmSupplierInformation.getId());
        insertSrmSupplierContactInformation(srmSupplierInformation);
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
    public int deleteSrmSupplierInformationByIds(Long[] ids)
    {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierIds(ids);
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
    public int deleteSrmSupplierInformationById(Long id)
    {
        srmSupplierInformationMapper.deleteSrmSupplierContactInformationBySupplierId(id);
        return srmSupplierInformationMapper.deleteSrmSupplierInformationById(id);
    }

    /**
     * 新增供应商联系人信息信息
     * 
     * @param srmSupplierInformation 供应商信息对象
     */
    public void insertSrmSupplierContactInformation(SrmSupplierInformation srmSupplierInformation)
    {
        List<SrmSupplierContactInformation> srmSupplierContactInformationList = srmSupplierInformation.getSrmSupplierContactInformationList();
        Long id = srmSupplierInformation.getId();
        if (StringUtils.isNotNull(srmSupplierContactInformationList))
        {
            List<SrmSupplierContactInformation> list = new ArrayList<SrmSupplierContactInformation>();
            for (SrmSupplierContactInformation srmSupplierContactInformation : srmSupplierContactInformationList)
            {
                srmSupplierContactInformation.setSupplierId(id);
                list.add(srmSupplierContactInformation);
            }
            if (list.size() > 0)
            {
                srmSupplierInformationMapper.batchSrmSupplierContactInformation(list);
            }
        }
    }
}
