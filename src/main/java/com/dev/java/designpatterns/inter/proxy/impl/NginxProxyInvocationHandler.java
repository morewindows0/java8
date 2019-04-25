package com.dev.java.designpatterns.inter.proxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 14:12
 * @description:
 */
public class NginxProxyInvocationHandler implements InvocationHandler {

    private Object object;

    public NginxProxyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        return result.toString();
    }
}
