package com.srm.activiti.listener;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

@Slf4j
public class FirstListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        log.debug("监听器被执行了......");
        if (EVENTNAME_CREATE.equals(delegateTask.getEventName())) {
            //表示创建事件被触发了
            delegateTask.setAssignee("sakai");
        }
    }
}
