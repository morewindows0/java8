package com.dev.java.designpatterns.cglibproxy.impl;

import com.dev.java.designpatterns.cglibproxy.DaoProxy;
import com.dev.java.designpatterns.cglibproxy.ProxyCreator;
import com.dev.java.designpatterns.inter.cglibproxy.Dao;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author: dengxin.chen
 * @date: 2019/5/14 20:59
 * @description: CGLIB代理创建器
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

class AppTest {

    public static void main(String[] args) {
        ProxyCreator proxyCreator = new CglibProxyCreator(Dao.class, new DaoProxy());
        Dao proxy = (Dao) proxyCreator.getProxy();
        System.out.println("proxy type=" + proxy.getClass());
        proxy.select();
        proxy.update();
    }

}
