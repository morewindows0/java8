package com.dev.java.test.cglibperformance.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.dev.java.test.cglibperformance.ProxyCreator;

/**
 * @author: dengxin.chen
 * @date: 2019/5/16 15:42
 * @description:
 */
public class JDKProxyCreator implements ProxyCreator, InvocationHandler {

    private Object target;


    public JDKProxyCreator(Object target) {
        assert target != null;
        Class[] interfaces = target.getClass().getInterfaces();
        if (interfaces.length == 0) {
            throw new IllegalArgumentException("target class don't implement any interface");
        }
        this.target = target;

    }

    @Override
    public Object getProxy() {
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }
}
