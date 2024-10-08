package com.srm.sourcing.service.impl;

import com.srm.common.core.domain.model.LoginUser;
import com.srm.common.exception.ServiceException;
import com.srm.common.utils.DateUtils;
import com.srm.common.utils.SecurityUtils;
import com.srm.common.utils.StringUtils;
import com.srm.sakai.mapper.SakaiMapper;
import com.srm.sourcing.domain.*;
import com.srm.sourcing.mapper.SrmInquiryQuotationTemplateMapper;
import com.srm.sourcing.mapper.SrmSourcingMapper;
import com.srm.sourcing.service.ISrmSourcingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 询价台Service业务层处理
 *
 * @author sakai
 * @date 2024-08-12
 */
@Service
public class SrmSourcingServiceImpl implements ISrmSourcingService {
    @Autowired
    private SrmSourcingMapper srmSourcingMapper;
    @Autowired
    private SrmInquiryQuotationTemplateMapper srmInquiryQuotationTemplateMapper;
    @Autowired
    private SakaiMapper sakaiMapper;

    private void compareTime(SrmSourcing srmSourcing) {
        Date quotationStartTime = srmSourcing.getQuotationStartTime();
        Date quotationEndTime = srmSourcing.getQuotationEndTime();

        if (quotationEndTime.before(quotationStartTime)) {
            throw new ServiceException("错误！结束时间应当在开始时间之前");
        }
    }

    /**
     * 查询询价台
     *
     * @param id 询价台主键
     * @return 询价台
     */
    @Override
    public SrmSourcing selectSrmSourcingById(Long id) {
        SrmSourcing srmSourcing = srmSourcingMapper.selectSrmSourcingById(id);
        List<SrmSourcingMaterialDetail> materialDetails = srmSourcingMapper.selectSrmSourcingMaterialDetailList(id);
        srmSourcing.setSrmSourcingMaterialDetailList(materialDetails);

        List<SrmSourcingSupplierDetail> supplierDetails = srmSourcingMapper.selectSrmSourcingSupplierDetailList(id);
        srmSourcing.setSrmSourcingSupplierDetailList(supplierDetails);

        List<SrmSourcingAttachment> attachments = srmSourcingMapper.selectSrmSourcingAttachmentList(id);
        srmSourcing.setSrmSourcingAttachmentList(attachments);
        return srmSourcing;
    }

    /**
     * 查询询价台列表
     *
     * @param srmSourcing 询价台
     * @return 询价台
     */
    @Override
    public List<SrmSourcing> selectSrmSourcingList(SrmSourcing srmSourcing) {
        return srmSourcingMapper.selectSrmSourcingList(srmSourcing);
    }

    /**
     * 新增询价台
     *
     * @param srmSourcing 询价台
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSourcing(SrmSourcing srmSourcing) {

        //判断用户是否填写相关信息
        List<SrmSourcingMaterialDetail> srmSourcingMaterialDetailList = srmSourcing.getSrmSourcingMaterialDetailList();
        if (srmSourcingMaterialDetailList.isEmpty()) {
            throw new ServiceException("物料明细不能为空");
        }
        List<SrmSourcingSupplierDetail> srmSourcingSupplierDetailList = srmSourcing.getSrmSourcingSupplierDetailList();
        if (srmSourcingSupplierDetailList.isEmpty()) {
            throw new ServiceException("供应商明细不能为空");
        }

        //根据模板ID获取模板相关内容
        Long sourcingTemplate = srmSourcing.getSourcingTemplate();
        SrmInquiryQuotationTemplate srmInquiryQuotationTemplate = srmInquiryQuotationTemplateMapper.selectSrmInquiryQuotationTemplateById(sourcingTemplate);
        Long maxSupplierNumber = srmInquiryQuotationTemplate.getMaxSupplierNumber();
        Long minSupplierNumber = srmInquiryQuotationTemplate.getMinSupplierNumber();

        //判断是否符合最大、最小数量
        Long supplierListSize = (long) srmSourcingSupplierDetailList.size();

        if (!(maxSupplierNumber > supplierListSize && supplierListSize >= minSupplierNumber)) {
            throw new ServiceException("供应商数量不符合要求");
        }

        compareTime(srmSourcing);

        //设置设置寻源单号
        if (srmSourcing.getSourcingSerial() == null) {
            srmSourcing.setSourcingSerial("RFQ" + System.currentTimeMillis() / 1000);
        }

        //设置创建人，创建人部门
        LoginUser loginUser = SecurityUtils.getLoginUser();
        srmSourcing.setCreator(loginUser.getUsername());
        Long deptId = loginUser.getDeptId();
        String deptName = sakaiMapper.selectDeptNameByDeptId(deptId);
        srmSourcing.setCreatorDept(deptName);

        srmSourcing.setCreateTime(DateUtils.getNowDate());
        int rows = srmSourcingMapper.insertSrmSourcing(srmSourcing);
        insertSrmSourcingMaterialDetail(srmSourcing);
        insertSrmSourcingSupplierDetail(srmSourcing);
        insertSrmSourcingAttachment(srmSourcing);
        return rows;
    }

    /**
     * 修改询价台
     *
     * @param srmSourcing 询价台
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSourcing(SrmSourcing srmSourcing) {
        compareTime(srmSourcing);
        srmSourcingMapper.deleteSrmSourcingMaterialDetailBySourcingId(srmSourcing.getId());
        srmSourcingMapper.deleteSrmSourcingSupplierDetailBySourcingId(srmSourcing.getId());
        srmSourcingMapper.deleteSrmSourcingAttachmentBySourcingId(srmSourcing.getId());
        insertSrmSourcingMaterialDetail(srmSourcing);
        insertSrmSourcingSupplierDetail(srmSourcing);
        insertSrmSourcingAttachment(srmSourcing);
        return srmSourcingMapper.updateSrmSourcing(srmSourcing);
    }

    /**
     * 批量删除询价台
     *
     * @param ids 需要删除的询价台主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSourcingByIds(Long[] ids) {
        srmSourcingMapper.deleteSrmSourcingMaterialDetailBySourcingIds(ids);
        srmSourcingMapper.deleteSrmSourcingSupplierDetailBySourcingIds(ids);
        srmSourcingMapper.deleteSrmSourcingAttachmentBySourcingIds(ids);
        return srmSourcingMapper.deleteSrmSourcingByIds(ids);
    }

    /**
     * 删除询价台信息
     *
     * @param id 询价台主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSourcingById(Long id) {
        srmSourcingMapper.deleteSrmSourcingMaterialDetailBySourcingId(id);
        srmSourcingMapper.deleteSrmSourcingSupplierDetailBySourcingId(id);
        srmSourcingMapper.deleteSrmSourcingAttachmentBySourcingId(id);
        return srmSourcingMapper.deleteSrmSourcingById(id);
    }

    /**
     * 新增寻源物料明细信息
     *
     * @param srmSourcing 询价台对象
     */
    public void insertSrmSourcingMaterialDetail(SrmSourcing srmSourcing) {
        List<SrmSourcingMaterialDetail> srmSourcingMaterialDetailList = srmSourcing.getSrmSourcingMaterialDetailList();
        Long id = srmSourcing.getId();
        if (StringUtils.isNotNull(srmSourcingMaterialDetailList)) {
            List<SrmSourcingMaterialDetail> list = new ArrayList<SrmSourcingMaterialDetail>();
            for (SrmSourcingMaterialDetail srmSourcingMaterialDetail : srmSourcingMaterialDetailList) {
                srmSourcingMaterialDetail.setSourcingId(id);
                list.add(srmSourcingMaterialDetail);
            }
            if (list.size() > 0) {
                srmSourcingMapper.batchSrmSourcingMaterialDetail(list);
            }
        }
    }

    /**
     * 新增寻源供应商明细信息
     *
     * @param srmSourcing 询价台对象
     */
    public void insertSrmSourcingSupplierDetail(SrmSourcing srmSourcing) {
        List<SrmSourcingSupplierDetail> srmSourcingSupplierDetailList = srmSourcing.getSrmSourcingSupplierDetailList();
        Long id = srmSourcing.getId();
        if (StringUtils.isNotNull(srmSourcingSupplierDetailList)) {
            List<SrmSourcingSupplierDetail> list = new ArrayList<SrmSourcingSupplierDetail>();
            for (SrmSourcingSupplierDetail srmSourcingSupplierDetail : srmSourcingSupplierDetailList) {
                srmSourcingSupplierDetail.setSourcingId(id);
                list.add(srmSourcingSupplierDetail);
            }
            if (list.size() > 0) {
                srmSourcingMapper.batchSrmSourcingSupplierDetail(list);
            }
        }
    }

    /**
     * 新增寻源附件信息
     *
     * @param srmSourcing 询价台对象
     */
    public void insertSrmSourcingAttachment(SrmSourcing srmSourcing) {
        List<SrmSourcingAttachment> srmSourcingAttachmentList = srmSourcing.getSrmSourcingAttachmentList();
        Long id = srmSourcing.getId();
        if (StringUtils.isNotNull(srmSourcingAttachmentList)) {
            List<SrmSourcingAttachment> list = new ArrayList<SrmSourcingAttachment>();
            for (SrmSourcingAttachment srmSourcingAttachment : srmSourcingAttachmentList) {
                srmSourcingAttachment.setSourcingId(id);
                list.add(srmSourcingAttachment);
            }
            if (list.size() > 0) {
                srmSourcingMapper.batchSrmSourcingAttachment(list);
            }
        }
    }
}
