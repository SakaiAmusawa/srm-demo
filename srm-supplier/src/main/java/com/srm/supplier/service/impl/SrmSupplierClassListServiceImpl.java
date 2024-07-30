package com.srm.supplier.service.impl;

import com.srm.supplier.domain.SrmSupplierClassList;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.mapper.SrmSupplierClassListMapper;
import com.srm.supplier.mapper.SrmSupplierInformationMapper;
import com.srm.supplier.service.ISrmSupplierClassListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商分类Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-05
 */
@Service
public class SrmSupplierClassListServiceImpl implements ISrmSupplierClassListService {
    @Autowired
    private SrmSupplierClassListMapper srmSupplierClassListMapper;
    @Autowired
    private SrmSupplierInformationMapper srmSupplierInformationMapper;

    /**
     * 查询供应商分类
     *
     * @param id 供应商分类主键
     * @return 供应商分类
     */
    @Override
    public SrmSupplierClassList selectSrmSupplierClassListById(Long id) {
        return srmSupplierClassListMapper.selectSrmSupplierClassListById(id);
    }

    /**
     * 查询供应商分类列表
     *
     * @param srmSupplierClassList 供应商分类
     * @return 供应商分类
     */
    @Override
    public List<SrmSupplierClassList> selectSrmSupplierClassListList(SrmSupplierClassList srmSupplierClassList) {
        return srmSupplierClassListMapper.selectSrmSupplierClassListList(srmSupplierClassList);
    }

    /**
     * 新增供应商分类
     *
     * @param srmSupplierClassList 供应商分类
     * @return 结果
     */
    @Override
    public int insertSrmSupplierClassList(SrmSupplierClassList srmSupplierClassList) {
        return srmSupplierClassListMapper.insertSrmSupplierClassList(srmSupplierClassList);
    }

    /**
     * 修改供应商分类
     *
     * @param srmSupplierClassList 供应商分类
     * @return 结果
     */
    @Override
    public int updateSrmSupplierClassList(SrmSupplierClassList srmSupplierClassList) {
        return srmSupplierClassListMapper.updateSrmSupplierClassList(srmSupplierClassList);
    }

    /**
     * 批量删除供应商分类
     *
     * @param ids 需要删除的供应商分类主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierClassListByIds(Long[] ids) {
        return srmSupplierClassListMapper.deleteSrmSupplierClassListByIds(ids);
    }

    /**
     * 删除供应商分类信息
     *
     * @param id 供应商分类主键
     * @return 结果
     */
    @Override
    public int deleteSrmSupplierClassListById(Long id) {
        return srmSupplierClassListMapper.deleteSrmSupplierClassListById(id);
    }

    @Override
    public List<SrmSupplierInformation> querySupplierInfor() {
        return srmSupplierInformationMapper.selectActiveSupplier(null);
    }
}
