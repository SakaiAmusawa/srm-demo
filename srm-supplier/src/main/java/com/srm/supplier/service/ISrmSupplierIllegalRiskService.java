package com.srm.supplier.service;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierIllegalRisk;

/**
 * 供应商非法风险记录Service接口
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
public interface ISrmSupplierIllegalRiskService 
{
    /**
     * 查询供应商非法风险记录
     * 
     * @param id 供应商非法风险记录主键
     * @return 供应商非法风险记录
     */
    public SrmSupplierIllegalRisk selectSrmSupplierIllegalRiskById(Long id);

    /**
     * 查询供应商非法风险记录列表
     * 
     * @param srmSupplierIllegalRisk 供应商非法风险记录
     * @return 供应商非法风险记录集合
     */
    public List<SrmSupplierIllegalRisk> selectSrmSupplierIllegalRiskList(SrmSupplierIllegalRisk srmSupplierIllegalRisk);

    /**
     * 新增供应商非法风险记录
     * 
     * @param srmSupplierIllegalRisk 供应商非法风险记录
     * @return 结果
     */
    public int insertSrmSupplierIllegalRisk(SrmSupplierIllegalRisk srmSupplierIllegalRisk);

    /**
     * 修改供应商非法风险记录
     * 
     * @param srmSupplierIllegalRisk 供应商非法风险记录
     * @return 结果
     */
    public int updateSrmSupplierIllegalRisk(SrmSupplierIllegalRisk srmSupplierIllegalRisk);

    /**
     * 批量删除供应商非法风险记录
     * 
     * @param ids 需要删除的供应商非法风险记录主键集合
     * @return 结果
     */
    public int deleteSrmSupplierIllegalRiskByIds(Long[] ids);

    /**
     * 删除供应商非法风险记录信息
     * 
     * @param id 供应商非法风险记录主键
     * @return 结果
     */
    public int deleteSrmSupplierIllegalRiskById(Long id);
}
