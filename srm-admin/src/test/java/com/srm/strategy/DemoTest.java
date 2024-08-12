package com.srm.strategy;

import com.srm.strategy.impl.WechatPay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoTest {

    @Autowired
    private StrategyContext strategyContext;

    @Test
    public void demoTest() {

        strategyContext.setDemoStrategy(new WechatPay());
        strategyContext.pay(1000);

    }

}
