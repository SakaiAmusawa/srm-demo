package com.srm.system.controller;

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
import com.srm.system.domain.SrmSupplierContactInformation;
import com.srm.system.service.ISrmSupplierContactInformationService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商联系人信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-01
 */
@RestController
@RequestMapping("/system/information")
public class SrmSupplierContactInformationController extends BaseController
{
    @Autowired
    private ISrmSupplierContactInformationService srmSupplierContactInformationService;

    /**
     * 查询供应商联系人信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierContactInformation srmSupplierContactInformation)
    {
        startPage();
        List<SrmSupplierContactInformation> list = srmSupplierContactInformationService.selectSrmSupplierContactInformationList(srmSupplierContactInformation);
        return getDataTable(list);
    }

    /**
     * 导出供应商联系人信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:export')")
    @Log(title = "供应商联系人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierContactInformation srmSupplierContactInformation)
    {
        List<SrmSupplierContactInformation> list = srmSupplierContactInformationService.selectSrmSupplierContactInformationList(srmSupplierContactInformation);
        ExcelUtil<SrmSupplierContactInformation> util = new ExcelUtil<SrmSupplierContactInformation>(SrmSupplierContactInformation.class);
        util.exportExcel(response, list, "供应商联系人信息数据");
    }

    /**
     * 获取供应商联系人信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierContactInformationService.selectSrmSupplierContactInformationById(id));
    }

    /**
     * 新增供应商联系人信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:add')")
    @Log(title = "供应商联系人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierContactInformation srmSupplierContactInformation)
    {
        return toAjax(srmSupplierContactInformationService.insertSrmSupplierContactInformation(srmSupplierContactInformation));
    }

    /**
     * 修改供应商联系人信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:edit')")
    @Log(title = "供应商联系人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierContactInformation srmSupplierContactInformation)
    {
        return toAjax(srmSupplierContactInformationService.updateSrmSupplierContactInformation(srmSupplierContactInformation));
    }

    /**
     * 删除供应商联系人信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:remove')")
    @Log(title = "供应商联系人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierContactInformationService.deleteSrmSupplierContactInformationByIds(ids));
    }
}
