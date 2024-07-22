package com.srm.material.service.impl;

import com.srm.common.core.domain.entity.SysUser;
import com.srm.common.utils.DateUtils;
import com.srm.material.domain.SrmMaterialManagement;
import com.srm.material.mapper.SrmMaterialManagementMapper;
import com.srm.material.service.ISrmMaterialManagementService;
import com.srm.supplier.domain.SrmCategoryDefinition;
import com.srm.system.mapper.SysUserMapper;
import com.srm.unity.domain.SrmUnitDef;
import com.srm.unity.mapper.SrmUnitDefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物料管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-18
 */
@Service
public class SrmMaterialManagementServiceImpl implements ISrmMaterialManagementService {
    @Autowired
    private SrmMaterialManagementMapper srmMaterialManagementMapper;
    @Autowired
    private SrmUnitDefMapper srmUnitDefMapper;
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 查询物料管理
     *
     * @param id 物料管理主键
     * @return 物料管理
     */
    @Override
    public SrmMaterialManagement selectSrmMaterialManagementById(Long id) {
        return srmMaterialManagementMapper.selectSrmMaterialManagementById(id);
    }

    /**
     * 查询物料管理列表
     *
     * @param srmMaterialManagement 物料管理
     * @return 物料管理
     */
    @Override
    public List<SrmMaterialManagement> selectSrmMaterialManagementList(SrmMaterialManagement srmMaterialManagement) {
        return srmMaterialManagementMapper.selectSrmMaterialManagementList(srmMaterialManagement);
    }

    /**
     * 新增物料管理
     *
     * @param srmMaterialManagement 物料管理
     * @return 结果
     */
    @Override
    public int insertSrmMaterialManagement(SrmMaterialManagement srmMaterialManagement) {
        return srmMaterialManagementMapper.insertSrmMaterialManagement(srmMaterialManagement);
    }

    /**
     * 修改物料管理
     *
     * @param srmMaterialManagement 物料管理
     * @return 结果
     */
    @Override
    public int updateSrmMaterialManagement(SrmMaterialManagement srmMaterialManagement) {
        srmMaterialManagement.setUpdateTime(DateUtils.getNowDate());
        return srmMaterialManagementMapper.updateSrmMaterialManagement(srmMaterialManagement);
    }

    /**
     * 批量删除物料管理
     *
     * @param ids 需要删除的物料管理主键
     * @return 结果
     */
    @Override
    public int deleteSrmMaterialManagementByIds(Long[] ids) {
        return srmMaterialManagementMapper.deleteSrmMaterialManagementByIds(ids);
    }

    /**
     * 删除物料管理信息
     *
     * @param id 物料管理主键
     * @return 结果
     */
    @Override
    public int deleteSrmMaterialManagementById(Long id) {
        return srmMaterialManagementMapper.deleteSrmMaterialManagementById(id);
    }

    @Override
    public List<SrmCategoryDefinition> selectCategoryList() {
        return srmMaterialManagementMapper.selectCatrgoryList();
    }

    @Override
    public List<SrmUnitDef> selectUnitList() {
        List<SrmUnitDef> srmUnitDefs = srmUnitDefMapper.selectSrmUnitDefList(null);
        return srmUnitDefs;
    }

    @Override
    public List<SrmMaterialManagement> getAllMaterial() {

        return srmMaterialManagementMapper.selectSrmMaterialManagementList(null);
    }

    @Override
    public List<SysUser> getAllUser() {
        return srmMaterialManagementMapper.selectAllUser();
    }
}
