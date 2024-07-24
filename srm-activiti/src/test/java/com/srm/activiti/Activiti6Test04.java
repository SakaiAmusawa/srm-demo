package com.srm.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Activiti6Test04 {

    /**
     * 流程部署操作
     */

    @Test
    public void test1() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("flow/access_approval.bpmn20.xml")
                .name("请假流程-监听器")
                .deploy();
        System.out.println("deployment.getId() = " + deployment.getId());
        System.out.println("deployment.getName() = " + deployment.getName());
    }

    /**
     * 查询流程部署相关信息
     */
    @Test
    public void test2() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : processDefinitions) {
            System.out.println("processDefinition.getId() = " + processDefinition.getId());
            System.out.println("processDefinition.getName() = " + processDefinition.getName());
            System.out.println("processDefinition.getDescription() = " + processDefinition.getDescription());
        }

    }

    /**
     * 发起一个流程
     */
    @Test
    public void test3() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //发起流程
        RuntimeService runtimeService = engine.getRuntimeService();

        Map<String, Object> assigneeMap = new HashMap<>();
        assigneeMap.put("manager", "admin");

        //通过流程定义ID来启动流程，获取流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("access_approval:1:77504", assigneeMap);
        System.out.println("processInstance.getId() = " + processInstance.getId());
        System.out.println("processInstance.getDeploymentId() = " + processInstance.getDeploymentId());
    }

    /**
     * 代办的查询
     */
    @Test
    public void test4() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        //对应act_ru_task这张表的记录
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("zjw").list();
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                String id = task.getId();
                System.out.println("id = " + id);
                String name = task.getName();
                System.out.println("name = " + name);
            }
        } else {
            System.out.println("没有待办任务");
        }
    }

    /**
     * 任务审批
     */
    @Test
    public void test5() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("admin").list();
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                String id = task.getId();
                System.out.println("id = " + id);
                String name = task.getName();
                System.out.println("name = " + name);

                taskService.complete(task.getId());
            }
        } else {
            System.out.println("没有待办任务");
        }
    }
}