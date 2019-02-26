package com.developer.jdk8.designpatterns.observer;

import java.util.Objects;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 15:19
 * @description:具体主题角色，这种是观察者模式中的推模型
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        if (Objects.isNull(state)) {
            return "主题状态为空";
        }
        return state;
    }

    public void changeState(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);

        this.nodifyObservers(newState);
    }
}
