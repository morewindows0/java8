package com.dev.java.designpatterns.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 15:16
 * @description:对不同方法采用不同的拦截方式
 */
public class DaoAnotherProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("StartTime:" + System.currentTimeMillis());
        proxy.invokeSuper(obj, args);
        System.out.println("EndTime:" + System.currentTimeMillis());
        return obj;

    }
}
