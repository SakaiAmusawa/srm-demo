package com.srm.unity.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.unity.domain.SrmUnitDef;
import com.srm.unity.domain.SrmUnitTypeDefinition;
import com.srm.unity.service.ISrmUnitDefService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 计量单位定义Controller
 *
 * @author ruoyi
 * @date 2024-07-18
 */
@Slf4j
@RestController
@RequestMapping("/unity/unity_def")
public class SrmUnitDefController extends BaseController {
    @Autowired
    private ISrmUnitDefService srmUnitDefService;

    /**
     * 查询计量单位定义列表
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_def:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmUnitDef srmUnitDef) {
        startPage();
        List<SrmUnitDef> list = srmUnitDefService.selectSrmUnitDefList(srmUnitDef);
        log.debug("list:{}", list);
        return getDataTable(list);
    }

    /**
     * 导出计量单位定义列表
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_def:export')")
    @Log(title = "计量单位定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmUnitDef srmUnitDef) {
        List<SrmUnitDef> list = srmUnitDefService.selectSrmUnitDefList(srmUnitDef);
        ExcelUtil<SrmUnitDef> util = new ExcelUtil<SrmUnitDef>(SrmUnitDef.class);
        util.exportExcel(response, list, "计量单位定义数据");
    }

    /**
     * 获取计量单位定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_def:query')")
    @GetMapping(value = "/{unitCode}")
    public AjaxResult getInfo(@PathVariable("unitCode") Long unitCode) {
        return success(srmUnitDefService.selectSrmUnitDefByUnitCode(unitCode));
    }

    /**
     * 新增计量单位定义
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_def:add')")
    @Log(title = "计量单位定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmUnitDef srmUnitDef) {
        log.debug("srmUnitDef:{}", srmUnitDef);
        return toAjax(srmUnitDefService.insertSrmUnitDef(srmUnitDef));
    }

    /**
     * 修改计量单位定义
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_def:edit')")
    @Log(title = "计量单位定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmUnitDef srmUnitDef) {
        log.debug("srmUnitDef:{}", srmUnitDef);
        return toAjax(srmUnitDefService.updateSrmUnitDef(srmUnitDef));
    }

    /**
     * 删除计量单位定义
     */
    @PreAuthorize("@ss.hasPermi('unity:unity_def:remove')")
    @Log(title = "计量单位定义", businessType = BusinessType.DELETE)
    @DeleteMapping("/{unitCodes}")
    public AjaxResult remove(@PathVariable Long[] unitCodes) {
        return toAjax(srmUnitDefService.deleteSrmUnitDefByUnitCodes(unitCodes));
    }

    @GetMapping("/listUT")
    public AjaxResult listUnitType() {
        List<SrmUnitTypeDefinition> srmUnitTypeDefinition = srmUnitDefService.selectUnitTypeList();
        return AjaxResult.success(srmUnitTypeDefinition);
    }
}
