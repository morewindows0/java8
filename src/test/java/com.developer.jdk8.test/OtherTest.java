package com.developer.jdk8.test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.developer.jdk8.domain.UserDomain;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author: dengxin.chen
 * @date: 2018/11/7 11:18
 * @description:其他测试
 */
public class OtherTest {

    @Test
    public void arrayUtilsTest() {
        Integer[] intArray = {1, 2, 3};
        List<String> list = Lists.newArrayList("1", "2", "3");

        List<Integer> ints = Arrays.asList(intArray);

        //在利用Arrays.asList的时候，不能进行add和remove操作，因为其内部实现并没有重写add和remove方法，会使用AbstractList的
        //add和remove方法，该方法内部直接抛出异常，所以在使用该方法时，需特别注意
        //        ints.remove(1);

        ints.stream().forEach(System.out::println);

        List<Integer> intList = Lists.newArrayList(intArray);

        intList.add(4);

        intList.stream().forEach(System.out::println);

        list.stream().forEach(System.out::println);
    }

    /**
     * builder注解测试
     */
    @Test
    public void builderTest() {
        UserDomain userDomain = UserDomain.builder().name("builder").gender("男").age(12).build();

        System.out.println(userDomain);
    }

    @Test
    public void threadPoolExecutorTest() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                                                                 3,
                                                                 2000,
                                                                 TimeUnit.MILLISECONDS,
                                                                 new LinkedBlockingQueue<>(),
                                                                 new ThreadFactoryBuilder().setNameFormat("fdsf").build(),
                                                                 new ThreadPoolExecutor.CallerRunsPolicy());
        poolExecutor.execute(() -> System.out.println("test"));
    }
}