package com.srm.activiti.listener.survey;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

@Slf4j
@Data
public class SupplierListener implements TaskListener {
    private static String supplierName;

    public SupplierListener(String supplierName) {
        SupplierListener.supplierName = supplierName;
    }

    public SupplierListener() {

    }

    @Override
    public void notify(DelegateTask delegateTask) {
        log.debug("监听器执行了......");
        if (EVENTNAME_CREATE.equals(delegateTask.getEventName())) {
            delegateTask.setAssignee(supplierName);
        }
    }

}
