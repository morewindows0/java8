package com.developer.jdk8.designpatterns.inter.abstractfactory.impl;

import com.developer.jdk8.designpatterns.inter.abstractfactory.Mainboard;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:12
 * @description:
 */
public class AmdMainboard implements Mainboard {

    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("Amd主板cpu插孔数：" + cpuHoles);
    }

}
