package com.developer.jdk8.designpatterns.inter.abstractfactory.impl;

import com.developer.jdk8.designpatterns.inter.abstractfactory.Cpu;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:09
 * @description:AmdCpu实现类
 */
public class AmdCpu implements Cpu {

    private int pins;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {

        System.out.println("AMD CPU针脚数：" + pins);

    }
}
