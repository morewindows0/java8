package com.dev.java.proxy.impl;

import com.dev.java.proxy.BaseTestInterface;

/**
 * @author: dengxin.chen
 * @date: 2019-07-29 10:12
 * @description:
 */
public class BaseTestImpl implements BaseTestInterface {

    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }
}
