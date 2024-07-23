package com.srm.supplier.service.impl;

import java.util.List;
import com.srm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.supplier.mapper.SrmSupplierOperateRiskMapper;
import com.srm.supplier.domain.SrmSupplierOperateRisk;
import com.srm.supplier.service.ISrmSupplierOperateRiskService;

/**
 * 供应商经营风险记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
@Service
public class SrmSupplierOperateRiskServiceImpl implements ISrmSupplierOperateRiskService 
{
    @Autowired
    private SrmSupplierOperateRiskMapper srmSupplierOperateRiskMapper;

    /**
     * 查询供应商经营风险记录
     * 
     * @param id 供应商经营风险记录主键
     * @return 供应商经营风险记录
     */
    @Override
    public SrmSupplierOperateRisk selectSrmSupplierOperateRiskById(Long id)
    {
        return srmSupplierOperateRiskMapper.selectSrmSupplierOperateRiskById(id);
    }

    /**
     * 查询供应商经营风险记录列表
     * 
     * @param srmSupplierOperateRisk 供应商经营风险记录
     * @return 供应商经营风险记录
     */
    @Override
    public List<SrmSupplierOperateRisk> selectSrmSupplierOperateRiskList(SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        return srmSupplierOperateRiskMapper.selectSrmSupplierOperateRiskList(srmSupplierOperateRisk);
    }

    /**
     * 新增供应商经营风险记录
     * 
     * @param srmSupplierOperateRisk 供应商经营风险记录
     * @return 结果
     */
    @Override
    public int insertSrmSupplierOperateRisk(SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        srmSupplierOperateRisk.setCreateTime(DateUtils.getNowDate());
        return srmSupplierOperateRiskMapper.insertSrmSupplierOperateRisk(srmSupplierOperateRisk);
    }

    /**
     * 修改供应商经营风险记录
     * 
     * @param srmSupplierOperateRisk 供应商经营风险记录
     * @return 结果
     */
    @Override
    public int updateSrmSupplierOperateRisk(SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        return srmSupplierOperateRiskMapper.updateSrmSupplierOperateRisk(srmSupplierOperateRisk);
    }

    /**
     * 批量删除供应商经营风险记录
     * 
     * @param ids 需要删除的供应商经营风险记录主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierOperateRiskByIds(Long[] ids)
    {
        return srmSupplierOperateRiskMapper.deleteSrmSupplierOperateRiskByIds(ids);
    }

    /**
     * 删除供应商经营风险记录信息
     * 
     * @param id 供应商经营风险记录主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierOperateRiskById(Long id)
    {
        return srmSupplierOperateRiskMapper.deleteSrmSupplierOperateRiskById(id);
    }
}
