package com.srm.procurement.requirement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.srm.procurement.requirement.domain.SrmProcurementRequirement;
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
import com.srm.procurement.requirement.service.ISrmProcurementRequirementService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 采购需求Controller
 * 
 * @author Sakai
 * @date 2024-08-07
 */
@RestController
@RequestMapping("/procurement/requirement")
public class SrmProcurementRequirementController extends BaseController
{
    @Autowired
    private ISrmProcurementRequirementService srmProcurementRequirementService;

    /**
     * 查询采购需求列表
     */
    @PreAuthorize("@ss.hasPermi('procurement:requirement:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmProcurementRequirement srmProcurementRequirement)
    {
        startPage();
        List<SrmProcurementRequirement> list = srmProcurementRequirementService.selectSrmProcurementRequirementList(srmProcurementRequirement);
        return getDataTable(list);
    }

    /**
     * 导出采购需求列表
     */
    @PreAuthorize("@ss.hasPermi('procurement:requirement:export')")
    @Log(title = "采购需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmProcurementRequirement srmProcurementRequirement)
    {
        List<SrmProcurementRequirement> list = srmProcurementRequirementService.selectSrmProcurementRequirementList(srmProcurementRequirement);
        ExcelUtil<SrmProcurementRequirement> util = new ExcelUtil<SrmProcurementRequirement>(SrmProcurementRequirement.class);
        util.exportExcel(response, list, "采购需求数据");
    }

    /**
     * 获取采购需求详细信息
     */
    @PreAuthorize("@ss.hasPermi('procurement:requirement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmProcurementRequirementService.selectSrmProcurementRequirementById(id));
    }

    /**
     * 新增采购需求
     */
    @PreAuthorize("@ss.hasPermi('procurement:requirement:add')")
    @Log(title = "采购需求", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmProcurementRequirement srmProcurementRequirement)
    {
        return toAjax(srmProcurementRequirementService.insertSrmProcurementRequirement(srmProcurementRequirement));
    }

    /**
     * 修改采购需求
     */
    @PreAuthorize("@ss.hasPermi('procurement:requirement:edit')")
    @Log(title = "采购需求", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmProcurementRequirement srmProcurementRequirement)
    {
        return toAjax(srmProcurementRequirementService.updateSrmProcurementRequirement(srmProcurementRequirement));
    }

    /**
     * 删除采购需求
     */
    @PreAuthorize("@ss.hasPermi('procurement:requirement:remove')")
    @Log(title = "采购需求", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmProcurementRequirementService.deleteSrmProcurementRequirementByIds(ids));
    }
}
