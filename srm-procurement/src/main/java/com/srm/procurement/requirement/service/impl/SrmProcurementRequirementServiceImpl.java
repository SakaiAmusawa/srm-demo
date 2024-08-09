package com.srm.procurement.requirement.service.impl;

import com.srm.common.core.domain.model.LoginUser;
import com.srm.common.utils.DateUtils;
import com.srm.common.utils.SecurityUtils;
import com.srm.common.utils.StringUtils;
import com.srm.common.utils.uuid.IdUtils;
import com.srm.data.domain.SrmDataCurrency;
import com.srm.data.mapper.SrmDataCurrencyMapper;
import com.srm.procurement.requirement.domain.SrmProcurementRequirement;
import com.srm.procurement.requirement.domain.SrmProcurementRequirementMaterial;
import com.srm.procurement.requirement.mapper.SrmProcurementRequirementMapper;
import com.srm.procurement.requirement.service.ISrmProcurementRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 采购需求Service业务层处理
 *
 * @author Sakai
 * @date 2024-08-07
 */
@Service
public class SrmProcurementRequirementServiceImpl implements ISrmProcurementRequirementService {
    @Autowired
    private SrmProcurementRequirementMapper srmProcurementRequirementMapper;
    @Autowired
    private SrmDataCurrencyMapper srmDataCurrencyMapper;

    /**
     * 查询采购需求
     *
     * @param id 采购需求主键
     * @return 采购需求
     */
    @Override
    public SrmProcurementRequirement selectSrmProcurementRequirementById(Long id) {
        SrmProcurementRequirement srmProcurementRequirement = srmProcurementRequirementMapper.selectSrmProcurementRequirementById(id);
        List<SrmProcurementRequirementMaterial> materialList = srmProcurementRequirementMapper.selectSrmProcurementRequirementMaterialByProcurementRequirementId(id);
        srmProcurementRequirement.setSrmProcurementRequirementMaterialList(materialList);
        return srmProcurementRequirement;
    }

    /**
     * 查询采购需求列表
     *
     * @param srmProcurementRequirement 采购需求
     * @return 采购需求
     */
    @Override
    public List<SrmProcurementRequirement> selectSrmProcurementRequirementList(SrmProcurementRequirement srmProcurementRequirement) {
        List<SrmProcurementRequirement> srmProcurementRequirements = srmProcurementRequirementMapper.selectSrmProcurementRequirementList(srmProcurementRequirement);
        for (SrmProcurementRequirement procurementRequirement : srmProcurementRequirements) {
            Long currencyId = procurementRequirement.getCurrency();
            SrmDataCurrency srmDataCurrency = srmDataCurrencyMapper.selectSrmDataCurrencyById(currencyId);
            procurementRequirement.setCurrencyName(srmDataCurrency.getCurrencyName());
        }
        return srmProcurementRequirements;
    }

    /**
     * 新增采购需求
     *
     * @param srmProcurementRequirement 采购需求
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmProcurementRequirement(SrmProcurementRequirement srmProcurementRequirement) {
        //设置创建时间
        srmProcurementRequirement.setCreateTime(DateUtils.getNowDate());
        //设置需求编号
        String serial = IdUtils.randomUUID();
        srmProcurementRequirement.setRequirementSerial(serial);

        LoginUser loginUser = SecurityUtils.getLoginUser();
        //设置需求创建人
        String requirementCreator = loginUser.getUser().getUserName();
        srmProcurementRequirement.setRequirementCreator(requirementCreator);
        //设置创建人部门
        String deptName = loginUser.getUser().getDept().getDeptName();
        srmProcurementRequirement.setRequirementDepartment(deptName);

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
    public int updateSrmProcurementRequirement(SrmProcurementRequirement srmProcurementRequirement) {
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
    public int deleteSrmProcurementRequirementByIds(Long[] ids) {
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
    public int deleteSrmProcurementRequirementById(Long id) {
        srmProcurementRequirementMapper.deleteSrmProcurementRequirementMaterialByProcurementRequirementId(id);
        return srmProcurementRequirementMapper.deleteSrmProcurementRequirementById(id);
    }

    /**
     * 新增采购需求物料信息
     *
     * @param srmProcurementRequirement 采购需求对象
     */
    public void insertSrmProcurementRequirementMaterial(SrmProcurementRequirement srmProcurementRequirement) {
        List<SrmProcurementRequirementMaterial> srmProcurementRequirementMaterialList = srmProcurementRequirement.getSrmProcurementRequirementMaterialList();
        Long id = srmProcurementRequirement.getId();
        if (StringUtils.isNotNull(srmProcurementRequirementMaterialList)) {
            List<SrmProcurementRequirementMaterial> list = new ArrayList<SrmProcurementRequirementMaterial>();
            for (SrmProcurementRequirementMaterial srmProcurementRequirementMaterial : srmProcurementRequirementMaterialList) {
                srmProcurementRequirementMaterial.setProcurementRequirementId(id);
                list.add(srmProcurementRequirementMaterial);
            }
            if (list.size() > 0) {
                srmProcurementRequirementMapper.batchSrmProcurementRequirementMaterial(list);
            }
        }
    }
}
