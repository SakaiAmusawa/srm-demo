package com.srm.unity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.unity.mapper.SrmUnitTypeDefinitionMapper;
import com.srm.unity.domain.SrmUnitTypeDefinition;
import com.srm.unity.service.ISrmUnitTypeDefinitionService;

/**
 * 计量单位类型定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-17
 */
@Service
public class SrmUnitTypeDefinitionServiceImpl implements ISrmUnitTypeDefinitionService 
{
    @Autowired
    private SrmUnitTypeDefinitionMapper srmUnitTypeDefinitionMapper;

    /**
     * 查询计量单位类型定义
     * 
     * @param id 计量单位类型定义主键
     * @return 计量单位类型定义
     */
    @Override
    public SrmUnitTypeDefinition selectSrmUnitTypeDefinitionById(Long id)
    {
        return srmUnitTypeDefinitionMapper.selectSrmUnitTypeDefinitionById(id);
    }

    /**
     * 查询计量单位类型定义列表
     * 
     * @param srmUnitTypeDefinition 计量单位类型定义
     * @return 计量单位类型定义
     */
    @Override
    public List<SrmUnitTypeDefinition> selectSrmUnitTypeDefinitionList(SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        return srmUnitTypeDefinitionMapper.selectSrmUnitTypeDefinitionList(srmUnitTypeDefinition);
    }

    /**
     * 新增计量单位类型定义
     * 
     * @param srmUnitTypeDefinition 计量单位类型定义
     * @return 结果
     */
    @Override
    public int insertSrmUnitTypeDefinition(SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        return srmUnitTypeDefinitionMapper.insertSrmUnitTypeDefinition(srmUnitTypeDefinition);
    }

    /**
     * 修改计量单位类型定义
     * 
     * @param srmUnitTypeDefinition 计量单位类型定义
     * @return 结果
     */
    @Override
    public int updateSrmUnitTypeDefinition(SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        return srmUnitTypeDefinitionMapper.updateSrmUnitTypeDefinition(srmUnitTypeDefinition);
    }

    /**
     * 批量删除计量单位类型定义
     * 
     * @param ids 需要删除的计量单位类型定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmUnitTypeDefinitionByIds(Long[] ids)
    {
        return srmUnitTypeDefinitionMapper.deleteSrmUnitTypeDefinitionByIds(ids);
    }

    /**
     * 删除计量单位类型定义信息
     * 
     * @param id 计量单位类型定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmUnitTypeDefinitionById(Long id)
    {
        return srmUnitTypeDefinitionMapper.deleteSrmUnitTypeDefinitionById(id);
    }
}
