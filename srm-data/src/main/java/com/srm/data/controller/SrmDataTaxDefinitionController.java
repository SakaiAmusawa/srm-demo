package com.srm.data.controller;

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
import com.srm.data.domain.SrmDataTaxDefinition;
import com.srm.data.service.ISrmDataTaxDefinitionService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 税率定义Controller
 * 
 * @author sakai
 * @date 2024-08-07
 */
@RestController
@RequestMapping("/tax/taxdefinition")
public class SrmDataTaxDefinitionController extends BaseController
{
    @Autowired
    private ISrmDataTaxDefinitionService srmDataTaxDefinitionService;

    /**
     * 查询税率定义列表
     */
    @PreAuthorize("@ss.hasPermi('tax:taxdefinition:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmDataTaxDefinition srmDataTaxDefinition)
    {
        startPage();
        List<SrmDataTaxDefinition> list = srmDataTaxDefinitionService.selectSrmDataTaxDefinitionList(srmDataTaxDefinition);
        return getDataTable(list);
    }

    /**
     * 导出税率定义列表
     */
    @PreAuthorize("@ss.hasPermi('tax:taxdefinition:export')")
    @Log(title = "税率定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmDataTaxDefinition srmDataTaxDefinition)
    {
        List<SrmDataTaxDefinition> list = srmDataTaxDefinitionService.selectSrmDataTaxDefinitionList(srmDataTaxDefinition);
        ExcelUtil<SrmDataTaxDefinition> util = new ExcelUtil<SrmDataTaxDefinition>(SrmDataTaxDefinition.class);
        util.exportExcel(response, list, "税率定义数据");
    }

    /**
     * 获取税率定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('tax:taxdefinition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmDataTaxDefinitionService.selectSrmDataTaxDefinitionById(id));
    }

    /**
     * 新增税率定义
     */
    @PreAuthorize("@ss.hasPermi('tax:taxdefinition:add')")
    @Log(title = "税率定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmDataTaxDefinition srmDataTaxDefinition)
    {
        return toAjax(srmDataTaxDefinitionService.insertSrmDataTaxDefinition(srmDataTaxDefinition));
    }

    /**
     * 修改税率定义
     */
    @PreAuthorize("@ss.hasPermi('tax:taxdefinition:edit')")
    @Log(title = "税率定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmDataTaxDefinition srmDataTaxDefinition)
    {
        return toAjax(srmDataTaxDefinitionService.updateSrmDataTaxDefinition(srmDataTaxDefinition));
    }

    /**
     * 删除税率定义
     */
    @PreAuthorize("@ss.hasPermi('tax:taxdefinition:remove')")
    @Log(title = "税率定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmDataTaxDefinitionService.deleteSrmDataTaxDefinitionByIds(ids));
    }
}
