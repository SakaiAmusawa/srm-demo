package com.srm.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.system.mapper.SrmSupplierContactInformationMapper;
import com.srm.system.domain.SrmSupplierContactInformation;
import com.srm.system.service.ISrmSupplierContactInformationService;

/**
 * 供应商联系人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-01
 */
@Service
public class SrmSupplierContactInformationServiceImpl implements ISrmSupplierContactInformationService 
{
    @Autowired
    private SrmSupplierContactInformationMapper srmSupplierContactInformationMapper;

    /**
     * 查询供应商联系人信息
     * 
     * @param id 供应商联系人信息主键
     * @return 供应商联系人信息
     */
    @Override
    public SrmSupplierContactInformation selectSrmSupplierContactInformationById(Long id)
    {
        return srmSupplierContactInformationMapper.selectSrmSupplierContactInformationById(id);
    }

    /**
     * 查询供应商联系人信息列表
     * 
     * @param srmSupplierContactInformation 供应商联系人信息
     * @return 供应商联系人信息
     */
    @Override
    public List<SrmSupplierContactInformation> selectSrmSupplierContactInformationList(SrmSupplierContactInformation srmSupplierContactInformation)
    {
        return srmSupplierContactInformationMapper.selectSrmSupplierContactInformationList(srmSupplierContactInformation);
    }

    /**
     * 新增供应商联系人信息
     * 
     * @param srmSupplierContactInformation 供应商联系人信息
     * @return 结果
     */
    @Override
    public int insertSrmSupplierContactInformation(SrmSupplierContactInformation srmSupplierContactInformation)
    {
        return srmSupplierContactInformationMapper.insertSrmSupplierContactInformation(srmSupplierContactInformation);
    }

    /**
     * 修改供应商联系人信息
     * 
     * @param srmSupplierContactInformation 供应商联系人信息
     * @return 结果
     */
    @Override
    public int updateSrmSupplierContactInformation(SrmSupplierContactInformation srmSupplierContactInformation)
    {
        return srmSupplierContactInformationMapper.updateSrmSupplierContactInformation(srmSupplierContactInformation);
    }

    /**
     * 批量删除供应商联系人信息
     * 
     * @param ids 需要删除的供应商联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierContactInformationByIds(Long[] ids)
    {
        return srmSupplierContactInformationMapper.deleteSrmSupplierContactInformationByIds(ids);
    }

    /**
     * 删除供应商联系人信息信息
     * 
     * @param id 供应商联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierContactInformationById(Long id)
    {
        return srmSupplierContactInformationMapper.deleteSrmSupplierContactInformationById(id);
    }
}
