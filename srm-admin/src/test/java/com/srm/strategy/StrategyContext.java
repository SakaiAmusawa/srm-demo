package com.srm.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StrategyContext {

    private DemoStrategy demoStrategy;

    public void setDemoStrategy(DemoStrategy demoStrategy) {
        this.demoStrategy = demoStrategy;
    }

    public void pay(int amount) {
        demoStrategy.pay(amount);
    }
}
