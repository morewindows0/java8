package com.dev.java.test.cglibperformance.impl;

import com.dev.java.test.cglibperformance.ProxyCreator;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author: dengxin.chen
 * @date: 2019/5/16 15:35
 * @description:
 */
public class CglibProxyCreator implements ProxyCreator {

    private Class target;

    private MethodInterceptor methodInterceptor;

    public CglibProxyCreator(Class target, MethodInterceptor methodInterceptor) {
        assert (target != null && methodInterceptor != null);
        this.target = target;
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }
}
