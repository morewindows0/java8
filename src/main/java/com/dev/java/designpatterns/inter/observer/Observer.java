package com.dev.java.designpatterns.inter.observer;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 15:13
 * @description: 抽象观察者角色
 */
public interface Observer{

    /**
     * 更新接口
     *
     * @param sdate 更新状态
     */
    void update(String sdate);
}
