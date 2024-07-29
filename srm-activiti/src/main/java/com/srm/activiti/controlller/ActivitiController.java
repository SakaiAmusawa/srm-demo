package com.srm.activiti.controlller;

import com.srm.activiti.domain.dto.TaskMapDTO;
import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/activiti/demo")
public class ActivitiController {

    @Autowired
    private IActivitiService activitiService;

    /**
     * 部署流程
     */
    @PostMapping("/apply")
    public AjaxResult apply() {
        activitiService.apply();
        return AjaxResult.success();
    }

    /**
     * 发起实例
     * @param supplierId 供应商ID
     * @return 当前任务ID、当前任务代办人
     */
    @PostMapping("/startProcess/{supplierId}")
    public AjaxResult startProcess(@PathVariable("supplierId") Long supplierId) {
        StartProcessVO startProcessVO = activitiService.startProcess(supplierId);
        return AjaxResult.success("操作成功", startProcessVO);
    }

    /**
     * 查看当前用户的所有待办事项
     *
     * @return 待办事项列表
     */
    @GetMapping("/getAllTask")
    public AjaxResult getAllTask() {
        List<TaskVO> taskVOList = activitiService.getAllTask();
        return AjaxResult.success(taskVOList);
    }

    /**
     * 审批通过
     *
     * @return code200
     */
    @PostMapping("/completeTaskById/{taskId}")
    public AjaxResult completeTask(@PathVariable("taskId") String taskId) {
        activitiService.completeTask(taskId);
        return AjaxResult.success();
    }

    @PostMapping("/taskReject/{taskId}")
    public AjaxResult taskReject(@PathVariable String taskId) {
        activitiService.taskReject(taskId);
        return AjaxResult.success();
    }

    @PostMapping("/saveTask")
    public AjaxResult saveTaskMap(@RequestBody TaskMapDTO taskMapDTO) {
        log.debug("taskMapDTO:{}", taskMapDTO);
        return AjaxResult.success();
    }

    @GetMapping("/getTaskBySupplierId/{supplierId}")
    public AjaxResult getTaskBySupplierId(@PathVariable Long supplierId) {
        SupTaskVO supTaskVO = activitiService.getSupTaskBySupplierId(supplierId);
        return AjaxResult.success(supTaskVO);
    }

    @GetMapping("/getActiveUser")
    public AjaxResult getActiveUser() {

        //获取当前登录用户
        String username = SecurityUtils.getUsername();

        log.debug("username:{}", username);

        return AjaxResult.success("以获取当前用户", username);
    }

    @GetMapping("/getBpmn/{supplierId}")
    public void getBpmn(@PathVariable Long supplierId, HttpServletResponse response) throws IOException {
        log.debug("该方法执行了.............");
        InputStream stream = activitiService.getBpmn(supplierId);
        if (stream == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType("image/png");
        try (OutputStream out = response.getOutputStream()) {
            IOUtils.copy(stream, out);
            out.flush();
        }
    }

}
