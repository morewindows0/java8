package com.developer.jdk8.designpatterns.abstractfactory;

import com.developer.jdk8.designpatterns.inter.abstractfactory.AbstractFactory;
import com.developer.jdk8.designpatterns.inter.abstractfactory.Cpu;
import com.developer.jdk8.designpatterns.inter.abstractfactory.Mainboard;
import com.developer.jdk8.designpatterns.inter.abstractfactory.impl.IntelCpu;
import com.developer.jdk8.designpatterns.inter.abstractfactory.impl.IntelMainboard;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:14
 * @description: Intel产品工厂
 */
public class IntelFactory implements AbstractFactory {
    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}
