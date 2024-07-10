package com.srm.supplier.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.srm.supplier.domain.SrmSupplierScoringCriteriaDefinition;
import com.srm.supplier.service.ISrmSupplierScoringCriteriaDefinitionService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商评分标准定义Controller
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
@Api(tags = "供应商指标定义")
@RestController
@RequestMapping("/supplier/scoring_criteria_definition")
public class SrmSupplierScoringCriteriaDefinitionController extends BaseController
{
    @Autowired
    private ISrmSupplierScoringCriteriaDefinitionService srmSupplierScoringCriteriaDefinitionService;

    /**
     * 查询供应商评分标准定义列表
     */
    @ApiOperation(value = "供应商评分标准定义列表-查询列表")
    @PreAuthorize("@ss.hasPermi('supplier:scoring_criteria_definition:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        startPage();
        List<SrmSupplierScoringCriteriaDefinition> list = srmSupplierScoringCriteriaDefinitionService.selectSrmSupplierScoringCriteriaDefinitionList(srmSupplierScoringCriteriaDefinition);
        return getDataTable(list);
    }

    /**
     * 导出供应商评分标准定义列表
     */
    @ApiOperation(value = "供应商评分标准定义列表-导出")
    @PreAuthorize("@ss.hasPermi('supplier:scoring_criteria_definition:export')")
    @Log(title = "供应商评分标准定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        List<SrmSupplierScoringCriteriaDefinition> list = srmSupplierScoringCriteriaDefinitionService.selectSrmSupplierScoringCriteriaDefinitionList(srmSupplierScoringCriteriaDefinition);
        ExcelUtil<SrmSupplierScoringCriteriaDefinition> util = new ExcelUtil<SrmSupplierScoringCriteriaDefinition>(SrmSupplierScoringCriteriaDefinition.class);
        util.exportExcel(response, list, "供应商评分标准定义数据");
    }

    /**
     * 获取供应商评分标准定义详细信息
     */
    @ApiOperation(value = "供应商评分标准定义列表-获取详细信息")
    @PreAuthorize("@ss.hasPermi('supplier:scoring_criteria_definition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierScoringCriteriaDefinitionService.selectSrmSupplierScoringCriteriaDefinitionById(id));
    }

    /**
     * 新增供应商评分标准定义
     */
    @ApiOperation(value = "供应商评分标准定义列表-新增")
    @PreAuthorize("@ss.hasPermi('supplier:scoring_criteria_definition:add')")
    @Log(title = "供应商评分标准定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        return toAjax(srmSupplierScoringCriteriaDefinitionService.insertSrmSupplierScoringCriteriaDefinition(srmSupplierScoringCriteriaDefinition));
    }

    /**
     * 修改供应商评分标准定义
     */
    @ApiOperation(value = "供应商评分标准定义列表-修改")
    @PreAuthorize("@ss.hasPermi('supplier:scoring_criteria_definition:edit')")
    @Log(title = "供应商评分标准定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierScoringCriteriaDefinition srmSupplierScoringCriteriaDefinition)
    {
        return toAjax(srmSupplierScoringCriteriaDefinitionService.updateSrmSupplierScoringCriteriaDefinition(srmSupplierScoringCriteriaDefinition));
    }


    /**
     * 删除供应商评分标准定义
     */
    @ApiOperation(value = "供应商评分标准定义列表-删除")
    @PreAuthorize("@ss.hasPermi('supplier:scoring_criteria_definition:remove')")
    @Log(title = "供应商评分标准定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierScoringCriteriaDefinitionService.deleteSrmSupplierScoringCriteriaDefinitionByIds(ids));
    }
}
