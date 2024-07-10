package com.srm.supplier.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.supplier.domain.SrmSupplierClassDefinition;
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.domain.SrmSupplierScoringTemplateCriteria;
import com.srm.supplier.domain.SrmSupplierScoringTemplateDefinition;
import com.srm.supplier.service.ISrmSupplierScoringTemplateDefinitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 评分模板定义Controller
 *
 * @author ruoyi
 * @date 2024-07-10
 */
@Slf4j
@RestController
@RequestMapping("/scoring_template/template")
public class SrmSupplierScoringTemplateDefinitionController extends BaseController {
    @Autowired
    private ISrmSupplierScoringTemplateDefinitionService srmSupplierScoringTemplateDefinitionService;

    /**
     * 查询评分模板定义列表
     */
    @PreAuthorize("@ss.hasPermi('scoring_template:template:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        startPage();
        List<SrmSupplierScoringTemplateDefinition> list = srmSupplierScoringTemplateDefinitionService.selectSrmSupplierScoringTemplateDefinitionList(srmSupplierScoringTemplateDefinition);
        return getDataTable(list);
    }

    /**
     * 导出评分模板定义列表
     */
    @PreAuthorize("@ss.hasPermi('scoring_template:template:export')")
    @Log(title = "评分模板定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        List<SrmSupplierScoringTemplateDefinition> list = srmSupplierScoringTemplateDefinitionService.selectSrmSupplierScoringTemplateDefinitionList(srmSupplierScoringTemplateDefinition);
        ExcelUtil<SrmSupplierScoringTemplateDefinition> util = new ExcelUtil<SrmSupplierScoringTemplateDefinition>(SrmSupplierScoringTemplateDefinition.class);
        util.exportExcel(response, list, "评分模板定义数据");
    }

    /**
     * 获取评分模板定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('scoring_template:template:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmSupplierScoringTemplateDefinitionService.selectSrmSupplierScoringTemplateDefinitionById(id));
    }

    /**
     * 新增评分模板定义
     */
    @PreAuthorize("@ss.hasPermi('scoring_template:template:add')")
    @Log(title = "评分模板定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        return toAjax(srmSupplierScoringTemplateDefinitionService.insertSrmSupplierScoringTemplateDefinition(srmSupplierScoringTemplateDefinition));
    }

    /**
     * 修改评分模板定义
     */
    @PreAuthorize("@ss.hasPermi('scoring_template:template:edit')")
    @Log(title = "评分模板定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierScoringTemplateDefinition srmSupplierScoringTemplateDefinition) {
        return toAjax(srmSupplierScoringTemplateDefinitionService.updateSrmSupplierScoringTemplateDefinition(srmSupplierScoringTemplateDefinition));
    }

    /**
     * 删除评分模板定义
     */
    @PreAuthorize("@ss.hasPermi('scoring_template:template:remove')")
    @Log(title = "评分模板定义", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmSupplierScoringTemplateDefinitionService.deleteSrmSupplierScoringTemplateDefinitionByIds(ids));
    }

    @GetMapping("/getCriteria")
    public AjaxResult getCriteria() {
        List<SrmSupplierScoringCriteriaDefinition> srmSupplierScoringTemplateCriteria = srmSupplierScoringTemplateDefinitionService.getCriteria();
        log.debug("criteria:{}", srmSupplierScoringTemplateCriteria);
        return AjaxResult.success(srmSupplierScoringTemplateCriteria);
    }
}
