package com.srm.supplier.mapper;

import java.util.List;
import com.srm.supplier.domain.SrmSupplierOperateRisk;

/**
 * 供应商经营风险记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
public interface SrmSupplierOperateRiskMapper 
{
    /**
     * 查询供应商经营风险记录
     * 
     * @param id 供应商经营风险记录主键
     * @return 供应商经营风险记录
     */
    public SrmSupplierOperateRisk selectSrmSupplierOperateRiskById(Long id);

    /**
     * 查询供应商经营风险记录列表
     * 
     * @param srmSupplierOperateRisk 供应商经营风险记录
     * @return 供应商经营风险记录集合
     */
    public List<SrmSupplierOperateRisk> selectSrmSupplierOperateRiskList(SrmSupplierOperateRisk srmSupplierOperateRisk);

    /**
     * 新增供应商经营风险记录
     * 
     * @param srmSupplierOperateRisk 供应商经营风险记录
     * @return 结果
     */
    public int insertSrmSupplierOperateRisk(SrmSupplierOperateRisk srmSupplierOperateRisk);

    /**
     * 修改供应商经营风险记录
     * 
     * @param srmSupplierOperateRisk 供应商经营风险记录
     * @return 结果
     */
    public int updateSrmSupplierOperateRisk(SrmSupplierOperateRisk srmSupplierOperateRisk);

    /**
     * 删除供应商经营风险记录
     * 
     * @param id 供应商经营风险记录主键
     * @return 结果
     */
    public int deleteSrmSupplierOperateRiskById(Long id);

    /**
     * 批量删除供应商经营风险记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSupplierOperateRiskByIds(Long[] ids);
}
