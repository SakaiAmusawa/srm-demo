package com.srm.supplier.mapper;

import com.srm.supplier.domain.*;
import com.srm.supplier.domain.param.ChangeRegStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供应商信息Mapper接口
 *
 * @author sakai
 * @date 2024-07-01
 */
@Repository
public interface SrmSupplierInformationMapper {
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
     * 删除供应商信息
     *
     * @param id 供应商信息主键
     * @return 结果
     */
    public int deleteSrmSupplierInformationById(Long id);

    /**
     * 批量删除供应商信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierInformationByIds(Long[] ids);

    /**
     * 批量删除供应商联系人信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierContactInformationBySupplierIds(Long[] ids);

    /**
     * 批量新增供应商联系人信息
     *
     * @param srmSupplierContactInformationList 供应商联系人信息列表
     * @return 结果
     */
    public int batchSrmSupplierContactInformation(List<SrmSupplierContactInformation> srmSupplierContactInformationList);


    /**
     * 通过供应商信息主键删除供应商联系人信息信息
     *
     * @param id 供应商信息ID
     * @return 结果
     */
    public int deleteSrmSupplierContactInformationBySupplierId(Long id);

    /**
     * 批量删除供应商地址信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierAddressInformationBySupplierIds(Long[] ids);

    /**
     * 批量新增供应商地址信息
     *
     * @param srmSupplierAddressInformationList 供应商地址信息列表
     * @return 结果
     */
    public int batchSrmSupplierAddressInformation(List<SrmSupplierAddressInformation> srmSupplierAddressInformationList);


    /**
     * 通过供应商信息主键删除供应商地址信息信息
     *
     * @param id 供应商信息ID
     * @return 结果
     */
    public int deleteSrmSupplierAddressInformationBySupplierId(Long id);


    public int batchSrmSupplierBankInformation(List<SrmSupplierBankInformation> srmSupplierBankInformationList);


    /**
     * 批量删除供应商开票信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierInvoiceInformationBySupplierIds(Long[] ids);

    /**
     * 批量新增供应商开票信息
     *
     * @param srmSupplierInvoiceInformationList 供应商开票信息列表
     * @return 结果
     */
    public int batchSrmSupplierInvoiceInformation(List<SrmSupplierInvoiceInformation> srmSupplierInvoiceInformationList);


    /**
     * 通过供应商信息主键删除供应商开票信息信息
     *
     * @param id 供应商信息ID
     * @return 结果
     */
    public int deleteSrmSupplierInvoiceInformationBySupplierId(Long id);

    /**
     * 批量删除供应商证照信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierLicenseInformationBySupplierIds(Long[] ids);

    /**
     * 批量新增供应商证照信息
     *
     * @param srmSupplierLicenseInformationList 供应商证照信息列表
     * @return 结果
     */
    public int batchSrmSupplierLicenseInformation(List<SrmSupplierLicenseInformation> srmSupplierLicenseInformationList);


    /**
     * 通过供应商信息主键删除供应商证照信息信息
     *
     * @param id 供应商信息ID
     * @return 结果
     */
    public int deleteSrmSupplierLicenseInformationBySupplierId(Long id);

    SrmSupplierInformation selectSrmSupplierInformationByName(String supplierName);

    void updateRegStatusById(ChangeRegStatus changeRegStatus);

    List<SrmSupplierInformation> selectSrmSupplier();

    void updateRegStatusBySupplierId(Long supplierId);

    List<SrmSupplierInformation> selectActiveSupplier(SrmSupplierInformation srmSupplierInformation);

    List<SrmSupplierInformation> selectActiveSupplierInfo();
}
