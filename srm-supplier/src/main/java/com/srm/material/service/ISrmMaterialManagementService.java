package com.srm.material.service;

import com.srm.common.core.domain.entity.SysUser;
import com.srm.material.domain.SrmMaterialManagement;
import com.srm.supplier.domain.SrmCategoryDefinition;
import com.srm.unity.domain.SrmUnitDef;

import java.util.List;

/**
 * 物料管理Service接口
 *
 * @author ruoyi
 * @date 2024-07-18
 */
public interface ISrmMaterialManagementService {
    /**
     * 查询物料管理
     *
     * @param id 物料管理主键
     * @return 物料管理
     */
    public SrmMaterialManagement selectSrmMaterialManagementById(Long id);

    /**
     * 查询物料管理列表
     *
     * @param srmMaterialManagement 物料管理
     * @return 物料管理集合
     */
    public List<SrmMaterialManagement> selectSrmMaterialManagementList(SrmMaterialManagement srmMaterialManagement);

    /**
     * 新增物料管理
     *
     * @param srmMaterialManagement 物料管理
     * @return 结果
     */
    public int insertSrmMaterialManagement(SrmMaterialManagement srmMaterialManagement);

    /**
     * 修改物料管理
     *
     * @param srmMaterialManagement 物料管理
     * @return 结果
     */
    public int updateSrmMaterialManagement(SrmMaterialManagement srmMaterialManagement);

    /**
     * 批量删除物料管理
     *
     * @param ids 需要删除的物料管理主键集合
     * @return 结果
     */
    public int deleteSrmMaterialManagementByIds(Long[] ids);

    /**
     * 删除物料管理信息
     *
     * @param id 物料管理主键
     * @return 结果
     */
    public int deleteSrmMaterialManagementById(Long id);

    List<SrmCategoryDefinition> selectCategoryList();

    List<SrmUnitDef> selectUnitList();

    List<SrmMaterialManagement> getAllMaterial();

    List<SysUser> getAllUser();
}
