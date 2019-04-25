package com.dev.java.designpatterns.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 15:19
 * @description: dao方法过滤
 */
public class DaoFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }
}
