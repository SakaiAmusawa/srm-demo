package com.srm.unity.mapper;

import java.util.List;
import com.srm.unity.domain.SrmUnitTypeDefinition;

/**
 * 计量单位类型定义Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-17
 */
public interface SrmUnitTypeDefinitionMapper 
{
    /**
     * 查询计量单位类型定义
     * 
     * @param id 计量单位类型定义主键
     * @return 计量单位类型定义
     */
    public SrmUnitTypeDefinition selectSrmUnitTypeDefinitionById(Long id);

    /**
     * 查询计量单位类型定义列表
     * 
     * @param srmUnitTypeDefinition 计量单位类型定义
     * @return 计量单位类型定义集合
     */
    public List<SrmUnitTypeDefinition> selectSrmUnitTypeDefinitionList(SrmUnitTypeDefinition srmUnitTypeDefinition);

    /**
     * 新增计量单位类型定义
     * 
     * @param srmUnitTypeDefinition 计量单位类型定义
     * @return 结果
     */
    public int insertSrmUnitTypeDefinition(SrmUnitTypeDefinition srmUnitTypeDefinition);

    /**
     * 修改计量单位类型定义
     * 
     * @param srmUnitTypeDefinition 计量单位类型定义
     * @return 结果
     */
    public int updateSrmUnitTypeDefinition(SrmUnitTypeDefinition srmUnitTypeDefinition);

    /**
     * 删除计量单位类型定义
     * 
     * @param id 计量单位类型定义主键
     * @return 结果
     */
    public int deleteSrmUnitTypeDefinitionById(Long id);

    /**
     * 批量删除计量单位类型定义
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmUnitTypeDefinitionByIds(Long[] ids);
}
