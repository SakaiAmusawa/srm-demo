package com.srm.supplier.service;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.domain.param.ChangeRegStatus;

/**
 * 供应商信息Service接口
 * 
 * @author sakai
 * @date 2024-07-01
 */
public interface ISrmSupplierInformationService 
{
    /**
     * 查询供应商信息
     * 
     * @param id 供应商信息主键
     * @return 供应商信息
     */
    public SrmSupplierInformation selectSrmSupplierInformationById(Long id);

    /**
     * 查询供应商信息列表
     * 
     * @param srmSupplierInformation 供应商信息
     * @return 供应商信息集合
     */
    public List<SrmSupplierInformation> selectSrmSupplierInformationList(SrmSupplierInformation srmSupplierInformation);

    /**
     * 新增供应商信息
     * 
     * @param srmSupplierInformation 供应商信息
     * @return 结果
     */
    public int insertSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation);

    /**
     * 修改供应商信息
     * 
     * @param srmSupplierInformation 供应商信息
     * @return 结果
     */
    public int updateSrmSupplierInformation(SrmSupplierInformation srmSupplierInformation);

    /**
     * 批量删除供应商信息
     * 
     * @param ids 需要删除的供应商信息主键集合
     * @return 结果
     */
    public int deleteSrmSupplierInformationByIds(Long[] ids);

    /**
     * 删除供应商信息信息
     * 
     * @param id 供应商信息主键
     * @return 结果
     */
    public int deleteSrmSupplierInformationById(Long id);

    void changeRegStatusById(ChangeRegStatus changeRegStatus);
}
