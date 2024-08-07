package com.srm.procurement.requirement.service.impl;

import java.util.List;
import com.srm.common.utils.DateUtils;
import com.srm.procurement.requirement.domain.SrmProcurementRequirement;
import com.srm.procurement.requirement.domain.SrmProcurementRequirementMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.srm.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.srm.procurement.requirement.mapper.SrmProcurementRequirementMapper;
import com.srm.procurement.requirement.service.ISrmProcurementRequirementService;

/**
 * 采购需求Service业务层处理
 * 
 * @author Sakai
 * @date 2024-08-07
 */
@Service
public class SrmProcurementRequirementServiceImpl implements ISrmProcurementRequirementService 
{
    @Autowired
    private SrmProcurementRequirementMapper srmProcurementRequirementMapper;

    /**
     * 查询采购需求
     * 
     * @param id 采购需求主键
     * @return 采购需求
     */
    @Override
    public SrmProcurementRequirement selectSrmProcurementRequirementById(Long id)
    {
        return srmProcurementRequirementMapper.selectSrmProcurementRequirementById(id);
    }

    /**
     * 查询采购需求列表
     * 
     * @param srmProcurementRequirement 采购需求
     * @return 采购需求
     */
    @Override
    public List<SrmProcurementRequirement> selectSrmProcurementRequirementList(SrmProcurementRequirement srmProcurementRequirement)
    {
        return srmProcurementRequirementMapper.selectSrmProcurementRequirementList(srmProcurementRequirement);
    }

    /**
     * 新增采购需求
     * 
     * @param srmProcurementRequirement 采购需求
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmProcurementRequirement(SrmProcurementRequirement srmProcurementRequirement)
    {
        srmProcurementRequirement.setCreateTime(DateUtils.getNowDate());
        int rows = srmProcurementRequirementMapper.insertSrmProcurementRequirement(srmProcurementRequirement);
        insertSrmProcurementRequirementMaterial(srmProcurementRequirement);
        return rows;
    }

    /**
     * 修改采购需求
     * 
     * @param srmProcurementRequirement 采购需求
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmProcurementRequirement(SrmProcurementRequirement srmProcurementRequirement)
    {
        srmProcurementRequirementMapper.deleteSrmProcurementRequirementMaterialByProcurementRequirementId(srmProcurementRequirement.getId());
        insertSrmProcurementRequirementMaterial(srmProcurementRequirement);
        return srmProcurementRequirementMapper.updateSrmProcurementRequirement(srmProcurementRequirement);
    }

    /**
     * 批量删除采购需求
     * 
     * @param ids 需要删除的采购需求主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmProcurementRequirementByIds(Long[] ids)
    {
        srmProcurementRequirementMapper.deleteSrmProcurementRequirementMaterialByProcurementRequirementIds(ids);
        return srmProcurementRequirementMapper.deleteSrmProcurementRequirementByIds(ids);
    }

    /**
     * 删除采购需求信息
     * 
     * @param id 采购需求主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmProcurementRequirementById(Long id)
    {
        srmProcurementRequirementMapper.deleteSrmProcurementRequirementMaterialByProcurementRequirementId(id);
        return srmProcurementRequirementMapper.deleteSrmProcurementRequirementById(id);
    }

    /**
     * 新增采购需求物料信息
     * 
     * @param srmProcurementRequirement 采购需求对象
     */
    public void insertSrmProcurementRequirementMaterial(SrmProcurementRequirement srmProcurementRequirement)
    {
        List<SrmProcurementRequirementMaterial> srmProcurementRequirementMaterialList = srmProcurementRequirement.getSrmProcurementRequirementMaterialList();
        Long id = srmProcurementRequirement.getId();
        if (StringUtils.isNotNull(srmProcurementRequirementMaterialList))
        {
            List<SrmProcurementRequirementMaterial> list = new ArrayList<SrmProcurementRequirementMaterial>();
            for (SrmProcurementRequirementMaterial srmProcurementRequirementMaterial : srmProcurementRequirementMaterialList)
            {
                srmProcurementRequirementMaterial.setProcurementRequirementId(id);
                list.add(srmProcurementRequirementMaterial);
            }
            if (list.size() > 0)
            {
                srmProcurementRequirementMapper.batchSrmProcurementRequirementMaterial(list);
            }
        }
    }
}
