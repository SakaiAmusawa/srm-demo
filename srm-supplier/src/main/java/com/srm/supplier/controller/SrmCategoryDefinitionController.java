package com.srm.supplier.controller;

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
import com.srm.supplier.domain.SrmCategoryDefinition;
import com.srm.supplier.service.ISrmCategoryDefinitionService;
import com.srm.common.utils.poi.ExcelUtil;

/**
 * 品类定义Controller
 * 
 * @author ruoyi
 * @date 2024-07-17
 */
@RestController
@RequestMapping("/category/category_def")
public class SrmCategoryDefinitionController extends BaseController
{
    @Autowired
    private ISrmCategoryDefinitionService srmCategoryDefinitionService;

    /**
     * 查询品类定义列表
     */
    @PreAuthorize("@ss.hasPermi('category:category_def:list')")
    @GetMapping("/list")
    public AjaxResult list(SrmCategoryDefinition srmCategoryDefinition)
    {
        List<SrmCategoryDefinition> list = srmCategoryDefinitionService.selectSrmCategoryDefinitionList(srmCategoryDefinition);
        return success(list);
    }

    /**
     * 导出品类定义列表
     */
    @PreAuthorize("@ss.hasPermi('category:category_def:export')")
    @Log(title = "品类定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmCategoryDefinition srmCategoryDefinition)
    {
        List<SrmCategoryDefinition> list = srmCategoryDefinitionService.selectSrmCategoryDefinitionList(srmCategoryDefinition);
        ExcelUtil<SrmCategoryDefinition> util = new ExcelUtil<SrmCategoryDefinition>(SrmCategoryDefinition.class);
        util.exportExcel(response, list, "品类定义数据");
    }

    /**
     * 获取品类定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('category:category_def:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmCategoryDefinitionService.selectSrmCategoryDefinitionById(id));
    }

    /**
     * 新增品类定义
     */
    @PreAuthorize("@ss.hasPermi('category:category_def:add')")
    @Log(title = "品类定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmCategoryDefinition srmCategoryDefinition)
    {
        return toAjax(srmCategoryDefinitionService.insertSrmCategoryDefinition(srmCategoryDefinition));
    }

    /**
     * 修改品类定义
     */
    @PreAuthorize("@ss.hasPermi('category:category_def:edit')")
    @Log(title = "品类定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmCategoryDefinition srmCategoryDefinition)
    {
        return toAjax(srmCategoryDefinitionService.updateSrmCategoryDefinition(srmCategoryDefinition));
    }

    /**
     * 删除品类定义
     */
    @PreAuthorize("@ss.hasPermi('category:category_def:remove')")
    @Log(title = "品类定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmCategoryDefinitionService.deleteSrmCategoryDefinitionByIds(ids));
    }

    @GetMapping("/unit")
    public AjaxResult getUnit()
    {
    	return success(srmCategoryDefinitionService.selectUnitList());
    }
}
