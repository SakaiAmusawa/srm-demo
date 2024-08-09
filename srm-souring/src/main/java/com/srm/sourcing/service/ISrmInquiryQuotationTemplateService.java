package com.srm.sourcing.service;

import java.util.List;
import com.srm.sourcing.domain.SrmInquiryQuotationTemplate;

/**
 * 询报价模板定义Service接口
 * 
 * @author sakai
 * @date 2024-08-09
 */
public interface ISrmInquiryQuotationTemplateService 
{
    /**
     * 查询询报价模板定义
     * 
     * @param id 询报价模板定义主键
     * @return 询报价模板定义
     */
    public SrmInquiryQuotationTemplate selectSrmInquiryQuotationTemplateById(Long id);

    /**
     * 查询询报价模板定义列表
     * 
     * @param srmInquiryQuotationTemplate 询报价模板定义
     * @return 询报价模板定义集合
     */
    public List<SrmInquiryQuotationTemplate> selectSrmInquiryQuotationTemplateList(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate);

    /**
     * 新增询报价模板定义
     * 
     * @param srmInquiryQuotationTemplate 询报价模板定义
     * @return 结果
     */
    public int insertSrmInquiryQuotationTemplate(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate);

    /**
     * 修改询报价模板定义
     * 
     * @param srmInquiryQuotationTemplate 询报价模板定义
     * @return 结果
     */
    public int updateSrmInquiryQuotationTemplate(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate);

    /**
     * 批量删除询报价模板定义
     * 
     * @param ids 需要删除的询报价模板定义主键集合
     * @return 结果
     */
    public int deleteSrmInquiryQuotationTemplateByIds(Long[] ids);

    /**
     * 删除询报价模板定义信息
     * 
     * @param id 询报价模板定义主键
     * @return 结果
     */
    public int deleteSrmInquiryQuotationTemplateById(Long id);
}
