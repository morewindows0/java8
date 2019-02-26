package com.developer.jdk8.designpatterns.inter.builder;

import com.developer.jdk8.designpatterns.builder.Product;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 16:20
 * @description:建造模式中抽象建造角色，builder接口比较重要，定义如何构建各个部件
 */
public interface Builder {

    void buildPart1();

    void buildPart2();

    Product retrieveResult();
}
