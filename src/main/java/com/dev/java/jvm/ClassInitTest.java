package com.dev.java.jvm;

/**
 * @author: dengxin.chen
 * @date: 2019/5/6 9:37
 * @description:类初始化测试
 */
public class ClassInitTest {

    /**
     * #1.通过子类引用父类的静态字段，不会导致子类初始化
     * #2.通过数组定义来引用类，不会触发此类的初始化
     *
     * @param args
     */
    public static void main(String[] args) {
        //        System.out.println(SubClass.value);
        //        SuperClass[] sc = new SuperClass[10];
        System.out.println(SuperClass.TEST_VALUE);
    }
}

class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public SuperClass() {
        System.out.println("SuperClass Constructor");
    }

    public static int value = 123;
    public static final String TEST_VALUE = "HELLO";
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
