package com.dev.java.designpatterns.inter.prototype.impl;

import com.dev.java.designpatterns.inter.prototype.PrototypeSimple;

/**
 * @author: dengxin.chen
 * @date: 2018/11/5 11:06
 * @description: 简单形式的原型模式-具体原型角色
 */
public class ConcretePrototypeSimple1 implements PrototypeSimple {

    /**
     * 最简单的克隆，新建一个自身对象
     *
     * @return
     */
    @Override
    public Object clone() {
        PrototypeSimple prototypeSimple = new ConcretePrototypeSimple1();
        return prototypeSimple;
    }
}
