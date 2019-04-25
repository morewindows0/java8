package com.dev.java.designpatterns.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 14:55
 * @description: dao代理类
 */
public class DaoProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("Before method Invoke");
        proxy.invokeSuper(object, objects);
        System.out.println("After method Invoke");
        return object;
    }
}
