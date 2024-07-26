package com.srm.activiti.controlller;

import com.srm.activiti.domain.dto.TaskMapDTO;
import com.srm.activiti.domain.vo.StartProcessVO;
import com.srm.activiti.domain.vo.SupTaskVO;
import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.core.domain.AjaxResult;
import com.srm.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/activiti/demo")
public class ActivitiController {

    @Autowired
    private IActivitiService activitiService;

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
     * 审批流程
     *
     * @return code200
     */
    @PostMapping("/completeTaskById/{taskId}")
    public AjaxResult completeTask(@PathVariable("taskId") String taskId) {
        activitiService.completeTask(taskId);
        return AjaxResult.success();
    }

    /**
     * 发起审查
     */
    @PostMapping("/apply")
    public AjaxResult apply() {
        activitiService.apply();
        return AjaxResult.success();
    }

    @PostMapping("/startProcess/{supplierId}")
    public AjaxResult startProcess(@PathVariable("supplierId") Long supplierId) {
        StartProcessVO startProcessVO = activitiService.startProcess(supplierId);
        return AjaxResult.success("操作成功", startProcessVO);
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

}
