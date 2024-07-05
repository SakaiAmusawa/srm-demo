package com.srm.supplier.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.supplier.mapper.SrmSupplierClassDefinitionMapper;
import com.srm.supplier.domain.SrmSupplierClassDefinition;
import com.srm.supplier.service.ISrmSupplierClassDefinitionService;

/**
 * 供应商分类定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-05
 */
@Service
public class SrmSupplierClassDefinitionServiceImpl implements ISrmSupplierClassDefinitionService 
{
    @Autowired
    private SrmSupplierClassDefinitionMapper srmSupplierClassDefinitionMapper;

    /**
     * 查询供应商分类定义
     * 
     * @param id 供应商分类定义主键
     * @return 供应商分类定义
     */
    @Override
    public SrmSupplierClassDefinition selectSrmSupplierClassDefinitionById(Long id)
    {
        return srmSupplierClassDefinitionMapper.selectSrmSupplierClassDefinitionById(id);
    }

    /**
     * 查询供应商分类定义列表
     * 
     * @param srmSupplierClassDefinition 供应商分类定义
     * @return 供应商分类定义
     */
    @Override
    public List<SrmSupplierClassDefinition> selectSrmSupplierClassDefinitionList(SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        return srmSupplierClassDefinitionMapper.selectSrmSupplierClassDefinitionList(srmSupplierClassDefinition);
    }

    /**
     * 新增供应商分类定义
     * 
     * @param srmSupplierClassDefinition 供应商分类定义
     * @return 结果
     */
    @Override
    public int insertSrmSupplierClassDefinition(SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        return srmSupplierClassDefinitionMapper.insertSrmSupplierClassDefinition(srmSupplierClassDefinition);
    }

    /**
     * 修改供应商分类定义
     * 
     * @param srmSupplierClassDefinition 供应商分类定义
     * @return 结果
     */
    @Override
    public int updateSrmSupplierClassDefinition(SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        return srmSupplierClassDefinitionMapper.updateSrmSupplierClassDefinition(srmSupplierClassDefinition);
    }

    /**
     * 批量删除供应商分类定义
     * 
     * @param ids 需要删除的供应商分类定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierClassDefinitionByIds(Long[] ids)
    {
        return srmSupplierClassDefinitionMapper.deleteSrmSupplierClassDefinitionByIds(ids);
    }

    /**
     * 删除供应商分类定义信息
     * 
     * @param id 供应商分类定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierClassDefinitionById(Long id)
    {
        return srmSupplierClassDefinitionMapper.deleteSrmSupplierClassDefinitionById(id);
    }
}
