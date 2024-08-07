package com.srm.procurement.requirement.service;

import java.util.List;

import com.srm.procurement.requirement.domain.SrmProcurementRequirement;

/**
 * 采购需求Service接口
 * 
 * @author Sakai
 * @date 2024-08-07
 */
public interface ISrmProcurementRequirementService 
{
    /**
     * 查询采购需求
     * 
     * @param id 采购需求主键
     * @return 采购需求
     */
    public SrmProcurementRequirement selectSrmProcurementRequirementById(Long id);

    /**
     * 查询采购需求列表
     * 
     * @param srmProcurementRequirement 采购需求
     * @return 采购需求集合
     */
    public List<SrmProcurementRequirement> selectSrmProcurementRequirementList(SrmProcurementRequirement srmProcurementRequirement);

    /**
     * 新增采购需求
     * 
     * @param srmProcurementRequirement 采购需求
     * @return 结果
     */
    public int insertSrmProcurementRequirement(SrmProcurementRequirement srmProcurementRequirement);

    /**
     * 修改采购需求
     * 
     * @param srmProcurementRequirement 采购需求
     * @return 结果
     */
    public int updateSrmProcurementRequirement(SrmProcurementRequirement srmProcurementRequirement);

    /**
     * 批量删除采购需求
     * 
     * @param ids 需要删除的采购需求主键集合
     * @return 结果
     */
    public int deleteSrmProcurementRequirementByIds(Long[] ids);

    /**
     * 删除采购需求信息
     * 
     * @param id 采购需求主键
     * @return 结果
     */
    public int deleteSrmProcurementRequirementById(Long id);
}
