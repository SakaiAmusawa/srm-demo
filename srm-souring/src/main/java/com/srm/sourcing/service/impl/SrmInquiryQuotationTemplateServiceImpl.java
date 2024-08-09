package com.srm.sourcing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.srm.sourcing.mapper.SrmInquiryQuotationTemplateMapper;
import com.srm.sourcing.domain.SrmInquiryQuotationTemplate;
import com.srm.sourcing.service.ISrmInquiryQuotationTemplateService;

/**
 * 询报价模板定义Service业务层处理
 * 
 * @author sakai
 * @date 2024-08-09
 */
@Service
public class SrmInquiryQuotationTemplateServiceImpl implements ISrmInquiryQuotationTemplateService 
{
    @Autowired
    private SrmInquiryQuotationTemplateMapper srmInquiryQuotationTemplateMapper;

    /**
     * 查询询报价模板定义
     * 
     * @param id 询报价模板定义主键
     * @return 询报价模板定义
     */
    @Override
    public SrmInquiryQuotationTemplate selectSrmInquiryQuotationTemplateById(Long id)
    {
        return srmInquiryQuotationTemplateMapper.selectSrmInquiryQuotationTemplateById(id);
    }

    /**
     * 查询询报价模板定义列表
     * 
     * @param srmInquiryQuotationTemplate 询报价模板定义
     * @return 询报价模板定义
     */
    @Override
    public List<SrmInquiryQuotationTemplate> selectSrmInquiryQuotationTemplateList(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        return srmInquiryQuotationTemplateMapper.selectSrmInquiryQuotationTemplateList(srmInquiryQuotationTemplate);
    }

    /**
     * 新增询报价模板定义
     * 
     * @param srmInquiryQuotationTemplate 询报价模板定义
     * @return 结果
     */
    @Override
    public int insertSrmInquiryQuotationTemplate(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        return srmInquiryQuotationTemplateMapper.insertSrmInquiryQuotationTemplate(srmInquiryQuotationTemplate);
    }

    /**
     * 修改询报价模板定义
     * 
     * @param srmInquiryQuotationTemplate 询报价模板定义
     * @return 结果
     */
    @Override
    public int updateSrmInquiryQuotationTemplate(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        return srmInquiryQuotationTemplateMapper.updateSrmInquiryQuotationTemplate(srmInquiryQuotationTemplate);
    }

    /**
     * 批量删除询报价模板定义
     * 
     * @param ids 需要删除的询报价模板定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmInquiryQuotationTemplateByIds(Long[] ids)
    {
        return srmInquiryQuotationTemplateMapper.deleteSrmInquiryQuotationTemplateByIds(ids);
    }

    /**
     * 删除询报价模板定义信息
     * 
     * @param id 询报价模板定义主键
     * @return 结果
     */
    @Override
    public int deleteSrmInquiryQuotationTemplateById(Long id)
    {
        return srmInquiryQuotationTemplateMapper.deleteSrmInquiryQuotationTemplateById(id);
    }
}
