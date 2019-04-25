package com.dev.java.designpatterns.inter.adapter;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 14:20
 * @description: 适配器模式-目标角色
 */
public interface Target {

    void sampleOperation1();

    /**
     * 源角色中未有的方法，扩展出来
     */
    void sampleOperation2();
}
