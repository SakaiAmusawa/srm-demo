package com.srm.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.supplier.mapper.SrmSupplierAssessLevelMapper;
import com.srm.supplier.domain.SrmSupplierAssessLevel;
import com.srm.supplier.service.ISrmSupplierAssessLevelService;

/**
 * 供应商评级定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
@Service
public class SrmSupplierAssessLevelServiceImpl implements ISrmSupplierAssessLevelService 
{
    @Autowired
    private SrmSupplierAssessLevelMapper srmSupplierAssessLevelMapper;

    /**
     * 查询供应商评级定义
     * 
     * @param id 供应商评级定义主键
     * @return 供应商评级定义
     */
    @Override
    public SrmSupplierAssessLevel selectSrmSupplierAssessLevelById(Long id)
    {
        return srmSupplierAssessLevelMapper.selectSrmSupplierAssessLevelById(id);
    }

    /**
     * 查询供应商评级定义列表
     * 
     * @param srmSupplierAssessLevel 供应商评级定义
     * @return 供应商评级定义
     */
    @Override
    public List<SrmSupplierAssessLevel> selectSrmSupplierAssessLevelList(SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        return srmSupplierAssessLevelMapper.selectSrmSupplierAssessLevelList(srmSupplierAssessLevel);
    }

    /**
     * 新增供应商评级定义
     * 
     * @param srmSupplierAssessLevel 供应商评级定义
     * @return 结果
     */
    @Override
    public int insertSrmSupplierAssessLevel(SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        return srmSupplierAssessLevelMapper.insertSrmSupplierAssessLevel(srmSupplierAssessLevel);
    }

    /**
     * 修改供应商评级定义
     * 
     * @param srmSupplierAssessLevel 供应商评级定义
     * @return 结果
     */
    @Override
    public int updateSrmSupplierAssessLevel(SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        return srmSupplierAssessLevelMapper.updateSrmSupplierAssessLevel(srmSupplierAssessLevel);
    }

    /**
     * 批量删除供应商评级定义
     * 
     * @param ids 需要删除的供应商评级定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierAssessLevelByIds(Long[] ids)
    {
        return srmSupplierAssessLevelMapper.deleteSrmSupplierAssessLevelByIds(ids);
    }

    /**
     * 删除供应商评级定义信息
     * 
     * @param id 供应商评级定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierAssessLevelById(Long id)
    {
        return srmSupplierAssessLevelMapper.deleteSrmSupplierAssessLevelById(id);
    }
}
