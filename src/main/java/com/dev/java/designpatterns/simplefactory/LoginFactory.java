package com.dev.java.designpatterns.simplefactory;

import com.dev.java.designpatterns.inter.simplefactory.Login;
import com.dev.java.designpatterns.inter.simplefactory.impl.DomainLoginImpl;
import com.dev.java.designpatterns.inter.simplefactory.impl.PasswordLoginImpl;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 15:36
 * @description: 登录工厂类，根据不同的登录类型创建不同的登录实例
 * 核心点就在工厂类，丢进去一个标识，创建一个对应的对象
 */
public class LoginFactory {

    /**
     * 工厂方法，根据不同的type创建不同的对象，如果没找到，则抛出运行时异常
     *
     * @param type
     * @return
     */
    public static Login factory(String type) {
        if (type.equals("password")) {
            return new PasswordLoginImpl();
        } else if (type.equals("domaincode")) {
            return new DomainLoginImpl();
        } else {
            throw new RuntimeException("登录类型不对");
        }
    }
}
