package com.srm.system.mapper;

import java.util.List;
import com.srm.system.domain.SrmSupplierContactInformation;

/**
 * 供应商联系人信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-01
 */
public interface SrmSupplierContactInformationMapper 
{
    /**
     * 查询供应商联系人信息
     * 
     * @param id 供应商联系人信息主键
     * @return 供应商联系人信息
     */
    public SrmSupplierContactInformation selectSrmSupplierContactInformationById(Long id);

    /**
     * 查询供应商联系人信息列表
     * 
     * @param srmSupplierContactInformation 供应商联系人信息
     * @return 供应商联系人信息集合
     */
    public List<SrmSupplierContactInformation> selectSrmSupplierContactInformationList(SrmSupplierContactInformation srmSupplierContactInformation);

    /**
     * 新增供应商联系人信息
     * 
     * @param srmSupplierContactInformation 供应商联系人信息
     * @return 结果
     */
    public int insertSrmSupplierContactInformation(SrmSupplierContactInformation srmSupplierContactInformation);

    /**
     * 修改供应商联系人信息
     * 
     * @param srmSupplierContactInformation 供应商联系人信息
     * @return 结果
     */
    public int updateSrmSupplierContactInformation(SrmSupplierContactInformation srmSupplierContactInformation);

    /**
     * 删除供应商联系人信息
     * 
     * @param id 供应商联系人信息主键
     * @return 结果
     */
    public int deleteSrmSupplierContactInformationById(Long id);

    /**
     * 批量删除供应商联系人信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierContactInformationByIds(Long[] ids);
}
