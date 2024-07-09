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
import com.srm.supplier.domain.SrmSupplierAssessLevel;
import com.srm.supplier.service.ISrmSupplierAssessLevelService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商评级定义Controller
 * 
 * @author ruoyi
 * @date 2024-07-09
 */
@RestController
@RequestMapping("/supplier/level")
public class SrmSupplierAssessLevelController extends BaseController
{
    @Autowired
    private ISrmSupplierAssessLevelService srmSupplierAssessLevelService;

    /**
     * 查询供应商评级定义列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:level:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        startPage();
        List<SrmSupplierAssessLevel> list = srmSupplierAssessLevelService.selectSrmSupplierAssessLevelList(srmSupplierAssessLevel);
        return getDataTable(list);
    }

    /**
     * 导出供应商评级定义列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:level:export')")
    @Log(title = "供应商评级定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        List<SrmSupplierAssessLevel> list = srmSupplierAssessLevelService.selectSrmSupplierAssessLevelList(srmSupplierAssessLevel);
        ExcelUtil<SrmSupplierAssessLevel> util = new ExcelUtil<SrmSupplierAssessLevel>(SrmSupplierAssessLevel.class);
        util.exportExcel(response, list, "供应商评级定义数据");
    }

    /**
     * 获取供应商评级定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierAssessLevelService.selectSrmSupplierAssessLevelById(id));
    }

    /**
     * 新增供应商评级定义
     */
    @PreAuthorize("@ss.hasPermi('supplier:level:add')")
    @Log(title = "供应商评级定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        return toAjax(srmSupplierAssessLevelService.insertSrmSupplierAssessLevel(srmSupplierAssessLevel));
    }

    /**
     * 修改供应商评级定义
     */
    @PreAuthorize("@ss.hasPermi('supplier:level:edit')")
    @Log(title = "供应商评级定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierAssessLevel srmSupplierAssessLevel)
    {
        return toAjax(srmSupplierAssessLevelService.updateSrmSupplierAssessLevel(srmSupplierAssessLevel));
    }

    /**
     * 删除供应商评级定义
     */
    @PreAuthorize("@ss.hasPermi('supplier:level:remove')")
    @Log(title = "供应商评级定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierAssessLevelService.deleteSrmSupplierAssessLevelByIds(ids));
    }
}
