package com.srm.unity.controller;

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
import com.srm.unity.domain.SrmUnitTypeDefinition;
import com.srm.unity.service.ISrmUnitTypeDefinitionService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 计量单位类型定义Controller
 * 
 * @author ruoyi
 * @date 2024-07-17
 */
@RestController
@RequestMapping("/unity/unity_type_def")
public class SrmUnitTypeDefinitionController extends BaseController
{
    @Autowired
    private ISrmUnitTypeDefinitionService srmUnitTypeDefinitionService;

    /**
     * 查询计量单位类型定义列表
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_type_def:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        startPage();
        List<SrmUnitTypeDefinition> list = srmUnitTypeDefinitionService.selectSrmUnitTypeDefinitionList(srmUnitTypeDefinition);
        return getDataTable(list);
    }

    /**
     * 导出计量单位类型定义列表
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_type_def:export')")
    @Log(title = "计量单位类型定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        List<SrmUnitTypeDefinition> list = srmUnitTypeDefinitionService.selectSrmUnitTypeDefinitionList(srmUnitTypeDefinition);
        ExcelUtil<SrmUnitTypeDefinition> util = new ExcelUtil<SrmUnitTypeDefinition>(SrmUnitTypeDefinition.class);
        util.exportExcel(response, list, "计量单位类型定义数据");
    }

    /**
     * 获取计量单位类型定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_type_def:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmUnitTypeDefinitionService.selectSrmUnitTypeDefinitionById(id));
    }

    /**
     * 新增计量单位类型定义
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_type_def:add')")
    @Log(title = "计量单位类型定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        return toAjax(srmUnitTypeDefinitionService.insertSrmUnitTypeDefinition(srmUnitTypeDefinition));
    }

    /**
     * 修改计量单位类型定义
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_type_def:edit')")
    @Log(title = "计量单位类型定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmUnitTypeDefinition srmUnitTypeDefinition)
    {
        return toAjax(srmUnitTypeDefinitionService.updateSrmUnitTypeDefinition(srmUnitTypeDefinition));
    }

    /**
     * 删除计量单位类型定义
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_type_def:remove')")
    @Log(title = "计量单位类型定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmUnitTypeDefinitionService.deleteSrmUnitTypeDefinitionByIds(ids));
    }
}
