package com.dev.java.designpatterns.inter.observer;

import com.dev.java.designpatterns.observer.Subject1;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 15:13
 * @description: 抽象观察者角色-拉模型
 */
public interface Observer1 {

    /**
     * 更新接口
     *
     * @param subject 传入主题对象
     */
    void update(Subject1 subject);
}
