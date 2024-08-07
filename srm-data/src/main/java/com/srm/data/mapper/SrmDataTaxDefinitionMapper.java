package com.srm.data.mapper;

import java.util.List;
import com.srm.data.domain.SrmDataTaxDefinition;

/**
 * 税率定义Mapper接口
 * 
 * @author sakai
 * @date 2024-08-07
 */
public interface SrmDataTaxDefinitionMapper 
{
    /**
     * 查询税率定义
     * 
     * @param id 税率定义主键
     * @return 税率定义
     */
    public SrmDataTaxDefinition selectSrmDataTaxDefinitionById(Long id);

    /**
     * 查询税率定义列表
     * 
     * @param srmDataTaxDefinition 税率定义
     * @return 税率定义集合
     */
    public List<SrmDataTaxDefinition> selectSrmDataTaxDefinitionList(SrmDataTaxDefinition srmDataTaxDefinition);

    /**
     * 新增税率定义
     * 
     * @param srmDataTaxDefinition 税率定义
     * @return 结果
     */
    public int insertSrmDataTaxDefinition(SrmDataTaxDefinition srmDataTaxDefinition);

    /**
     * 修改税率定义
     * 
     * @param srmDataTaxDefinition 税率定义
     * @return 结果
     */
    public int updateSrmDataTaxDefinition(SrmDataTaxDefinition srmDataTaxDefinition);

    /**
     * 删除税率定义
     * 
     * @param id 税率定义主键
     * @return 结果
     */
    public int deleteSrmDataTaxDefinitionById(Long id);

    /**
     * 批量删除税率定义
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmDataTaxDefinitionByIds(Long[] ids);
}
