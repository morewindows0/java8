package com.dev.java.test.blogs;

/**
 * @author: dengxin.chen
 * @date: 2018/11/22 14:06
 * @description:IDEA在debug时会重启一个线程调用toString()方法
 */
public class ToStringTest {
    /**
     * 验证Debug时，idea会开启一个线程调用对象的toString方法
     */
    public static void main(String[] args) {

        WilltoStringInvoked will = new WilltoStringInvoked();

        System.out.println("如果在这里设置断点，则输出1");

        System.out.println(will.getValue());

        System.out.println("如果不设置断点，则输出0");

    }

    static class WilltoStringInvoked {
        private volatile int value = 0;

        private int setValue() {
            if (value == 0) {
                synchronized (this) {
                    if (value == 0) {
                        value = 1;
                    }
                }
            }
            return value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "This value is:" + setValue();
        }
    }
}
