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
import com.srm.supplier.domain.SrmSupplierIllegalRisk;
import com.srm.supplier.service.ISrmSupplierIllegalRiskService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商非法风险记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
@RestController
@RequestMapping("/illegal_risk/illegal_risk")
public class SrmSupplierIllegalRiskController extends BaseController
{
    @Autowired
    private ISrmSupplierIllegalRiskService srmSupplierIllegalRiskService;

    /**
     * 查询供应商非法风险记录列表
     */
    @PreAuthorize("@ss.hasPermi('illegal_risk:illegal_risk:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        startPage();
        List<SrmSupplierIllegalRisk> list = srmSupplierIllegalRiskService.selectSrmSupplierIllegalRiskList(srmSupplierIllegalRisk);
        return getDataTable(list);
    }

    /**
     * 导出供应商非法风险记录列表
     */
    @PreAuthorize("@ss.hasPermi('illegal_risk:illegal_risk:export')")
    @Log(title = "供应商非法风险记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        List<SrmSupplierIllegalRisk> list = srmSupplierIllegalRiskService.selectSrmSupplierIllegalRiskList(srmSupplierIllegalRisk);
        ExcelUtil<SrmSupplierIllegalRisk> util = new ExcelUtil<SrmSupplierIllegalRisk>(SrmSupplierIllegalRisk.class);
        util.exportExcel(response, list, "供应商非法风险记录数据");
    }

    /**
     * 获取供应商非法风险记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('illegal_risk:illegal_risk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierIllegalRiskService.selectSrmSupplierIllegalRiskById(id));
    }

    /**
     * 新增供应商非法风险记录
     */
    @PreAuthorize("@ss.hasPermi('illegal_risk:illegal_risk:add')")
    @Log(title = "供应商非法风险记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        return toAjax(srmSupplierIllegalRiskService.insertSrmSupplierIllegalRisk(srmSupplierIllegalRisk));
    }

    /**
     * 修改供应商非法风险记录
     */
    @PreAuthorize("@ss.hasPermi('illegal_risk:illegal_risk:edit')")
    @Log(title = "供应商非法风险记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierIllegalRisk srmSupplierIllegalRisk)
    {
        return toAjax(srmSupplierIllegalRiskService.updateSrmSupplierIllegalRisk(srmSupplierIllegalRisk));
    }

    /**
     * 删除供应商非法风险记录
     */
    @PreAuthorize("@ss.hasPermi('illegal_risk:illegal_risk:remove')")
    @Log(title = "供应商非法风险记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierIllegalRiskService.deleteSrmSupplierIllegalRiskByIds(ids));
    }
}
