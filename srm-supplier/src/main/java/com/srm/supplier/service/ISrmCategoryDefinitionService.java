package com.srm.supplier.service;

import com.srm.supplier.domain.SrmCategoryDefinition;
import com.srm.unity.domain.SrmUnitDef;

import java.util.List;

/**
 * 品类定义Service接口
 *
 * @author ruoyi
 * @date 2024-07-17
 */
public interface ISrmCategoryDefinitionService {
    /**
     * 查询品类定义
     *
     * @param id 品类定义主键
     * @return 品类定义
     */
    public SrmCategoryDefinition selectSrmCategoryDefinitionById(Long id);

    /**
     * 查询品类定义列表
     *
     * @param srmCategoryDefinition 品类定义
     * @return 品类定义集合
     */
    public List<SrmCategoryDefinition> selectSrmCategoryDefinitionList(SrmCategoryDefinition srmCategoryDefinition);

    /**
     * 新增品类定义
     *
     * @param srmCategoryDefinition 品类定义
     * @return 结果
     */
    public int insertSrmCategoryDefinition(SrmCategoryDefinition srmCategoryDefinition);

    /**
     * 修改品类定义
     *
     * @param srmCategoryDefinition 品类定义
     * @return 结果
     */
    public int updateSrmCategoryDefinition(SrmCategoryDefinition srmCategoryDefinition);

    /**
     * 批量删除品类定义
     *
     * @param ids 需要删除的品类定义主键集合
     * @return 结果
     */
    public int deleteSrmCategoryDefinitionByIds(Long[] ids);

    /**
     * 删除品类定义信息
     *
     * @param id 品类定义主键
     * @return 结果
     */
    public int deleteSrmCategoryDefinitionById(Long id);

    List<SrmUnitDef> selectUnitList();

    List<SrmCategoryDefinition> getAllCategory();
}
