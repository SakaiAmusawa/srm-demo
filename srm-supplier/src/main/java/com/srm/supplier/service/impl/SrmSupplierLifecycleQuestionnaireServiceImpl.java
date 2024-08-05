package com.srm.supplier.service.impl;

import com.srm.common.core.domain.entity.SysDictData;
import com.srm.common.utils.StringUtils;
import com.srm.supplier.domain.SrmSupplierBasicInformation;
import com.srm.supplier.domain.SrmSupplierLifecycleQuestionnaire;
import com.srm.supplier.mapper.SrmSupplierLifecycleQuestionnaireMapper;
import com.srm.supplier.service.ISrmSupplierLifecycleQuestionnaireService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商生命周期调查Service业务层处理
 *
 * @author ruoyi
 * @date 2024-07-31
 */
@Service
public class SrmSupplierLifecycleQuestionnaireServiceImpl implements ISrmSupplierLifecycleQuestionnaireService {
    @Autowired
    private SrmSupplierLifecycleQuestionnaireMapper srmSupplierLifecycleQuestionnaireMapper;

    /**
     * 查询供应商生命周期调查
     *
     * @param id 供应商生命周期调查主键
     * @return 供应商生命周期调查
     */
    @Override
    public SrmSupplierLifecycleQuestionnaire selectSrmSupplierLifecycleQuestionnaireById(Long id) {
         SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire = srmSupplierLifecycleQuestionnaireMapper.selectSrmSupplierLifecycleQuestionnaireById(id);
         srmSupplierLifecycleQuestionnaire.setSrmSupplierBasicInformationList(srmSupplierLifecycleQuestionnaireMapper.selectSrmSupplierBasicInformationList(id));
         return srmSupplierLifecycleQuestionnaire;
    }

    /**
     * 查询供应商生命周期调查列表
     *
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查
     * @return 供应商生命周期调查
     */
    @Override
    public List<SrmSupplierLifecycleQuestionnaire> selectSrmSupplierLifecycleQuestionnaireList(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        return srmSupplierLifecycleQuestionnaireMapper.selectSrmSupplierLifecycleQuestionnaireList(srmSupplierLifecycleQuestionnaire);
    }

    /**
     * 新增供应商生命周期调查
     *
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSrmSupplierLifecycleQuestionnaire(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        int rows = srmSupplierLifecycleQuestionnaireMapper.insertSrmSupplierLifecycleQuestionnaire(srmSupplierLifecycleQuestionnaire);
        insertSrmSupplierBasicInformation(srmSupplierLifecycleQuestionnaire);
        return rows;
    }

    /**
     * 修改供应商生命周期调查
     *
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSrmSupplierLifecycleQuestionnaire(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        srmSupplierLifecycleQuestionnaireMapper.deleteSrmSupplierBasicInformationBySurveyId(srmSupplierLifecycleQuestionnaire.getId());
        insertSrmSupplierBasicInformation(srmSupplierLifecycleQuestionnaire);

        return srmSupplierLifecycleQuestionnaireMapper.updateSrmSupplierLifecycleQuestionnaire(srmSupplierLifecycleQuestionnaire);
    }

    /**
     * 批量删除供应商生命周期调查
     *
     * @param ids 需要删除的供应商生命周期调查主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierLifecycleQuestionnaireByIds(Long[] ids) {
        srmSupplierLifecycleQuestionnaireMapper.deleteSrmSupplierBasicInformationBySurveyIds(ids);
        return srmSupplierLifecycleQuestionnaireMapper.deleteSrmSupplierLifecycleQuestionnaireByIds(ids);
    }

    /**
     * 删除供应商生命周期调查信息
     *
     * @param id 供应商生命周期调查主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSrmSupplierLifecycleQuestionnaireById(Long id) {
        srmSupplierLifecycleQuestionnaireMapper.deleteSrmSupplierBasicInformationBySurveyId(id);
        return srmSupplierLifecycleQuestionnaireMapper.deleteSrmSupplierLifecycleQuestionnaireById(id);
    }

    @Override
    public List<SysDictData> selectDictDetail(String dictKey) {

        List<SysDictData> dictData = srmSupplierLifecycleQuestionnaireMapper.selectDictData(dictKey);
        return dictData;

    }

    /**
     * 新增供应商基本信息信息
     *
     * @param srmSupplierLifecycleQuestionnaire 供应商生命周期调查对象
     */
    public void insertSrmSupplierBasicInformation(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        List<SrmSupplierBasicInformation> srmSupplierBasicInformationList = srmSupplierLifecycleQuestionnaire.getSrmSupplierBasicInformationList();
        Long id = srmSupplierLifecycleQuestionnaire.getId();
        if (StringUtils.isNotNull(srmSupplierBasicInformationList)) {
            List<SrmSupplierBasicInformation> list = new ArrayList<SrmSupplierBasicInformation>();
            for (SrmSupplierBasicInformation srmSupplierBasicInformation : srmSupplierBasicInformationList) {
                srmSupplierBasicInformation.setSurveyId(id);
                list.add(srmSupplierBasicInformation);
            }
            if (list.size() > 0) {
                srmSupplierLifecycleQuestionnaireMapper.batchSrmSupplierBasicInformation(list);
            }
        }
    }
}
