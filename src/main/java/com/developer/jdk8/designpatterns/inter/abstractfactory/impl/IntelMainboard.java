package com.developer.jdk8.designpatterns.inter.abstractfactory.impl;

import com.developer.jdk8.designpatterns.inter.abstractfactory.Mainboard;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:11
 * @description:Intel主板实现类
 */
public class IntelMainboard implements Mainboard {
    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("Intel主板cpu插孔数：" + cpuHoles);
    }
}
