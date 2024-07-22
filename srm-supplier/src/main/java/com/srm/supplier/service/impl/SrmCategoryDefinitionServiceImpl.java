package com.srm.supplier.service.impl;

import com.srm.common.utils.DateUtils;
import com.srm.supplier.domain.SrmCategoryDefinition;
import com.srm.supplier.mapper.SrmCategoryDefinitionMapper;
import com.srm.supplier.service.ISrmCategoryDefinitionService;
import com.srm.unity.domain.SrmUnitDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 品类定义Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-17
 */
@Service
public class SrmCategoryDefinitionServiceImpl implements ISrmCategoryDefinitionService {
    @Autowired
    private SrmCategoryDefinitionMapper srmCategoryDefinitionMapper;

    /**
     * 查询品类定义
     *
     * @param id 品类定义主键
     * @return 品类定义
     */
    @Override
    public SrmCategoryDefinition selectSrmCategoryDefinitionById(Long id) {
        return srmCategoryDefinitionMapper.selectSrmCategoryDefinitionById(id);
    }

    /**
     * 查询品类定义列表
     *
     * @param srmCategoryDefinition 品类定义
     * @return 品类定义
     */
    @Override
    public List<SrmCategoryDefinition> selectSrmCategoryDefinitionList(SrmCategoryDefinition srmCategoryDefinition) {
        return srmCategoryDefinitionMapper.selectSrmCategoryDefinitionList(srmCategoryDefinition);
    }

    /**
     * 新增品类定义
     *
     * @param srmCategoryDefinition 品类定义
     * @return 结果
     */
    @Override
    public int insertSrmCategoryDefinition(SrmCategoryDefinition srmCategoryDefinition) {
        srmCategoryDefinition.setCreateTime(DateUtils.getNowDate());
        return srmCategoryDefinitionMapper.insertSrmCategoryDefinition(srmCategoryDefinition);
    }

    /**
     * 修改品类定义
     *
     * @param srmCategoryDefinition 品类定义
     * @return 结果
     */
    @Override
    public int updateSrmCategoryDefinition(SrmCategoryDefinition srmCategoryDefinition) {
        srmCategoryDefinition.setUpdateTime(DateUtils.getNowDate());
        return srmCategoryDefinitionMapper.updateSrmCategoryDefinition(srmCategoryDefinition);
    }

    /**
     * 批量删除品类定义
     *
     * @param ids 需要删除的品类定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmCategoryDefinitionByIds(Long[] ids) {
        return srmCategoryDefinitionMapper.deleteSrmCategoryDefinitionByIds(ids);
    }

    /**
     * 删除品类定义信息
     *
     * @param id 品类定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmCategoryDefinitionById(Long id) {
        return srmCategoryDefinitionMapper.deleteSrmCategoryDefinitionById(id);
    }

    @Override
    public List<SrmUnitDef> selectUnitList() {
        return srmCategoryDefinitionMapper.selectUnitList();
    }

    @Override
    public List<SrmCategoryDefinition> getAllCategory() {
        return srmCategoryDefinitionMapper.selectSrmCategoryDefinitionList(null);
    }
}
