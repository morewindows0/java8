package com.developer.jdk8.designpatterns.simplefactory;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 10:17
 * @description:类路径配置
 */
public class ObjectPathConfig {

    /**
     * 口令登录对象路径
     */
    public static final String PASSWORD_LOGIN_PATH = "com.developer.jdk8.designpatterns.inter.simplefactory.impl.PasswordLoginImpl";

    /**
     * 域登录对象路径
     */
    public static final String DOMAIN_LOGIN_PATH = "com.developer.jdk8.designpatterns.inter.simplefactory.impl.DomainLoginImpl";

}
