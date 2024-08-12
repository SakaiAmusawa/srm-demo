package com.srm.strategy.impl;

import com.srm.strategy.DemoStrategy;

public class AliPay implements DemoStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("支付宝支付了：" + amount);
    }
}
