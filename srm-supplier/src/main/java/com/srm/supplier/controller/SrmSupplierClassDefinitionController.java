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
import com.srm.supplier.domain.SrmSupplierClassDefinition;
import com.srm.supplier.service.ISrmSupplierClassDefinitionService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商分类定义Controller
 * 
 * @author ruoyi
 * @date 2024-07-05
 */
@RestController
@RequestMapping("/supplier/definition")
public class SrmSupplierClassDefinitionController extends BaseController
{
    @Autowired
    private ISrmSupplierClassDefinitionService srmSupplierClassDefinitionService;

    /**
     * 查询供应商分类定义列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:definition:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        startPage();
        List<SrmSupplierClassDefinition> list = srmSupplierClassDefinitionService.selectSrmSupplierClassDefinitionList(srmSupplierClassDefinition);
        return getDataTable(list);
    }

    /**
     * 导出供应商分类定义列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:definition:export')")
    @Log(title = "供应商分类定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        List<SrmSupplierClassDefinition> list = srmSupplierClassDefinitionService.selectSrmSupplierClassDefinitionList(srmSupplierClassDefinition);
        ExcelUtil<SrmSupplierClassDefinition> util = new ExcelUtil<SrmSupplierClassDefinition>(SrmSupplierClassDefinition.class);
        util.exportExcel(response, list, "供应商分类定义数据");
    }

    /**
     * 获取供应商分类定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:definition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierClassDefinitionService.selectSrmSupplierClassDefinitionById(id));
    }

    /**
     * 新增供应商分类定义
     */
    @PreAuthorize("@ss.hasPermi('supplier:definition:add')")
    @Log(title = "供应商分类定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        return toAjax(srmSupplierClassDefinitionService.insertSrmSupplierClassDefinition(srmSupplierClassDefinition));
    }

    /**
     * 修改供应商分类定义
     */
    @PreAuthorize("@ss.hasPermi('supplier:definition:edit')")
    @Log(title = "供应商分类定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierClassDefinition srmSupplierClassDefinition)
    {
        return toAjax(srmSupplierClassDefinitionService.updateSrmSupplierClassDefinition(srmSupplierClassDefinition));
    }

    /**
     * 删除供应商分类定义
     */
    @PreAuthorize("@ss.hasPermi('supplier:definition:remove')")
    @Log(title = "供应商分类定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierClassDefinitionService.deleteSrmSupplierClassDefinitionByIds(ids));
    }
}
