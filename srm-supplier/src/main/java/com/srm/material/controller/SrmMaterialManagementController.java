package com.srm.material.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.material.domain.SrmMaterialManagement;
import com.srm.material.service.ISrmMaterialManagementService;
import com.srm.supplier.domain.SrmCategoryDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 物料管理Controller
 *
 * @author ruoyi
 * @date 2024-07-18
 */
@Slf4j
@RestController
@RequestMapping("/material/material")
public class SrmMaterialManagementController extends BaseController {
    @Autowired
    private ISrmMaterialManagementService srmMaterialManagementService;

    /**
     * 查询物料管理列表
     */
    @PreAuthorize("@ss.hasPermi('material:material:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmMaterialManagement srmMaterialManagement) {
        startPage();
        List<SrmMaterialManagement> list = srmMaterialManagementService.selectSrmMaterialManagementList(srmMaterialManagement);
        return getDataTable(list);
    }

    /**
     * 导出物料管理列表
     */
    @PreAuthorize("@ss.hasPermi('material:material:export')")
    @Log(title = "物料管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmMaterialManagement srmMaterialManagement) {
        List<SrmMaterialManagement> list = srmMaterialManagementService.selectSrmMaterialManagementList(srmMaterialManagement);
        ExcelUtil<SrmMaterialManagement> util = new ExcelUtil<SrmMaterialManagement>(SrmMaterialManagement.class);
        util.exportExcel(response, list, "物料管理数据");
    }

    /**
     * 获取物料管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:material:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmMaterialManagementService.selectSrmMaterialManagementById(id));
    }

    /**
     * 新增物料管理
     */
    @PreAuthorize("@ss.hasPermi('material:material:add')")
    @Log(title = "物料管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmMaterialManagement srmMaterialManagement) {
        return toAjax(srmMaterialManagementService.insertSrmMaterialManagement(srmMaterialManagement));
    }

    /**
     * 修改物料管理
     */
    @PreAuthorize("@ss.hasPermi('material:material:edit')")
    @Log(title = "物料管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmMaterialManagement srmMaterialManagement) {
        return toAjax(srmMaterialManagementService.updateSrmMaterialManagement(srmMaterialManagement));
    }

    /**
     * 删除物料管理
     */
    @PreAuthorize("@ss.hasPermi('material:material:remove')")
    @Log(title = "物料管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmMaterialManagementService.deleteSrmMaterialManagementByIds(ids));
    }

    @GetMapping("/categoryList")
    public AjaxResult categoryList() {
        List<SrmCategoryDefinition> categoryList = srmMaterialManagementService.selectCategoryList();
        log.debug("categoryList:{}", categoryList());
        return AjaxResult.success(categoryList);
    }
}
