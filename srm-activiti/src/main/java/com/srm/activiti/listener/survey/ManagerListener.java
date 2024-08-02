package com.srm.activiti.listener.survey;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class ManagerListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        if (EVENTNAME_CREATE.equals(delegateTask.getEventName())) {
            delegateTask.setAssignee("admin");
        }
    }
}
