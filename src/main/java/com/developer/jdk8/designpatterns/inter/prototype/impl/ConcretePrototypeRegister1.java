package com.developer.jdk8.designpatterns.inter.prototype.impl;

import com.developer.jdk8.designpatterns.inter.prototype.PrototypeRegister;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 11:16
 * @description:登记形式的原型模式-具体原型角色
 */
public class ConcretePrototypeRegister1 implements PrototypeRegister {
    private String name;

    @Override
    public PrototypeRegister clone() {
        ConcretePrototypeRegister1 prototype = new ConcretePrototypeRegister1();
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeRegister1:name=" + this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
