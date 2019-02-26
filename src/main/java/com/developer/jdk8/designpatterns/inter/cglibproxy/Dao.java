package com.developer.jdk8.designpatterns.inter.cglibproxy;

/**
 * @author: dengxin.chen
 * @date: 2018/11/6 14:54
 * @description:演示Cglib对类做代理
 */
public class Dao {

    public void update() {
        System.out.println("执行update方法");
    }

    public void select() {
        System.out.println("执行select方法");
    }
}
