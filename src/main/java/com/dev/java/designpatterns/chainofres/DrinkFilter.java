package com.dev.java.designpatterns.chainofres;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:17
 * @description:
 */
public class DrinkFilter implements ProcessFilter {

    @Override
    public void doFilter(Context context, FilterChain chain) {
        if (context.isDrink()) {
            System.out.println("i don't drink");
        }
        chain.doFilter(context, chain);
    }
}
