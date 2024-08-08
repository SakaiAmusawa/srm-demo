package com.srm.procurement.requirement.mapper;

import java.util.List;

import com.srm.procurement.requirement.domain.SrmProcurementRequirement;
import com.srm.procurement.requirement.domain.SrmProcurementRequirementMaterial;
import org.springframework.stereotype.Repository;

/**
 * 采购需求Mapper接口
 * 
 * @author Sakai
 * @date 2024-08-07
 */
@Repository
public interface SrmProcurementRequirementMapper 
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
     * 删除采购需求
     * 
     * @param id 采购需求主键
     * @return 结果
     */
    public int deleteSrmProcurementRequirementById(Long id);

    /**
     * 批量删除采购需求
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmProcurementRequirementByIds(Long[] ids);

    /**
     * 批量删除采购需求物料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmProcurementRequirementMaterialByProcurementRequirementIds(Long[] ids);
    
    /**
     * 批量新增采购需求物料
     * 
     * @param srmProcurementRequirementMaterialList 采购需求物料列表
     * @return 结果
     */
    public int batchSrmProcurementRequirementMaterial(List<SrmProcurementRequirementMaterial> srmProcurementRequirementMaterialList);
    

    /**
     * 通过采购需求主键删除采购需求物料信息
     * 
     * @param id 采购需求ID
     * @return 结果
     */
    public int deleteSrmProcurementRequirementMaterialByProcurementRequirementId(Long id);

    List<SrmProcurementRequirementMaterial> selectSrmProcurementRequirementMaterialByProcurementRequirementId(Long id);
}
