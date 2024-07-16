package com.srm.inspect.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
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
import com.srm.inspect.domain.SrmSupplierSiteVisit;
import com.srm.inspect.service.ISrmSupplierSiteVisitService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商现场考察Controller
 * 
 * @author sakai
 * @date 2024-07-16
 */
@Slf4j
@RestController
@RequestMapping("/inspect/visit")
public class SrmSupplierSiteVisitController extends BaseController
{
    @Autowired
    private ISrmSupplierSiteVisitService srmSupplierSiteVisitService;

    /**
     * 查询供应商现场考察列表
     */
    @PreAuthorize("@ss.hasPermi('inspect:visit:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierSiteVisit srmSupplierSiteVisit)
    {
        startPage();
        List<SrmSupplierSiteVisit> list = srmSupplierSiteVisitService.selectSrmSupplierSiteVisitList(srmSupplierSiteVisit);
        return getDataTable(list);
    }

    /**
     * 导出供应商现场考察列表
     */
    @PreAuthorize("@ss.hasPermi('inspect:visit:export')")
    @Log(title = "供应商现场考察", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierSiteVisit srmSupplierSiteVisit)
    {
        List<SrmSupplierSiteVisit> list = srmSupplierSiteVisitService.selectSrmSupplierSiteVisitList(srmSupplierSiteVisit);
        ExcelUtil<SrmSupplierSiteVisit> util = new ExcelUtil<SrmSupplierSiteVisit>(SrmSupplierSiteVisit.class);
        util.exportExcel(response, list, "供应商现场考察数据");
    }

    /**
     * 获取供应商现场考察详细信息
     */
    @PreAuthorize("@ss.hasPermi('inspect:visit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierSiteVisitService.selectSrmSupplierSiteVisitById(id));
    }

    /**
     * 新增供应商现场考察
     */
    @PreAuthorize("@ss.hasPermi('inspect:visit:add')")
    @Log(title = "供应商现场考察", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierSiteVisit srmSupplierSiteVisit)
    {
        log.debug("srmSupplierSiteVisit:{}" , srmSupplierSiteVisit);
        return toAjax(srmSupplierSiteVisitService.insertSrmSupplierSiteVisit(srmSupplierSiteVisit));
    }

    /**
     * 修改供应商现场考察
     */
    @PreAuthorize("@ss.hasPermi('inspect:visit:edit')")
    @Log(title = "供应商现场考察", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierSiteVisit srmSupplierSiteVisit)
    {
        return toAjax(srmSupplierSiteVisitService.updateSrmSupplierSiteVisit(srmSupplierSiteVisit));
    }

    /**
     * 删除供应商现场考察
     */
    @PreAuthorize("@ss.hasPermi('inspect:visit:remove')")
    @Log(title = "供应商现场考察", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierSiteVisitService.deleteSrmSupplierSiteVisitByIds(ids));
    }
}
