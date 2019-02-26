package com.developer.jdk8.designpatterns.decorator;

import com.developer.jdk8.designpatterns.inter.decorator.Component;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 10:23
 * @description:
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("对相关功能进行增强");
    }
}
