package com.srm.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SrmSupplierActivitiTest {
    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void surveyDeployment() {

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("flow/supplier_life_survey.bpmn20.xml")
                .name("调查表流程")
                .deploy();
        System.out.println("deployment.getId() = " + deployment.getId());
        System.out.println("deployment.getName() = " + deployment.getName());
    }

}
