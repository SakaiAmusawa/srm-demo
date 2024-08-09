package com.srm.sourcing.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.enums.BusinessType;
import com.srm.sourcing.domain.SrmInquiryQuotationTemplate;
import com.srm.sourcing.service.ISrmInquiryQuotationTemplateService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 询报价模板定义Controller
 * 
 * @author sakai
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/enquiry/template_def")
public class SrmInquiryQuotationTemplateController extends BaseController
{
    @Autowired
    private ISrmInquiryQuotationTemplateService srmInquiryQuotationTemplateService;

    /**
     * 查询询报价模板定义列表
     */
    @PreAuthorize("@ss.hasPermi('enquiry:template_def:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        startPage();
        List<SrmInquiryQuotationTemplate> list = srmInquiryQuotationTemplateService.selectSrmInquiryQuotationTemplateList(srmInquiryQuotationTemplate);
        return getDataTable(list);
    }

    /**
     * 导出询报价模板定义列表
     */
    @PreAuthorize("@ss.hasPermi('enquiry:template_def:export')")
    @Log(title = "询报价模板定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        List<SrmInquiryQuotationTemplate> list = srmInquiryQuotationTemplateService.selectSrmInquiryQuotationTemplateList(srmInquiryQuotationTemplate);
        ExcelUtil<SrmInquiryQuotationTemplate> util = new ExcelUtil<SrmInquiryQuotationTemplate>(SrmInquiryQuotationTemplate.class);
        util.exportExcel(response, list, "询报价模板定义数据");
    }

    /**
     * 获取询报价模板定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('enquiry:template_def:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmInquiryQuotationTemplateService.selectSrmInquiryQuotationTemplateById(id));
    }

    /**
     * 新增询报价模板定义
     */
    @PreAuthorize("@ss.hasPermi('enquiry:template_def:add')")
    @Log(title = "询报价模板定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        return toAjax(srmInquiryQuotationTemplateService.insertSrmInquiryQuotationTemplate(srmInquiryQuotationTemplate));
    }

    /**
     * 修改询报价模板定义
     */
    @PreAuthorize("@ss.hasPermi('enquiry:template_def:edit')")
    @Log(title = "询报价模板定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmInquiryQuotationTemplate srmInquiryQuotationTemplate)
    {
        return toAjax(srmInquiryQuotationTemplateService.updateSrmInquiryQuotationTemplate(srmInquiryQuotationTemplate));
    }

    /**
     * 删除询报价模板定义
     */
    @PreAuthorize("@ss.hasPermi('enquiry:template_def:remove')")
    @Log(title = "询报价模板定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmInquiryQuotationTemplateService.deleteSrmInquiryQuotationTemplateByIds(ids));
    }
}
