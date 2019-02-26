package com.developer.jdk8.designpatterns.inter.prototype;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 11:15
 * @description: 登记形式的原型模式-抽象原型角色
 */
public interface PrototypeRegister {

    PrototypeRegister clone();

    String getName();

    void setName(String name);

}
