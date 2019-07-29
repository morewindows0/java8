package com.dev.java.proxy;

import java.lang.reflect.Field;

import com.dev.java.proxy.impl.BaseTestImpl;
import com.dev.java.proxy.jdk.JDKProxy;

/**
 * @author: dengxin.chen
 * @date: 2019-07-29 10:12
 * @description:
 */
public class AppTest {

    public static void main(String[] args) throws Exception {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        BaseTestInterface baseTest = new BaseTestImpl();
        ProxyCreator proxyCreator = new JDKProxy(baseTest);
        BaseTestInterface proxy = (BaseTestInterface) proxyCreator.getProxy();
        Integer result = proxy.add(1, 2);
        System.out.println(result);
        System.out.println("=====================h================");
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        Object obj = h.get(proxy);
        System.out.println(obj.getClass());
    }
}
