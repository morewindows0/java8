package com.developer.jdk8.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author: dengxin.chen
 * @date: 2018/8/29 17:30
 * @description:jdk8 StreamApi测试
 */
public class StreamApiTest1 {

    public static List<Integer> list = Arrays.asList(11, 2, 7, 7, 11, 12, 22, 33);

    /**
     * 过滤测试
     */
    @Test
    public void filterTest() {

        long count = list.stream().filter(item -> item == 10).count();

        System.out.println(count);

        List<Integer> collect = list.stream().filter(item -> item > 5).collect(Collectors.toList());

        collect.forEach(item -> {
            System.out.println(item);
        });

    }

    /**
     * 去重测试
     */
    @Test
    public void distinctTest() {

        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());

        collect.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 排序测试 默认为升序
     */
    @Test
    public void sortTest() {

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());

        collect.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 截取测试 截取前N个
     */
    @Test
    public void limitTest() {

        List<Integer> collect = list.stream()
                                    .limit(3)
                                    .collect(Collectors.toList());

        collect.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 跳过前N个数
     */
    @Test
    public void skipTest() {

        List<Integer> collect = list.stream().skip(3).collect(Collectors.toList());

        collect.stream().forEach(System.out::println);

    }
}
