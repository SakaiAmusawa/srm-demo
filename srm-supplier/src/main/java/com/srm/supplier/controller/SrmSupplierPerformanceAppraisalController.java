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
import com.srm.supplier.domain.SrmSupplierPerformanceAppraisal;
import com.srm.supplier.service.ISrmSupplierPerformanceAppraisalService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商绩效考评Controller
 * 
 * @author ruoyi
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/performance_appraisal/appraisal")
public class SrmSupplierPerformanceAppraisalController extends BaseController
{
    @Autowired
    private ISrmSupplierPerformanceAppraisalService srmSupplierPerformanceAppraisalService;

    /**
     * 查询供应商绩效考评列表
     */
    @PreAuthorize("@ss.hasPermi('performance_appraisal:appraisal:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal)
    {
        startPage();
        List<SrmSupplierPerformanceAppraisal> list = srmSupplierPerformanceAppraisalService.selectSrmSupplierPerformanceAppraisalList(srmSupplierPerformanceAppraisal);
        return getDataTable(list);
    }

    /**
     * 导出供应商绩效考评列表
     */
    @PreAuthorize("@ss.hasPermi('performance_appraisal:appraisal:export')")
    @Log(title = "供应商绩效考评", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal)
    {
        List<SrmSupplierPerformanceAppraisal> list = srmSupplierPerformanceAppraisalService.selectSrmSupplierPerformanceAppraisalList(srmSupplierPerformanceAppraisal);
        ExcelUtil<SrmSupplierPerformanceAppraisal> util = new ExcelUtil<SrmSupplierPerformanceAppraisal>(SrmSupplierPerformanceAppraisal.class);
        util.exportExcel(response, list, "供应商绩效考评数据");
    }

    /**
     * 获取供应商绩效考评详细信息
     */
    @PreAuthorize("@ss.hasPermi('performance_appraisal:appraisal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierPerformanceAppraisalService.selectSrmSupplierPerformanceAppraisalById(id));
    }

    /**
     * 新增供应商绩效考评
     */
    @PreAuthorize("@ss.hasPermi('performance_appraisal:appraisal:add')")
    @Log(title = "供应商绩效考评", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal)
    {
        return toAjax(srmSupplierPerformanceAppraisalService.insertSrmSupplierPerformanceAppraisal(srmSupplierPerformanceAppraisal));
    }

    /**
     * 修改供应商绩效考评
     */
    @PreAuthorize("@ss.hasPermi('performance_appraisal:appraisal:edit')")
    @Log(title = "供应商绩效考评", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierPerformanceAppraisal srmSupplierPerformanceAppraisal)
    {
        return toAjax(srmSupplierPerformanceAppraisalService.updateSrmSupplierPerformanceAppraisal(srmSupplierPerformanceAppraisal));
    }

    /**
     * 删除供应商绩效考评
     */
    @PreAuthorize("@ss.hasPermi('performance_appraisal:appraisal:remove')")
    @Log(title = "供应商绩效考评", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierPerformanceAppraisalService.deleteSrmSupplierPerformanceAppraisalByIds(ids));
    }
}
