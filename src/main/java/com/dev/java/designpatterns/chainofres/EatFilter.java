package com.dev.java.designpatterns.chainofres;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:15
 * @description:
 */
public class EatFilter implements ProcessFilter {

    @Override
    public void doFilter(Context context, FilterChain chain) {
        if (context.isEat()) {
            System.out.println("i am eating");
        }
        chain.doFilter(context, chain);
    }
}
