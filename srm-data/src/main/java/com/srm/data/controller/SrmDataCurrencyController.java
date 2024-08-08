package com.srm.data.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.data.domain.SrmDataCurrency;
import com.srm.data.service.ISrmDataCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 货币定义Controller
 *
 * @author sakai
 * @date 2024-08-08
 */
@RestController
@RequestMapping("/data/currency")
public class SrmDataCurrencyController extends BaseController {
    @Autowired
    private ISrmDataCurrencyService srmDataCurrencyService;

    /**
     * 查询货币定义列表
     */
    @PreAuthorize("@ss.hasPermi('data:currency:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmDataCurrency srmDataCurrency) {
        startPage();
        List<SrmDataCurrency> list = srmDataCurrencyService.selectSrmDataCurrencyList(srmDataCurrency);
        return getDataTable(list);
    }

    /**
     * 导出货币定义列表
     */
    @PreAuthorize("@ss.hasPermi('data:currency:export')")
    @Log(title = "货币定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmDataCurrency srmDataCurrency) {
        List<SrmDataCurrency> list = srmDataCurrencyService.selectSrmDataCurrencyList(srmDataCurrency);
        ExcelUtil<SrmDataCurrency> util = new ExcelUtil<SrmDataCurrency>(SrmDataCurrency.class);
        util.exportExcel(response, list, "货币定义数据");
    }

    /**
     * 获取货币定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:currency:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmDataCurrencyService.selectSrmDataCurrencyById(id));
    }

    /**
     * 新增货币定义
     */
    @PreAuthorize("@ss.hasPermi('data:currency:add')")
    @Log(title = "货币定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmDataCurrency srmDataCurrency) {
        return toAjax(srmDataCurrencyService.insertSrmDataCurrency(srmDataCurrency));
    }

    /**
     * 修改货币定义
     */
    @PreAuthorize("@ss.hasPermi('data:currency:edit')")
    @Log(title = "货币定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmDataCurrency srmDataCurrency) {
        return toAjax(srmDataCurrencyService.updateSrmDataCurrency(srmDataCurrency));
    }

    /**
     * 删除货币定义
     */
    @PreAuthorize("@ss.hasPermi('data:currency:remove')")
    @Log(title = "货币定义", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmDataCurrencyService.deleteSrmDataCurrencyByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('data:currency:list')")
    @GetMapping("/listAll")
    public AjaxResult listAllCurrency() {
        List<SrmDataCurrency> currencyList = srmDataCurrencyService.selectSrmDataCurrencyList(null);
        return AjaxResult.success(currencyList);
    }
}
