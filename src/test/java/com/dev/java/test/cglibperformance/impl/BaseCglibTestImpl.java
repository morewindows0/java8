package com.dev.java.test.cglibperformance.impl;

import com.dev.java.test.cglibperformance.BaseCglibTest;

/**
 * @author: dengxin.chen
 * @date: 2019/5/16 15:32
 * @description:
 */
public class BaseCglibTestImpl implements BaseCglibTest {

    @Override
    public int add(int num) {
        return num + 1;
    }
}
