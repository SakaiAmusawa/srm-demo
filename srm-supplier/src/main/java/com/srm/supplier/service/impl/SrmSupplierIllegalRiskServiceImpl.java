package com.srm.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.supplier.mapper.SrmSupplierIllegalRiskMapper;
import com.srm.supplier.domain.SrmSupplierIllegalRisk;
import com.srm.supplier.service.ISrmSupplierIllegalRiskService;

/**
 * 供应商非法风险记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
@Service
public class SrmSupplierIllegalRiskServiceImpl implements ISrmSupplierIllegalRiskService 
{
    @Autowired
    private SrmSupplierIllegalRiskMapper srmSupplierIllegalRiskMapper;

    /**
     * 查询供应商非法风险记录
     * 
     * @param id 供应商非法风险记录主键
     * @return 供应商非法风险记录
     */
    @Override
    public SrmSupplierIllegalRisk selectSrmSupplierIllegalRiskById(Long id)
    {
        return srmSupplierIllegalRiskMapper.selectSrmSupplierIllegalRiskById(id);
    }

    /**
     * 查询供应商非法风险记录列表
     * 
     * @param srmSupplierIllegalRisk 供应商非法风险记录
     * @return 供应商非法风险记录
     */
    @Override
    public List<SrmSupplierIllegalRisk> selectSrmSupplierIllegalRiskList(SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        return srmSupplierIllegalRiskMapper.selectSrmSupplierIllegalRiskList(srmSupplierIllegalRisk);
    }

    /**
     * 新增供应商非法风险记录
     * 
     * @param srmSupplierIllegalRisk 供应商非法风险记录
     * @return 结果
     */
    @Override
    public int insertSrmSupplierIllegalRisk(SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        return srmSupplierIllegalRiskMapper.insertSrmSupplierIllegalRisk(srmSupplierIllegalRisk);
    }

    /**
     * 修改供应商非法风险记录
     * 
     * @param srmSupplierIllegalRisk 供应商非法风险记录
     * @return 结果
     */
    @Override
    public int updateSrmSupplierIllegalRisk(SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        return srmSupplierIllegalRiskMapper.updateSrmSupplierIllegalRisk(srmSupplierIllegalRisk);
    }

    /**
     * 批量删除供应商非法风险记录
     * 
     * @param ids 需要删除的供应商非法风险记录主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierIllegalRiskByIds(Long[] ids)
    {
        return srmSupplierIllegalRiskMapper.deleteSrmSupplierIllegalRiskByIds(ids);
    }

    /**
     * 删除供应商非法风险记录信息
     * 
     * @param id 供应商非法风险记录主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierIllegalRiskById(Long id)
    {
        return srmSupplierIllegalRiskMapper.deleteSrmSupplierIllegalRiskById(id);
    }
}
