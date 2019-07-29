package com.dev.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.dev.java.proxy.ProxyCreator;

/**
 * @author: dengxin.chen
 * @date: 2019-07-29 10:04
 * @description:
 */
public class JDKProxy implements ProxyCreator, InvocationHandler {

    private Object target;

    public JDKProxy(Object target) {
        assert target != null;
        Class[] interfaces = target.getClass().getInterfaces();
        if (interfaces.length == 0) {
            throw new IllegalArgumentException("jdk proxy need interface");
        }
        this.target = target;
    }

    @Override
    public Object getProxy() {
        Object instance = Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
        return instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }
}
