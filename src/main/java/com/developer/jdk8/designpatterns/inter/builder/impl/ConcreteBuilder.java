package com.developer.jdk8.designpatterns.inter.builder.impl;

import com.developer.jdk8.designpatterns.builder.Product;
import com.developer.jdk8.designpatterns.inter.builder.Builder;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 16:23
 * @description:建造模式中具体建造角色，实现Builder接口，这里为建造的具体实现
 */
public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("构建零件1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("构建零件2");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
