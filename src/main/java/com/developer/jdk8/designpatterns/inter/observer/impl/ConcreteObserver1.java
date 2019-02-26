package com.developer.jdk8.designpatterns.inter.observer.impl;

import java.util.Objects;

import com.developer.jdk8.designpatterns.inter.observer.Observer1;
import com.developer.jdk8.designpatterns.observer.ConcreteSubject1;
import com.developer.jdk8.designpatterns.observer.Subject1;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 15:21
 * @description: 具体观察者角色类-拉模型
 */
public class ConcreteObserver1 implements Observer1 {

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
    public void update(Subject1 subject) {

        String state = ((ConcreteSubject1) subject).getState();
        observerState = state;
        System.out.println("观察者的状态：" + observerState);
    }
}
