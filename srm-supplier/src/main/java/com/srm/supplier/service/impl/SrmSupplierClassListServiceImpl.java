package com.srm.supplier.service.impl;

import com.srm.supplier.domain.ClassDTO;
import com.srm.supplier.domain.SrmSupplierClassList;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.mapper.SrmSupplierClassListMapper;
import com.srm.supplier.mapper.SrmSupplierInformationMapper;
import com.srm.supplier.service.ISrmSupplierClassListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 供应商分类Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-05
 */
@Slf4j
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
    public List<SrmSupplierClassList> querySupplierInfo() {

        List<SrmSupplierClassList> classLists = srmSupplierClassListMapper.selectSrmSupplierClassListList(null);
        List<SrmSupplierInformation> fromSupplierInformation = srmSupplierInformationMapper.selectActiveSupplier(null);

        List<ClassDTO> classSupplier = new ArrayList<>();
        for (SrmSupplierClassList classList : classLists) {
            ClassDTO classDTO = new ClassDTO();
            classDTO.setCompanyCode(classList.getCompanyCode());
            classDTO.setEnterprise(classList.getEnterprise());

            classSupplier.add(classDTO);
        }

        List<ClassDTO> allSupplier = new ArrayList<>();
        for (SrmSupplierInformation srmSupplierInformation : fromSupplierInformation) {
            ClassDTO classDTO = new ClassDTO();
            classDTO.setCompanyCode(srmSupplierInformation.getSupplierCode());
            classDTO.setEnterprise(srmSupplierInformation.getSupplierName());

            allSupplier.add(classDTO);
        }

        Set<ClassDTO> classSet = new HashSet<>(classSupplier);
        List<ClassDTO> todoList = new ArrayList<>();

        for (ClassDTO classDTO : allSupplier) {
            if (!classSet.contains(classDTO)) {
                todoList.add(classDTO);
            }
        }

        for (ClassDTO classDTO : todoList) {
            SrmSupplierClassList srmSupplierClassList = new SrmSupplierClassList();
            srmSupplierClassList.setCompanyCode(classDTO.getCompanyCode());
            srmSupplierClassList.setEnterprise(classDTO.getEnterprise());
            classLists.add(srmSupplierClassList);
        }

        return classLists;
    }

    @Override
    public void insertClass(SrmSupplierClassList srmSupplierClassList) {
        srmSupplierClassListMapper.insertSrmClassList(srmSupplierClassList);
    }
}
