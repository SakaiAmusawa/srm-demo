package com.srm.supply_anagement.mapper;

import java.util.List;
import com.srm.supply_anagement.domain.SrmSupplyManagement;
import com.srm.supply_anagement.domain.SrmMaterialInformation;

/**
 * 供货管理Mapper接口
 * 
 * @author sakai
 * @date 2024-07-17
 */
public interface SrmSupplyManagementMapper 
{
    /**
     * 查询供货管理
     * 
     * @param id 供货管理主键
     * @return 供货管理
     */
    public SrmSupplyManagement selectSrmSupplyManagementById(Long id);

    /**
     * 查询供货管理列表
     * 
     * @param srmSupplyManagement 供货管理
     * @return 供货管理集合
     */
    public List<SrmSupplyManagement> selectSrmSupplyManagementList(SrmSupplyManagement srmSupplyManagement);

    /**
     * 新增供货管理
     * 
     * @param srmSupplyManagement 供货管理
     * @return 结果
     */
    public int insertSrmSupplyManagement(SrmSupplyManagement srmSupplyManagement);

    /**
     * 修改供货管理
     * 
     * @param srmSupplyManagement 供货管理
     * @return 结果
     */
    public int updateSrmSupplyManagement(SrmSupplyManagement srmSupplyManagement);

    /**
     * 删除供货管理
     * 
     * @param id 供货管理主键
     * @return 结果
     */
    public int deleteSrmSupplyManagementById(Long id);

    /**
     * 批量删除供货管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplyManagementByIds(Long[] ids);

    /**
     * 批量删除物料信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmMaterialInformationByMaterialCodes(Long[] ids);
    
    /**
     * 批量新增物料信息
     * 
     * @param srmMaterialInformationList 物料信息列表
     * @return 结果
     */
    public int batchSrmMaterialInformation(List<SrmMaterialInformation> srmMaterialInformationList);
    

    /**
     * 通过供货管理主键删除物料信息信息
     * 
     * @param id 供货管理ID
     * @return 结果
     */
    public int deleteSrmMaterialInformationByMaterialCode(Long id);
}
