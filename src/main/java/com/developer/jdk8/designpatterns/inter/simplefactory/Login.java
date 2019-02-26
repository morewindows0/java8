package com.developer.jdk8.designpatterns.inter.simplefactory;

/**
 * @author: dengxin.chen
 * @date: 2018/11/1 15:28
 * @description: 使用登录认证来描述简单工厂模式，在登录的是否分口令认证和域认证，但在进行检测的时候，都是走verify方法
 */
public interface Login {
    boolean verify(String username, String password);
}
