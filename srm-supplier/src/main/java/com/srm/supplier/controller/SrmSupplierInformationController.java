package com.srm.supplier.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.domain.param.ChangeRegStatus;
import com.srm.supplier.service.ISrmSupplierInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商信息Controller
 *
 * @author sakai
 * @date 2024-07-01
 */
@Api(tags = "供应商")
@RestController
@RequestMapping("/supplier_register/information")
@Slf4j
public class SrmSupplierInformationController extends BaseController {
    @Autowired
    private ISrmSupplierInformationService srmSupplierInformationService;

    /**
     * 查询供应商信息列表
     */
    @ApiOperation("查询供应商信息列表")
    @PreAuthorize("@ss.hasPermi('supplier_register:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierInformation srmSupplierInformation) {
        startPage();
        List<SrmSupplierInformation> list = srmSupplierInformationService.selectSrmSupplierInformationList(srmSupplierInformation);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:export')")
    @Log(title = "供应商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierInformation srmSupplierInformation) {
        List<SrmSupplierInformation> list = srmSupplierInformationService.selectSrmSupplierInformationList(srmSupplierInformation);
        ExcelUtil<SrmSupplierInformation> util = new ExcelUtil<SrmSupplierInformation>(SrmSupplierInformation.class);
        util.exportExcel(response, list, "供应商信息数据");
    }

    /**
     * 获取供应商信息详细信息
     */
    @ApiOperation("获取供应商信息详细信息")
    @PreAuthorize("@ss.hasPermi('supplier_register:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmSupplierInformationService.selectSrmSupplierInformationById(id));
    }

    /**
     * 新增供应商信息
     */
    @ApiOperation("供应商注册")
    @PreAuthorize("@ss.hasPermi('supplier_register:information:add')")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierInformation srmSupplierInformation) {
        log.debug("srmSupplierInformation:{}", srmSupplierInformation);
        return toAjax(srmSupplierInformationService.insertSrmSupplierInformation(srmSupplierInformation));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:edit')")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierInformation srmSupplierInformation) {
        return toAjax(srmSupplierInformationService.updateSrmSupplierInformation(srmSupplierInformation));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:remove')")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmSupplierInformationService.deleteSrmSupplierInformationByIds(ids));
    }

    @ApiOperation("注册状态修改")
    @Log(title = "供应商注册状态修改", businessType = BusinessType.UPDATE)
    @PostMapping("/changeRegStatus")
    public AjaxResult changeRegStatus(@RequestBody ChangeRegStatus changeRegStatus) {
        log.debug("changeStatus:{}", changeRegStatus);
        srmSupplierInformationService.changeRegStatusById(changeRegStatus);
        return AjaxResult.success();
    }

}
