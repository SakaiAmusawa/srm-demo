package com.srm.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.data.mapper.SrmDataTaxDefinitionMapper;
import com.srm.data.domain.SrmDataTaxDefinition;
import com.srm.data.service.ISrmDataTaxDefinitionService;

/**
 * 税率定义Service业务层处理
 * 
 * @author sakai
 * @date 2024-08-07
 */
@Service
public class SrmDataTaxDefinitionServiceImpl implements ISrmDataTaxDefinitionService 
{
    @Autowired
    private SrmDataTaxDefinitionMapper srmDataTaxDefinitionMapper;

    /**
     * 查询税率定义
     * 
     * @param id 税率定义主键
     * @return 税率定义
     */
    @Override
    public SrmDataTaxDefinition selectSrmDataTaxDefinitionById(Long id)
    {
        return srmDataTaxDefinitionMapper.selectSrmDataTaxDefinitionById(id);
    }

    /**
     * 查询税率定义列表
     * 
     * @param srmDataTaxDefinition 税率定义
     * @return 税率定义
     */
    @Override
    public List<SrmDataTaxDefinition> selectSrmDataTaxDefinitionList(SrmDataTaxDefinition srmDataTaxDefinition)
    {
        return srmDataTaxDefinitionMapper.selectSrmDataTaxDefinitionList(srmDataTaxDefinition);
    }

    /**
     * 新增税率定义
     * 
     * @param srmDataTaxDefinition 税率定义
     * @return 结果
     */
    @Override
    public int insertSrmDataTaxDefinition(SrmDataTaxDefinition srmDataTaxDefinition)
    {
        return srmDataTaxDefinitionMapper.insertSrmDataTaxDefinition(srmDataTaxDefinition);
    }

    /**
     * 修改税率定义
     * 
     * @param srmDataTaxDefinition 税率定义
     * @return 结果
     */
    @Override
    public int updateSrmDataTaxDefinition(SrmDataTaxDefinition srmDataTaxDefinition)
    {
        return srmDataTaxDefinitionMapper.updateSrmDataTaxDefinition(srmDataTaxDefinition);
    }

    /**
     * 批量删除税率定义
     * 
     * @param ids 需要删除的税率定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmDataTaxDefinitionByIds(Long[] ids)
    {
        return srmDataTaxDefinitionMapper.deleteSrmDataTaxDefinitionByIds(ids);
    }

    /**
     * 删除税率定义信息
     * 
     * @param id 税率定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmDataTaxDefinitionById(Long id)
    {
        return srmDataTaxDefinitionMapper.deleteSrmDataTaxDefinitionById(id);
    }
}
