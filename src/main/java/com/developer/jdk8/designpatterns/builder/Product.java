package com.developer.jdk8.designpatterns.builder;

/**
 * @author: dengxin.chen
 * @date: 2018/11/2 16:19
 * @description: 建造模式中具体产品
 */
public class Product {

    private String part1;
    private String part2;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "Product{" + "part1='" + part1 + '\'' + ", part2='" + part2 + '\'' + '}';
    }
}
