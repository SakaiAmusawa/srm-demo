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
import com.srm.supplier.domain.SrmSupplierOperateRisk;
import com.srm.supplier.service.ISrmSupplierOperateRiskService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 供应商经营风险记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-23
 */
@RestController
@RequestMapping("/operate_risk/operate_risk")
public class SrmSupplierOperateRiskController extends BaseController
{
    @Autowired
    private ISrmSupplierOperateRiskService srmSupplierOperateRiskService;

    /**
     * 查询供应商经营风险记录列表
     */
    @PreAuthorize("@ss.hasPermi('operate_risk:operate_risk:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        startPage();
        List<SrmSupplierOperateRisk> list = srmSupplierOperateRiskService.selectSrmSupplierOperateRiskList(srmSupplierOperateRisk);
        return getDataTable(list);
    }

    /**
     * 导出供应商经营风险记录列表
     */
    @PreAuthorize("@ss.hasPermi('operate_risk:operate_risk:export')")
    @Log(title = "供应商经营风险记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        List<SrmSupplierOperateRisk> list = srmSupplierOperateRiskService.selectSrmSupplierOperateRiskList(srmSupplierOperateRisk);
        ExcelUtil<SrmSupplierOperateRisk> util = new ExcelUtil<SrmSupplierOperateRisk>(SrmSupplierOperateRisk.class);
        util.exportExcel(response, list, "供应商经营风险记录数据");
    }

    /**
     * 获取供应商经营风险记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('operate_risk:operate_risk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSupplierOperateRiskService.selectSrmSupplierOperateRiskById(id));
    }

    /**
     * 新增供应商经营风险记录
     */
    @PreAuthorize("@ss.hasPermi('operate_risk:operate_risk:add')")
    @Log(title = "供应商经营风险记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        return toAjax(srmSupplierOperateRiskService.insertSrmSupplierOperateRisk(srmSupplierOperateRisk));
    }

    /**
     * 修改供应商经营风险记录
     */
    @PreAuthorize("@ss.hasPermi('operate_risk:operate_risk:edit')")
    @Log(title = "供应商经营风险记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierOperateRisk srmSupplierOperateRisk)
    {
        return toAjax(srmSupplierOperateRiskService.updateSrmSupplierOperateRisk(srmSupplierOperateRisk));
    }

    /**
     * 删除供应商经营风险记录
     */
    @PreAuthorize("@ss.hasPermi('operate_risk:operate_risk:remove')")
    @Log(title = "供应商经营风险记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSupplierOperateRiskService.deleteSrmSupplierOperateRiskByIds(ids));
    }
}
