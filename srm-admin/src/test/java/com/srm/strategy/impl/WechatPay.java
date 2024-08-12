package com.srm.strategy.impl;

import com.srm.strategy.DemoStrategy;

public class WechatPay implements DemoStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("微信支付" + amount);
    }
}
