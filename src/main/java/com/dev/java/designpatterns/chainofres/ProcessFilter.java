package com.dev.java.designpatterns.chainofres;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:02
 * @description:责任链模式演示
 */
public interface ProcessFilter {

    void doFilter(Context context, FilterChain chain);
}
