package com.srm.inspect.service;

import com.srm.inspect.domain.SrmSupplierSiteVisit;
import com.srm.supplier.domain.SrmSupplierInformation;

import java.util.List;

/**
 * 供应商现场考察Service接口
 *
 * @author sakai
 * @date 2024-07-16
 */
public interface ISrmSupplierSiteVisitService {
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
     * 批量删除供应商现场考察
     *
     * @param ids 需要删除的供应商现场考察主键集合
     * @return 结果
     */
    public int deleteSrmSupplierSiteVisitByIds(Long[] ids);

    /**
     * 删除供应商现场考察信息
     *
     * @param id 供应商现场考察主键
     * @return 结果
     */
    public int deleteSrmSupplierSiteVisitById(Long id);

    List<SrmSupplierInformation> selectSrmSupplierInfoList();
}
