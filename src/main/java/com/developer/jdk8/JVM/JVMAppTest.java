package com.developer.jdk8.JVM;

/**
 * @author: dengxin.chen
 * @date: 2019/2/26 11:30
 * @description:虚拟机测试
 */
public class JVMAppTest {

    private static int bytesize = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * bytesize];
        allocation2 = new byte[2 * bytesize];
        allocation3 = new byte[2 * bytesize];
        allocation4 = new byte[4 * bytesize];


    }
}
