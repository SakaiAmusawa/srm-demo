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
import com.srm.supplier.domain.SrmSupplierClassList;
import com.srm.supplier.service.ISrmSupplierClassListService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商分类Controller
 * 
 * @author ruoyi
 * @date 2024-07-05
 */
@Api("供应商分类")
@RestController
@RequestMapping("/supplier/clas")
public class SrmSupplierClassListController extends BaseController
{
    @Autowired
    private ISrmSupplierClassListService srmSupplierClassListService;

    /**
     * 查询供应商分类列表
     */
    @ApiOperation("供应商分类定义")
    @PreAuthorize("@ss.hasPermi('supplier:clas:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierClassList srmSupplierClassList)
    {
        startPage();
        List<SrmSupplierClassList> list = srmSupplierClassListService.selectSrmSupplierClassListList(srmSupplierClassList);
        return getDataTable(list);
    }

    /**
     * 导出供应商分类列表
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:export')")
    @Log(title = "供应商分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierClassList srmSupplierClassList)
    {
        List<SrmSupplierClassList> list = srmSupplierClassListService.selectSrmSupplierClassListList(srmSupplierClassList);
        ExcelUtil<SrmSupplierClassList> util = new ExcelUtil<SrmSupplierClassList>(SrmSupplierClassList.class);
        util.exportExcel(response, list, "供应商分类数据");
    }

    /**
     * 获取供应商分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierClassListService.selectSrmSupplierClassListById(id));
    }

    /**
     * 新增供应商分类
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:add')")
    @Log(title = "供应商分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierClassList srmSupplierClassList)
    {
        return toAjax(srmSupplierClassListService.insertSrmSupplierClassList(srmSupplierClassList));
    }

    /**
     * 修改供应商分类
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:edit')")
    @Log(title = "供应商分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierClassList srmSupplierClassList)
    {
        return toAjax(srmSupplierClassListService.updateSrmSupplierClassList(srmSupplierClassList));
    }

    /**
     * 删除供应商分类
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:remove')")
    @Log(title = "供应商分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierClassListService.deleteSrmSupplierClassListByIds(ids));
    }
}
