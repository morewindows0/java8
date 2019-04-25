package com.dev.java.designpatterns.inter.strategy.impl;

import com.dev.java.designpatterns.inter.strategy.Strategy;

/**
 * @author: dengxin.chen
 * @date: 2018/11/7 17:40
 * @description: 具体策略类
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyInterface() {
        System.out.println("策略类B");
    }
}
