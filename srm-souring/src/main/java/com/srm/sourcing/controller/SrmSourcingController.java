package com.srm.sourcing.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
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
import com.srm.sourcing.domain.SrmSourcing;
import com.srm.sourcing.service.ISrmSourcingService;
import com.srm.common.utils.poi.ExcelUtil;
import com.srm.common.core.page.TableDataInfo;

/**
 * 询价台Controller
 *
 * @author sakai
 * @date 2024-08-12
 */
@Slf4j
@RestController
@RequestMapping("/enquiry/sourcing")
public class SrmSourcingController extends BaseController
{
    @Autowired
    private ISrmSourcingService srmSourcingService;

    /**
     * 查询询价台列表
     */
    @PreAuthorize("@ss.hasPermi('enquiry:sourcing:list')")
    @GetMapping("/list")
    public TableDataInfo list(SrmSourcing srmSourcing)
    {
        startPage();
        List<SrmSourcing> list = srmSourcingService.selectSrmSourcingList(srmSourcing);
        return getDataTable(list);
    }

    /**
     * 导出询价台列表
     */
    @PreAuthorize("@ss.hasPermi('enquiry:sourcing:export')")
    @Log(title = "询价台", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SrmSourcing srmSourcing)
    {
        List<SrmSourcing> list = srmSourcingService.selectSrmSourcingList(srmSourcing);
        ExcelUtil<SrmSourcing> util = new ExcelUtil<SrmSourcing>(SrmSourcing.class);
        util.exportExcel(response, list, "询价台数据");
    }

    /**
     * 获取询价台详细信息
     */
    @PreAuthorize("@ss.hasPermi('enquiry:sourcing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(srmSourcingService.selectSrmSourcingById(id));
    }

    /**
     * 新增询价台
     */
    @PreAuthorize("@ss.hasPermi('enquiry:sourcing:add')")
    @Log(title = "询价台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SrmSourcing srmSourcing)
    {
        return toAjax(srmSourcingService.insertSrmSourcing(srmSourcing));
    }

    /**
     * 修改询价台
     */
    @PreAuthorize("@ss.hasPermi('enquiry:sourcing:edit')")
    @Log(title = "询价台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SrmSourcing srmSourcing)
    {
        return toAjax(srmSourcingService.updateSrmSourcing(srmSourcing));
    }

    /**
     * 删除询价台
     */
    @PreAuthorize("@ss.hasPermi('enquiry:sourcing:remove')")
    @Log(title = "询价台", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(srmSourcingService.deleteSrmSourcingByIds(ids));
    }
}
