package com.developer.jdk8.designpatterns.abstractfactory;

import com.developer.jdk8.designpatterns.inter.abstractfactory.AbstractFactory;
import com.developer.jdk8.designpatterns.inter.abstractfactory.Cpu;
import com.developer.jdk8.designpatterns.inter.abstractfactory.Mainboard;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:17
 * @description:电脑装机类
 */
public class ComputerEngineer {

    private Cpu cpu = null;

    private Mainboard mainboard = null;

    public void makeComputer(AbstractFactory af) {

        prepareHardwwares(af);

    }

    /**
     * 准备硬件
     *
     * @param af
     */
    private void prepareHardwwares(AbstractFactory af) {
        cpu = af.createCpu();
        mainboard = af.createMainboard();

        cpu.calculate();
        mainboard.installCPU();
    }
}
