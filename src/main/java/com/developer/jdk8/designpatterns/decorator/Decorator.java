package com.developer.jdk8.designpatterns.decorator;

import com.developer.jdk8.designpatterns.inter.decorator.Component;

/**
 * @author: dengxin.chen
 * @date: 2018/11/8 10:21
 * @description: 装饰角色
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        //委派给具体构件
        component.sampleOperation();
    }
}
