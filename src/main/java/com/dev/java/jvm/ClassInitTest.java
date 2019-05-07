package com.dev.java.jvm;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author: dengxin.chen
 * @date: 2019/5/6 9:37
 * @description:类初始化测试
 */
public class ClassInitTest {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
