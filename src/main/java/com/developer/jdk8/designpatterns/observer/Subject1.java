package com.developer.jdk8.designpatterns.observer;

import java.util.List;

import com.developer.jdk8.designpatterns.inter.observer.Observer1;
import com.google.common.collect.Lists;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 15:12
 * @description:抽象主题角色，提供观察者注册和注销的接口-拉模型
 */
public abstract class Subject1 {

    /**
     * 保存注册的观察者对象
     */
    private List<Observer1> list = Lists.newArrayList();

    /**
     * 注册观察者
     *
     * @param observer 观察者对象
     */
    public void attach(Observer1 observer) {
        list.add(observer);
        System.out.println("注册观察者");
    }

    /**
     * 注销观察者对象
     *
     * @param observer
     */
    public void detach(Observer1 observer) {
        list.remove(observer);
        System.out.println("注销删除者对象");
    }


    /**
     * 通知所有注册过的观察者对象，进行状态的更新
     * 这里传入的是具体主题
     */
    public void nodifyObservers() {
        for (Observer1 observer : list) {
            observer.update(this);
        }
    }

}
