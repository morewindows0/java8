package com.dev.java.designpatterns.chainofres;

/**
 * @author: dengxin.chen
 * @date: 2019/5/20 15:18
 * @description:
 */
public class ChainTest {

    public static void main(String[] args) {
        DrinkFilter drinkFilter = new DrinkFilter();
        DriverFilter driverFilter = new DriverFilter();
        EatFilter eatFilter = new EatFilter();
        CoreTest coreTest = new CoreTest();
        Context context = Context.builder()
                                 .drink(false)
                                 .driver(true)
                                 .eat(true).build();

        // 责任链模式和流水线模式很类似
        FilterChain chain = new FilterChain(coreTest);
        chain.addFilter(drinkFilter);
        chain.addFilter(driverFilter);
        chain.addFilter(eatFilter);
        chain.doFilter(context, chain);
    }
}
