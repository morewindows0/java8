package com.dev.java.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.dev.java.domain.UserDomain;
import com.google.common.base.Joiner;
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

    @Test
    public void testListPartition() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer integer = list.get(list.size() - 1);
        List<List<Integer>> partition = Lists.partition(list, 8);

        System.out.println(partition.size());
        String join = Joiner.on(",").join(list);
        String join1 = StringUtils.join(list, ",");
    }


}


