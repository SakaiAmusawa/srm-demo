package com.srm.material.mapper;

import java.util.List;

import com.srm.common.core.domain.entity.SysUser;
import com.srm.material.domain.SrmMaterialManagement;
import com.srm.supplier.domain.SrmCategoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * 物料管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-18
 */
@Repository
public interface SrmMaterialManagementMapper 
{
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
     * 删除物料管理
     * 
     * @param id 物料管理主键
     * @return 结果
     */
    public int deleteSrmMaterialManagementById(Long id);

    /**
     * 批量删除物料管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmMaterialManagementByIds(Long[] ids);

    List<SrmCategoryDefinition> selectCatrgoryList();

    List<SysUser> selectAllUser();
}
