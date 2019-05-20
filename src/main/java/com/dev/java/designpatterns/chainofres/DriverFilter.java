package com.dev.java.designpatterns.chainofres;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:13
 * @description:
 */
public class DriverFilter implements ProcessFilter {

    @Override
    public void doFilter(Context context, FilterChain chain) {
        if (context.isDriver()) {
            System.out.println("i can drive");
        }
        chain.doFilter(context, chain);
    }
}
