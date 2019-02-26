package com.developer.jdk8.designpatterns.inter.abstractfactory;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 11:02
 * @description: 抽象工厂模式
 */
public interface AbstractFactory {

    /**
     * 创建cpu对象
     *
     * @return
     */
    Cpu createCpu();


    /**
     * 创建主板对象
     *
     * @return
     */
    Mainboard createMainboard();
}
