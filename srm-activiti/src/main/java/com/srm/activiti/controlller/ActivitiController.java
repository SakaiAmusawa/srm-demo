package com.srm.activiti.controlller;

import com.srm.activiti.domain.vo.TaskVO;
import com.srm.activiti.service.IActivitiService;
import com.srm.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/completeTask")
    public AjaxResult completeTask() {
        activitiService.completeTask();
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
}
