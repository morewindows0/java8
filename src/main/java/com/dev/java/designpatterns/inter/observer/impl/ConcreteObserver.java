package com.dev.java.designpatterns.inter.observer.impl;

import java.util.Objects;

import com.dev.java.designpatterns.inter.observer.Observer;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 15:21
 * @description: 具体观察者角色类
 */
public class ConcreteObserver implements Observer {

    /**
     * 观察者的状态
     */
    private String observerState;

    public String getObserverState() {

        if (Objects.isNull(observerState)) {
            return "当前状态为空";
        }
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    @Override
    public void update(String state) {

        observerState = state;
        System.out.println("观察者的状态：" + observerState);
    }
}
