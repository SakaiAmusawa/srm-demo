package com.srm.supply_anagement.controller;

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
import com.srm.supply_anagement.domain.SrmSupplyManagement;
import com.srm.supply_anagement.service.ISrmSupplyManagementService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供货管理Controller
 * 
 * @author sakai
 * @date 2024-07-17
 */
@RestController
@RequestMapping("/supply_anagement/supply_anagement")
public class SrmSupplyManagementController extends BaseController
{
    @Autowired
    private ISrmSupplyManagementService srmSupplyManagementService;

    /**
     * 查询供货管理列表
     */
    @PreAuthorize("@ss.hasPermi('supply_anagement:supply_anagement:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplyManagement srmSupplyManagement)
    {
        startPage();
        List<SrmSupplyManagement> list = srmSupplyManagementService.selectSrmSupplyManagementList(srmSupplyManagement);
        return getDataTable(list);
    }

    /**
     * 导出供货管理列表
     */
    @PreAuthorize("@ss.hasPermi('supply_anagement:supply_anagement:export')")
    @Log(title = "供货管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplyManagement srmSupplyManagement)
    {
        List<SrmSupplyManagement> list = srmSupplyManagementService.selectSrmSupplyManagementList(srmSupplyManagement);
        ExcelUtil<SrmSupplyManagement> util = new ExcelUtil<SrmSupplyManagement>(SrmSupplyManagement.class);
        util.exportExcel(response, list, "供货管理数据");
    }

    /**
     * 获取供货管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('supply_anagement:supply_anagement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplyManagementService.selectSrmSupplyManagementById(id));
    }

    /**
     * 新增供货管理
     */
    @PreAuthorize("@ss.hasPermi('supply_anagement:supply_anagement:add')")
    @Log(title = "供货管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplyManagement srmSupplyManagement)
    {
        return toAjax(srmSupplyManagementService.insertSrmSupplyManagement(srmSupplyManagement));
    }

    /**
     * 修改供货管理
     */
    @PreAuthorize("@ss.hasPermi('supply_anagement:supply_anagement:edit')")
    @Log(title = "供货管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplyManagement srmSupplyManagement)
    {
        return toAjax(srmSupplyManagementService.updateSrmSupplyManagement(srmSupplyManagement));
    }

    /**
     * 删除供货管理
     */
    @PreAuthorize("@ss.hasPermi('supply_anagement:supply_anagement:remove')")
    @Log(title = "供货管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplyManagementService.deleteSrmSupplyManagementByIds(ids));
    }
}
