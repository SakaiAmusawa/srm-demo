package com.srm.activiti.listener.survey;

import lombok.Data;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

@Data
public class SupplierListener implements TaskListener {
    private String supplierName;

    @Override
    public void notify(DelegateTask delegateTask) {
        if (EVENTNAME_CREATE.equals(delegateTask.getEventName())) {
            delegateTask.setAssignee(supplierName);
        }
    }

    public String listenSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this.supplierName;
    }
}
