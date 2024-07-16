package com.srm.inspect.mapper;

import java.util.List;
import com.srm.inspect.domain.SrmSupplierSiteVisit;
import com.srm.inspect.domain.SrmSupplierSiteVisitMaterial;

/**
 * 供应商现场考察Mapper接口
 * 
 * @author sakai
 * @date 2024-07-16
 */
public interface SrmSupplierSiteVisitMapper 
{
    /**
     * 查询供应商现场考察
     * 
     * @param id 供应商现场考察主键
     * @return 供应商现场考察
     */
    public SrmSupplierSiteVisit selectSrmSupplierSiteVisitById(Long id);

    /**
     * 查询供应商现场考察列表
     * 
     * @param srmSupplierSiteVisit 供应商现场考察
     * @return 供应商现场考察集合
     */
    public List<SrmSupplierSiteVisit> selectSrmSupplierSiteVisitList(SrmSupplierSiteVisit srmSupplierSiteVisit);

    /**
     * 新增供应商现场考察
     * 
     * @param srmSupplierSiteVisit 供应商现场考察
     * @return 结果
     */
    public int insertSrmSupplierSiteVisit(SrmSupplierSiteVisit srmSupplierSiteVisit);

    /**
     * 修改供应商现场考察
     * 
     * @param srmSupplierSiteVisit 供应商现场考察
     * @return 结果
     */
    public int updateSrmSupplierSiteVisit(SrmSupplierSiteVisit srmSupplierSiteVisit);

    /**
     * 删除供应商现场考察
     * 
     * @param id 供应商现场考察主键
     * @return 结果
     */
    public int deleteSrmSupplierSiteVisitById(Long id);

    /**
     * 批量删除供应商现场考察
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSiteVisitByIds(Long[] ids);

    /**
     * 批量删除供应商现场考察物料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSiteVisitMaterialByInvestigateIds(Long[] ids);
    
    /**
     * 批量新增供应商现场考察物料
     * 
     * @param srmSupplierSiteVisitMaterialList 供应商现场考察物料列表
     * @return 结果
     */
    public int batchSrmSupplierSiteVisitMaterial(List<SrmSupplierSiteVisitMaterial> srmSupplierSiteVisitMaterialList);
    

    /**
     * 通过供应商现场考察主键删除供应商现场考察物料信息
     * 
     * @param id 供应商现场考察ID
     * @return 结果
     */
    public int deleteSrmSupplierSiteVisitMaterialByInvestigateId(Long id);
}
