package com.developer.jdk8.designpatterns.inter.abstractfactory.impl;

import com.developer.jdk8.designpatterns.inter.abstractfactory.Cpu;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:08
 * @description: IntelCpu具体实现类
 */
public class IntelCpu implements Cpu {

    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {

        System.out.println("Intel CPU针脚数：" + pins);
    }
}
