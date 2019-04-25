package com.dev.java.designpatterns.simplefactory;

import com.dev.java.designpatterns.inter.simplefactory.Login;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 10:13
 * @description: 通过反射的方式对简单工厂模式的工厂对象进行改造
 */
public class GenerateLogin {

    /**
     * 通过反射的方式获取对应的产品，改进原来工厂类可能会出现过于臃肿的情况
     *
     * @param objectPath
     * @return
     * @throws Exception
     */
    public static Login generteObject(String objectPath) {
        try {
            Class<?> object = Class.forName(objectPath);
            Login result = (Login) object.newInstance();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("获取登录对象异常：{}" + e.getMessage());
        }
    }
}
