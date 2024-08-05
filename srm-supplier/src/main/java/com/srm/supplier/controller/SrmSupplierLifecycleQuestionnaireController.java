package com.srm.supplier.controller;

import com.srm.common.annotation.Log;
import com.srm.common.core.controller.BaseController;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.core.domain.entity.SysDictData;
import com.srm.common.core.page.TableDataInfo;
import com.srm.common.enums.BusinessType;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.supplier.domain.SrmSupplierBasicInformation;
import com.srm.supplier.domain.SrmSupplierInformation;
import com.srm.supplier.domain.SrmSupplierLifecycleQuestionnaire;
import com.srm.supplier.service.ISrmSupplierInformationService;
import com.srm.supplier.service.ISrmSupplierLifecycleQuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商生命周期调查Controller
 *
 * @author ruoyi
 * @date 2024-07-31
 */
@Slf4j
@RestController
@RequestMapping("/questionnaire/questionnaire")
public class SrmSupplierLifecycleQuestionnaireController extends BaseController {
    @Autowired
    private ISrmSupplierLifecycleQuestionnaireService srmSupplierLifecycleQuestionnaireService;
    @Autowired
    private ISrmSupplierInformationService srmSupplierInformationService;

    /**
     * 查询供应商生命周期调查列表
     */
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        startPage();
        List<SrmSupplierLifecycleQuestionnaire> list = srmSupplierLifecycleQuestionnaireService.selectSrmSupplierLifecycleQuestionnaireList(srmSupplierLifecycleQuestionnaire);
        return getDataTable(list);
    }

    /**
     * 导出供应商生命周期调查列表
     */
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:export')")
    @Log(title = "供应商生命周期调查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        List<SrmSupplierLifecycleQuestionnaire> list = srmSupplierLifecycleQuestionnaireService.selectSrmSupplierLifecycleQuestionnaireList(srmSupplierLifecycleQuestionnaire);
        ExcelUtil<SrmSupplierLifecycleQuestionnaire> util = new ExcelUtil<SrmSupplierLifecycleQuestionnaire>(SrmSupplierLifecycleQuestionnaire.class);
        util.exportExcel(response, list, "供应商生命周期调查数据");
    }

    /**
     * 获取供应商生命周期调查详细信息
     */
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(srmSupplierLifecycleQuestionnaireService.selectSrmSupplierLifecycleQuestionnaireById(id));
    }

    /**
     * 新增供应商生命周期调查
     */
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:add')")
    @Log(title = "供应商生命周期调查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        return toAjax(srmSupplierLifecycleQuestionnaireService.insertSrmSupplierLifecycleQuestionnaire(srmSupplierLifecycleQuestionnaire));
    }

    /**
     * 修改供应商生命周期调查
     */
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:edit')")
    @Log(title = "供应商生命周期调查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSupplierLifecycleQuestionnaire srmSupplierLifecycleQuestionnaire) {
        return toAjax(srmSupplierLifecycleQuestionnaireService.updateSrmSupplierLifecycleQuestionnaire(srmSupplierLifecycleQuestionnaire));
    }

    /**
     * 删除供应商生命周期调查
     */
    @PreAuthorize("@ss.hasPermi('questionnaire:questionnaire:remove')")
    @Log(title = "供应商生命周期调查", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(srmSupplierLifecycleQuestionnaireService.deleteSrmSupplierLifecycleQuestionnaireByIds(ids));
    }

    @GetMapping("/listSupplierInfo")
    public AjaxResult getSupplierInfo() {
        List<SrmSupplierInformation> srmSupplierInformations = srmSupplierInformationService.selectActiveSupplierInfo();
        return AjaxResult.success(srmSupplierInformations);
    }

    @GetMapping("/dictDetail/{dictKey}")
    public AjaxResult getDictDetail(@PathVariable String dictKey) {
        List<SysDictData> dictData = srmSupplierLifecycleQuestionnaireService.selectDictDetail(dictKey);
        return AjaxResult.success(dictData);
    }

}
