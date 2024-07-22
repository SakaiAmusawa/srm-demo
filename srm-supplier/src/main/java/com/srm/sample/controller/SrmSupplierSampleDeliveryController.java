package com.srm.sample.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.domain.entity.SysDept;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.sample.domain.SrmSupplierSampleDelivery;
import com.srm.sample.service.ISrmSupplierSampleDeliveryService;
import com.srm.supplier.domain.SrmSupplierContactInformation;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.service.ISrmSupplierInformationService;
import com.srm.system.service.ISysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商送样Controller
 *
 * @author ruoyi
 * @date 2024-07-19
 */
@Slf4j
@RestController
@RequestMapping("/sample/sample_delivery")
public class SrmSupplierSampleDeliveryController extends BaseController {
    @Autowired
    private ISrmSupplierSampleDeliveryService srmSupplierSampleDeliveryService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISrmSupplierInformationService srmSupplierInformationService;

    /**
     * 查询供应商送样列表
     */
    @PreAuthorize("@ss.hasPermi('sample:sample_delivery:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        startPage();
        List<SrmSupplierSampleDelivery> list = srmSupplierSampleDeliveryService.selectSrmSupplierSampleDeliveryList(srmSupplierSampleDelivery);
        return getDataTable(list);
    }

    /**
     * 导出供应商送样列表
     */
    @PreAuthorize("@ss.hasPermi('sample:sample_delivery:export')")
    @Log(title = "供应商送样", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        List<SrmSupplierSampleDelivery> list = srmSupplierSampleDeliveryService.selectSrmSupplierSampleDeliveryList(srmSupplierSampleDelivery);
        ExcelUtil<SrmSupplierSampleDelivery> util = new ExcelUtil<SrmSupplierSampleDelivery>(SrmSupplierSampleDelivery.class);
        util.exportExcel(response, list, "供应商送样数据");
    }

    /**
     * 获取供应商送样详细信息
     */
    @PreAuthorize("@ss.hasPermi('sample:sample_delivery:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmSupplierSampleDeliveryService.selectSrmSupplierSampleDeliveryById(id));
    }

    /**
     * 新增供应商送样
     */
    @PreAuthorize("@ss.hasPermi('sample:sample_delivery:add')")
    @Log(title = "供应商送样", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        return toAjax(srmSupplierSampleDeliveryService.insertSrmSupplierSampleDelivery(srmSupplierSampleDelivery));
    }

    /**
     * 修改供应商送样
     */
    @PreAuthorize("@ss.hasPermi('sample:sample_delivery:edit')")
    @Log(title = "供应商送样", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierSampleDelivery srmSupplierSampleDelivery) {
        return toAjax(srmSupplierSampleDeliveryService.updateSrmSupplierSampleDelivery(srmSupplierSampleDelivery));
    }

    /**
     * 删除供应商送样
     */
    @PreAuthorize("@ss.hasPermi('sample:sample_delivery:remove')")
    @Log(title = "供应商送样", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmSupplierSampleDeliveryService.deleteSrmSupplierSampleDeliveryByIds(ids));
    }

    @GetMapping("companyList")
    public AjaxResult getCompanyList() {
        List<SysDept> depts = deptService.selectDeptList(null);
        return success(depts);
    }

    @GetMapping("/listSup")
    public AjaxResult listSup() {
        List<SrmSupplierInformation> srmSupplierInformations = srmSupplierInformationService.selectSrmSupplierInformationList(null);
        return AjaxResult.success(srmSupplierInformations);
    }

    @GetMapping("/getSupplierDetail/{id}")
    public AjaxResult getSupplierDetail(@PathVariable Long id) {
        SrmSupplierContactInformation srmSupplierContactInformation = srmSupplierSampleDeliveryService.selectContactById(id);
        log.debug("srmSupplierContactInformation:{}", srmSupplierContactInformation);
        return AjaxResult.success(srmSupplierContactInformation);
    }
}
