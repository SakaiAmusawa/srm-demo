package com.srm.supplier.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.supplier.domain.SrmSupplierClassDefinition;
import com.srm.supplier.domain.SrmSupplierClassList;
import com.srm.supplier.service.ISrmSupplierClassDefinitionService;
import com.srm.supplier.service.ISrmSupplierClassListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商分类Controller
 *
 * @author ruoyi
 * @date 2024-07-05
 */
@Slf4j
@Api("供应商分类列表")
@RestController
@RequestMapping("/supplier/clas")
public class SrmSupplierClassListController extends BaseController {
    @Autowired
    private ISrmSupplierClassListService srmSupplierClassListService;
    @Autowired
    private ISrmSupplierClassDefinitionService classDefinitionService;

    /**
     * 查询供应商分类列表
     */
    @ApiOperation("供应商分类信息")
    @PreAuthorize("@ss.hasPermi('supplier:clas:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierClassList srmSupplierClassList) {
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
    public void export(HttpServletResponse response, SrmSupplierClassList srmSupplierClassList) {
        List<SrmSupplierClassList> list = srmSupplierClassListService.selectSrmSupplierClassListList(srmSupplierClassList);
        ExcelUtil<SrmSupplierClassList> util = new ExcelUtil<SrmSupplierClassList>(SrmSupplierClassList.class);
        util.exportExcel(response, list, "供应商分类数据");
    }

    /**
     * 获取供应商分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmSupplierClassListService.selectSrmSupplierClassListById(id));
    }

    /**
     * 新增供应商分类
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:add')")
    @Log(title = "供应商分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierClassList srmSupplierClassList) {
        return toAjax(srmSupplierClassListService.insertSrmSupplierClassList(srmSupplierClassList));
    }

    /**
     * 修改供应商分类
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:edit')")
    @Log(title = "供应商分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierClassList srmSupplierClassList) {
        return toAjax(srmSupplierClassListService.updateSrmSupplierClassList(srmSupplierClassList));
    }

    /**
     * 删除供应商分类
     */
    @PreAuthorize("@ss.hasPermi('supplier:clas:remove')")
    @Log(title = "供应商分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmSupplierClassListService.deleteSrmSupplierClassListByIds(ids));
    }

    /**
     * 同步供应商信息
     */
    @GetMapping("/sync")
    public AjaxResult dataSync() {
        List<SrmSupplierClassList> srmSupplierClassLists = srmSupplierClassListService.querySupplierInfo();
        return AjaxResult.success(srmSupplierClassLists);
    }

    /**
     * 获取分类列表
     */
    @GetMapping("/listDef")
    public AjaxResult listDef() {
        List<SrmSupplierClassDefinition> classDefinitions = classDefinitionService.selectSrmSupplierClassDefinitionList(null);
        log.debug("classDefinitions:{}", classDefinitions);
        return AjaxResult.success(classDefinitions);
    }

    /**
     * 分配供应商
     */
    @PostMapping("/assignationSupplier")
    public AjaxResult assignationSupplier(@RequestBody SrmSupplierClassList srmSupplierClassList) {
        srmSupplierClassListService.insertClass(srmSupplierClassList);
        return AjaxResult.success();
    }
}
