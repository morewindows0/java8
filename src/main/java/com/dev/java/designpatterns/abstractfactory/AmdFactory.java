package com.dev.java.designpatterns.abstractfactory;

import com.dev.java.designpatterns.inter.abstractfactory.AbstractFactory;
import com.dev.java.designpatterns.inter.abstractfactory.Cpu;
import com.dev.java.designpatterns.inter.abstractfactory.Mainboard;
import com.dev.java.designpatterns.inter.abstractfactory.impl.AmdCpu;
import com.dev.java.designpatterns.inter.abstractfactory.impl.AmdMainboard;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:15
 * @description:Amd产品工厂
 */
public class AmdFactory implements AbstractFactory {
    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }
}
