package com.dev.java.designpatterns.inter.decorator.impl;

import com.dev.java.designpatterns.inter.decorator.Component;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 10:20
 * @description: 具体构件角色
 */
public class ConcreteComponent implements Component {

    @Override
    public void sampleOperation() {
        System.out.println("具体构件角色执行的方法");
    }
}
