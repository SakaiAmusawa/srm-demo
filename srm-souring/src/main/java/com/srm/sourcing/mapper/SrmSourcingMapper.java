package com.srm.sourcing.mapper;

import com.srm.sourcing.domain.SrmSourcing;
import com.srm.sourcing.domain.SrmSourcingAttachment;
import com.srm.sourcing.domain.SrmSourcingMaterialDetail;
import com.srm.sourcing.domain.SrmSourcingSupplierDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 询价台Mapper接口
 *
 * @author sakai
 * @date 2024-08-12
 */
@Repository
public interface SrmSourcingMapper {
    /**
     * 查询询价台
     *
     * @param id 询价台主键
     * @return 询价台
     */
    public SrmSourcing selectSrmSourcingById(Long id);

    /**
     * 查询询价台列表
     *
     * @param srmSourcing 询价台
     * @return 询价台集合
     */
    public List<SrmSourcing> selectSrmSourcingList(SrmSourcing srmSourcing);

    /**
     * 新增询价台
     *
     * @param srmSourcing 询价台
     * @return 结果
     */
    public int insertSrmSourcing(SrmSourcing srmSourcing);

    /**
     * 修改询价台
     *
     * @param srmSourcing 询价台
     * @return 结果
     */
    public int updateSrmSourcing(SrmSourcing srmSourcing);

    /**
     * 删除询价台
     *
     * @param id 询价台主键
     * @return 结果
     */
    public int deleteSrmSourcingById(Long id);

    /**
     * 批量删除询价台
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSourcingByIds(Long[] ids);

    /**
     * 批量删除寻源物料明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSourcingMaterialDetailBySourcingIds(Long[] ids);

    /**
     * 批量新增寻源物料明细
     *
     * @param srmSourcingMaterialDetailList 寻源物料明细列表
     * @return 结果
     */
    public int batchSrmSourcingMaterialDetail(List<SrmSourcingMaterialDetail> srmSourcingMaterialDetailList);


    /**
     * 通过询价台主键删除寻源物料明细信息
     *
     * @param id 询价台ID
     * @return 结果
     */
    public int deleteSrmSourcingMaterialDetailBySourcingId(Long id);

    /**
     * 批量删除寻源供应商明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSourcingSupplierDetailBySourcingIds(Long[] ids);

    /**
     * 批量新增寻源供应商明细
     *
     * @param srmSourcingSupplierDetailList 寻源供应商明细列表
     * @return 结果
     */
    public int batchSrmSourcingSupplierDetail(List<SrmSourcingSupplierDetail> srmSourcingSupplierDetailList);


    /**
     * 通过询价台主键删除寻源供应商明细信息
     *
     * @param id 询价台ID
     * @return 结果
     */
    public int deleteSrmSourcingSupplierDetailBySourcingId(Long id);

    /**
     * 批量删除寻源附件
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSrmSourcingAttachmentBySourcingIds(Long[] ids);

    /**
     * 批量新增寻源附件
     *
     * @param srmSourcingAttachmentList 寻源附件列表
     * @return 结果
     */
    public int batchSrmSourcingAttachment(List<SrmSourcingAttachment> srmSourcingAttachmentList);


    /**
     * 通过询价台主键删除寻源附件信息
     *
     * @param id 询价台ID
     * @return 结果
     */
    public int deleteSrmSourcingAttachmentBySourcingId(Long id);
}
