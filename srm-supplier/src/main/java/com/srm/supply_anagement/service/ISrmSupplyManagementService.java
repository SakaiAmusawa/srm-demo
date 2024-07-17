package com.srm.supply_anagement.service;

import java.util.List;
import com.srm.supply_anagement.domain.SrmSupplyManagement;

/**
 * 供货管理Service接口
 * 
 * @author sakai
 * @date 2024-07-17
 */
public interface ISrmSupplyManagementService 
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
     * 批量删除供货管理
     * 
     * @param ids 需要删除的供货管理主键集合
     * @return 结果
     */
    public int deleteSrmSupplyManagementByIds(Long[] ids);

    /**
     * 删除供货管理信息
     * 
     * @param id 供货管理主键
     * @return 结果
     */
    public int deleteSrmSupplyManagementById(Long id);
}
