package com.srm.inspect.service.impl;

import com.srm.common.utils.StringUtils;
import com.srm.inspect.domain.SrmSupplierSiteVisit;
import com.srm.inspect.domain.SrmSupplierSiteVisitMaterial;
import com.srm.inspect.domain.SrmSupplierSiteVisitUser;
import com.srm.inspect.mapper.SrmSupplierSiteVisitMapper;
import com.srm.inspect.service.ISrmSupplierSiteVisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商现场考察Service业务层处理
 *
 * @author sakai
 * @date 2024-07-16
 */
@Slf4j
@Service
public class SrmSupplierSiteVisitServiceImpl implements ISrmSupplierSiteVisitService {
    @Autowired
    private SrmSupplierSiteVisitMapper srmSupplierSiteVisitMapper;

    /**
     * 查询供应商现场考察
     *
     * @param id 供应商现场考察主键
     * @return 供应商现场考察
     */
    @Override
    public SrmSupplierSiteVisit selectSrmSupplierSiteVisitById(Long id) {
        log.debug("result:{}", srmSupplierSiteVisitMapper.selectSrmSupplierSiteVisitById(id));
        return srmSupplierSiteVisitMapper.selectSrmSupplierSiteVisitById(id);
    }

    /**
     * 查询供应商现场考察列表
     *
     * @param srmSupplierSiteVisit 供应商现场考察
     * @return 供应商现场考察
     */
    @Override
    public List<SrmSupplierSiteVisit> selectSrmSupplierSiteVisitList(SrmSupplierSiteVisit srmSupplierSiteVisit) {
        return srmSupplierSiteVisitMapper.selectSrmSupplierSiteVisitList(srmSupplierSiteVisit);
    }

    /**
     * 新增供应商现场考察
     *
     * @param srmSupplierSiteVisit 供应商现场考察
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierSiteVisit(SrmSupplierSiteVisit srmSupplierSiteVisit) {
        //设置考察结果默认为0：未考察
        srmSupplierSiteVisit.setInvestigateRes(0L);
        int rows = srmSupplierSiteVisitMapper.insertSrmSupplierSiteVisit(srmSupplierSiteVisit);
        insertSrmSupplierSiteVisitMaterial(srmSupplierSiteVisit);
        insertSrmSupplierSiteVisitUser(srmSupplierSiteVisit);
        return rows;
    }

    /**
     * 修改供应商现场考察
     *
     * @param srmSupplierSiteVisit 供应商现场考察
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierSiteVisit(SrmSupplierSiteVisit srmSupplierSiteVisit) {
        srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitMaterialByInvestigateId(srmSupplierSiteVisit.getId());
        srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitUserByInvestigateId(srmSupplierSiteVisit.getId());
        insertSrmSupplierSiteVisitMaterial(srmSupplierSiteVisit);
        insertSrmSupplierSiteVisitUser(srmSupplierSiteVisit);
        return srmSupplierSiteVisitMapper.updateSrmSupplierSiteVisit(srmSupplierSiteVisit);
    }

    /**
     * 批量删除供应商现场考察
     *
     * @param ids 需要删除的供应商现场考察主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierSiteVisitByIds(Long[] ids) {
        srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitMaterialByInvestigateIds(ids);
        srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitUserByInvestigateIds(ids);
        return srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitByIds(ids);
    }

    /**
     * 删除供应商现场考察信息
     *
     * @param id 供应商现场考察主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierSiteVisitById(Long id) {
        srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitMaterialByInvestigateId(id);
        srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitUserByInvestigateId(id);
        return srmSupplierSiteVisitMapper.deleteSrmSupplierSiteVisitById(id);
    }

    /**
     * 新增供应商现场考察物料信息
     *
     * @param srmSupplierSiteVisit 供应商现场考察对象
     */
    public void insertSrmSupplierSiteVisitMaterial(SrmSupplierSiteVisit srmSupplierSiteVisit) {
        List<SrmSupplierSiteVisitMaterial> srmSupplierSiteVisitMaterialList = srmSupplierSiteVisit.getSrmSupplierSiteVisitMaterialList();
        Long id = srmSupplierSiteVisit.getId();
        if (StringUtils.isNotNull(srmSupplierSiteVisitMaterialList)) {
            List<SrmSupplierSiteVisitMaterial> list = new ArrayList<SrmSupplierSiteVisitMaterial>();
            for (SrmSupplierSiteVisitMaterial srmSupplierSiteVisitMaterial : srmSupplierSiteVisitMaterialList) {
                srmSupplierSiteVisitMaterial.setInvestigateId(id);
                list.add(srmSupplierSiteVisitMaterial);
            }
            if (list.size() > 0) {
                srmSupplierSiteVisitMapper.batchSrmSupplierSiteVisitMaterial(list);
            }
        }
    }

    /**
     * 新增供应商现场考察人员信息
     *
     * @param srmSupplierSiteVisit 供应商现场考察对象
     */
    public void insertSrmSupplierSiteVisitUser(SrmSupplierSiteVisit srmSupplierSiteVisit) {
        List<SrmSupplierSiteVisitUser> srmSupplierSiteVisitUserList = srmSupplierSiteVisit.getSrmSupplierSiteVisitUserList();
        Long id = srmSupplierSiteVisit.getId();
        if (StringUtils.isNotNull(srmSupplierSiteVisitUserList)) {
            List<SrmSupplierSiteVisitUser> list = new ArrayList<SrmSupplierSiteVisitUser>();
            for (SrmSupplierSiteVisitUser srmSupplierSiteVisitUser : srmSupplierSiteVisitUserList) {
                srmSupplierSiteVisitUser.setInvestigateId(id);
                list.add(srmSupplierSiteVisitUser);
            }
            if (list.size() > 0) {
                srmSupplierSiteVisitMapper.batchSrmSupplierSiteVisitUser(list);
            }
        }
    }
}
