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
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.service.ISrmSupplierInformationService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商信息Controller
 * 
 * @author sakai
 * @date 2024-07-01
 */
@RestController
@RequestMapping("/supplier_register/information")
public class SrmSupplierInformationController extends BaseController
{
    @Autowired
    private ISrmSupplierInformationService srmSupplierInformationService;

    /**
     * 查询供应商信息列表
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierInformation srmSupplierInformation)
    {
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
    public void export(HttpServletResponse response, SrmSupplierInformation srmSupplierInformation)
    {
        List<SrmSupplierInformation> list = srmSupplierInformationService.selectSrmSupplierInformationList(srmSupplierInformation);
        ExcelUtil<SrmSupplierInformation> util = new ExcelUtil<SrmSupplierInformation>(SrmSupplierInformation.class);
        util.exportExcel(response, list, "供应商信息数据");
    }

    /**
     * 获取供应商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierInformationService.selectSrmSupplierInformationById(id));
    }

    /**
     * 新增供应商信息
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:add')")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierInformation srmSupplierInformation)
    {
        return toAjax(srmSupplierInformationService.insertSrmSupplierInformation(srmSupplierInformation));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:edit')")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierInformation srmSupplierInformation)
    {
        return toAjax(srmSupplierInformationService.updateSrmSupplierInformation(srmSupplierInformation));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize("@ss.hasPermi('supplier_register:information:remove')")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierInformationService.deleteSrmSupplierInformationByIds(ids));
    }

}
