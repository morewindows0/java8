package com.developer.jdk8.designpatterns.inter.adapter.impl;

import com.developer.jdk8.designpatterns.adapter.Adaptee;
import com.developer.jdk8.designpatterns.inter.adapter.Target;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 14:23
 * @description:适配器模式-适配角色，核心类
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void sampleOperation2() {
        System.out.println("在适配器角色中进行转换");
    }
}
