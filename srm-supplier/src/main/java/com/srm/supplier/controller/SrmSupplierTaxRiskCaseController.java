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
import com.srm.supplier.domain.SrmSupplierTaxRiskCase;
import com.srm.supplier.service.ISrmSupplierTaxRiskCaseService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商税收违法风险Controller
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
@RestController
@RequestMapping("/risk/risk")
public class SrmSupplierTaxRiskCaseController extends BaseController
{
    @Autowired
    private ISrmSupplierTaxRiskCaseService srmSupplierTaxRiskCaseService;

    /**
     * 查询供应商税收违法风险列表
     */
    @PreAuthorize("@ss.hasPermi('risk:risk:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        startPage();
        List<SrmSupplierTaxRiskCase> list = srmSupplierTaxRiskCaseService.selectSrmSupplierTaxRiskCaseList(srmSupplierTaxRiskCase);
        return getDataTable(list);
    }

    /**
     * 导出供应商税收违法风险列表
     */
    @PreAuthorize("@ss.hasPermi('risk:risk:export')")
    @Log(title = "供应商税收违法风险", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        List<SrmSupplierTaxRiskCase> list = srmSupplierTaxRiskCaseService.selectSrmSupplierTaxRiskCaseList(srmSupplierTaxRiskCase);
        ExcelUtil<SrmSupplierTaxRiskCase> util = new ExcelUtil<SrmSupplierTaxRiskCase>(SrmSupplierTaxRiskCase.class);
        util.exportExcel(response, list, "供应商税收违法风险数据");
    }

    /**
     * 获取供应商税收违法风险详细信息
     */
    @PreAuthorize("@ss.hasPermi('risk:risk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierTaxRiskCaseService.selectSrmSupplierTaxRiskCaseById(id));
    }

    /**
     * 新增供应商税收违法风险
     */
    @PreAuthorize("@ss.hasPermi('risk:risk:add')")
    @Log(title = "供应商税收违法风险", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        return toAjax(srmSupplierTaxRiskCaseService.insertSrmSupplierTaxRiskCase(srmSupplierTaxRiskCase));
    }

    /**
     * 修改供应商税收违法风险
     */
    @PreAuthorize("@ss.hasPermi('risk:risk:edit')")
    @Log(title = "供应商税收违法风险", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierTaxRiskCase srmSupplierTaxRiskCase)
    {
        return toAjax(srmSupplierTaxRiskCaseService.updateSrmSupplierTaxRiskCase(srmSupplierTaxRiskCase));
    }

    /**
     * 删除供应商税收违法风险
     */
    @PreAuthorize("@ss.hasPermi('risk:risk:remove')")
    @Log(title = "供应商税收违法风险", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierTaxRiskCaseService.deleteSrmSupplierTaxRiskCaseByIds(ids));
    }
}
