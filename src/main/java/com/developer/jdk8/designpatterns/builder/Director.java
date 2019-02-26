package com.developer.jdk8.designpatterns.builder;

import com.developer.jdk8.designpatterns.inter.builder.Builder;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 16:25
 * @description:建造模式中的导演角色，负责具体调度
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}
