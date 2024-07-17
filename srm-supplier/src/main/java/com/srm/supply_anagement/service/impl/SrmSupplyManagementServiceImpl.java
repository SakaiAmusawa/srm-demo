package com.srm.supply_anagement.service.impl;

import com.srm.common.utils.StringUtils;
import com.srm.supply_anagement.domain.SrmMaterialInformation;
import com.srm.supply_anagement.domain.SrmSupplyManagement;
import com.srm.supply_anagement.mapper.SrmSupplyManagementMapper;
import com.srm.supply_anagement.service.ISrmSupplyManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 供货管理Service业务层处理
 *
 * @author sakai
 * @date 2024-07-17
 */
@Service
public class SrmSupplyManagementServiceImpl implements ISrmSupplyManagementService {
    @Autowired
    private SrmSupplyManagementMapper srmSupplyManagementMapper;

    /**
     * 查询供货管理
     *
     * @param id 供货管理主键
     * @return 供货管理
     */
    @Override
    public SrmSupplyManagement selectSrmSupplyManagementById(Long id) {
        return srmSupplyManagementMapper.selectSrmSupplyManagementById(id);
    }

    /**
     * 查询供货管理列表
     *
     * @param srmSupplyManagement 供货管理
     * @return 供货管理
     */
    @Override
    public List<SrmSupplyManagement> selectSrmSupplyManagementList(SrmSupplyManagement srmSupplyManagement) {
        return srmSupplyManagementMapper.selectSrmSupplyManagementList(srmSupplyManagement);
    }

    /**
     * 新增供货管理
     *
     * @param srmSupplyManagement 供货管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplyManagement(SrmSupplyManagement srmSupplyManagement) {
        int rows = srmSupplyManagementMapper.insertSrmSupplyManagement(srmSupplyManagement);
        insertSrmMaterialInformation(srmSupplyManagement);
        return rows;
    }

    /**
     * 修改供货管理
     *
     * @param srmSupplyManagement 供货管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplyManagement(SrmSupplyManagement srmSupplyManagement) {
        srmSupplyManagementMapper.deleteSrmMaterialInformationByMaterialCode(srmSupplyManagement.getId());
        insertSrmMaterialInformation(srmSupplyManagement);
        return srmSupplyManagementMapper.updateSrmSupplyManagement(srmSupplyManagement);
    }

    /**
     * 批量删除供货管理
     *
     * @param ids 需要删除的供货管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplyManagementByIds(Long[] ids) {
        srmSupplyManagementMapper.deleteSrmMaterialInformationByMaterialCodes(ids);
        return srmSupplyManagementMapper.deleteSrmSupplyManagementByIds(ids);
    }

    /**
     * 删除供货管理信息
     *
     * @param id 供货管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplyManagementById(Long id) {
        srmSupplyManagementMapper.deleteSrmMaterialInformationByMaterialCode(id);
        return srmSupplyManagementMapper.deleteSrmSupplyManagementById(id);
    }

    /**
     * 新增物料信息信息
     *
     * @param srmSupplyManagement 供货管理对象
     */
    public void insertSrmMaterialInformation(SrmSupplyManagement srmSupplyManagement) {
        List<SrmMaterialInformation> srmMaterialInformationList = srmSupplyManagement.getSrmMaterialInformationList();
        Long id = srmSupplyManagement.getId();
        if (StringUtils.isNotNull(srmMaterialInformationList)) {
            List<SrmMaterialInformation> list = new ArrayList<SrmMaterialInformation>();
            for (SrmMaterialInformation srmMaterialInformation : srmMaterialInformationList) {
                srmMaterialInformation.setSupplyId(id);
                list.add(srmMaterialInformation);
            }
            if (list.size() > 0) {
                srmSupplyManagementMapper.batchSrmMaterialInformation(list);
            }
        }
    }
}
