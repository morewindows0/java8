package com.dev.java.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.junit.Test;

import com.dev.java.domain.UserDomain;
import com.dev.java.time.TimeUtils;
import com.google.common.base.Splitter;

/**
 * @author: dengxin.chen
 * @date: 2018/9/16 12:24
 * @description: StreaApi终止操作
 */
public class StreamApiTest2 {
    List<UserDomain> ListData = Arrays.asList(
            new UserDomain("A", "男", 13), new UserDomain("B", "男", 136),
            new UserDomain("C", "女", 1323), new UserDomain("D", "男", 133),
            new UserDomain("E", "女", 23), new UserDomain("F", "男", 13)
    );

    @Test
    public void lambdaTest1() {
        /**
         * 检查匹配所有元素 allMatch
         */
        boolean allMatch = ListData.stream()
                                   .allMatch(item -> item.getAge() > 122);

        System.out.println("是否匹配所有元素：" + allMatch);

        /**
         * 检查至少匹配一个元素
         */
        boolean anyMatch = ListData.stream()
                                   .anyMatch(item -> item.getName()
                                                         .equals("张三"));

        System.out.println("是否匹配一个元素:" + anyMatch);

        /**
         * 检查是否没有匹配所有元素
         * eg：名字没有只有一个“刘”字的所以返回true
         * eg:item.getAge>23 返回false，因为这个匹配了一些元素
         */
        //        boolean noneMatch = ListData.stream().noneMatch(item -> item.getName().equals("刘"));
        boolean noneMatch = ListData.stream()
                                    .noneMatch(item -> item.getAge() > 23);
        //        boolean noneMatch = ListData.stream().noneMatch(item -> item.getName().equals("刘"));

        System.out.println("检查年龄大于23是否没有匹配所有元素:" + noneMatch);


        /**
         * findFrist返回第一个元素
         */

        Optional<UserDomain> first = ListData.stream()
                                             .sorted((x, y) -> y.getAge().compareTo(x.getAge()))
                                             .findFirst();

        Optional.ofNullable(first)
                .ifPresent(item -> System.out.println(item.get().toString()));
        Optional.ofNullable(first)
                .ifPresent(item -> System.out.println(item.get().toString()));
        if (first.isPresent()) {
            System.out.println(first.get()
                                    .getAge());
        }
    }

    @Test
    public void lambdaTest2() {

        /**
         * 返回任意一个元素
         */
        Optional<UserDomain> any = ListData.stream()
                                           .filter(item -> item.getAge() > 13)
                                           .findAny();
        Optional.ofNullable(any)
                .ifPresent(item -> System.out.println(item.get()));


        /**
         *返回元素中的总数
         */
        long count = ListData.stream()
                             .count();

        System.out.println(count);

        /**
         * max找最大值
         */
        Optional<UserDomain> max = ListData.stream()
                                           .max(Comparator.comparing(UserDomain::getAge));

        max.ifPresent(item -> System.out.println(item));

        Optional<Integer> min = ListData.stream()
                                        .map(UserDomain::getAge)
                                        .max(Long::compare);

        min.ifPresent(item -> System.out.println(item));
    }

    @Test
    public void lambdaTest3() {
        /**
         * reduce 归纳
         */
        Optional<Integer> reduce = ListData.stream()
                                           .map(UserDomain::getAge)
                                           .reduce(Integer::sum);

        System.out.println(reduce.get());

        /**
         * 收集 collect
         */

        //注意在使用toMap转换为map集合时，如果value为对象，应该用下面的写法
        Map<String, UserDomain> collect = ListData.stream()
                                                  .filter(item -> item.getAge() > 123)
                                                  .collect(Collectors.toMap(UserDomain::getName,
                                                          item -> item));

        collect.entrySet()
               .stream()
               .forEach(System.out::println);

        Optional<UserDomain> max = ListData.stream()
                                           .max(Comparator.comparing(UserDomain::getAge));

        max.ifPresent(item -> System.out.println(item.getAge()));

    }

    @Test
    public void lambdaTest4() {

        //分组
        Map<Integer, List<UserDomain>> map = ListData.stream()
                                                     .collect(Collectors.groupingBy(UserDomain::getAge));

        Map<Integer, Map<String, List<UserDomain>>> collect2 = ListData.stream()
                                                                       .collect(Collectors.groupingBy(UserDomain::getAge,
                                                                               Collectors.groupingBy(UserDomain::getGender)));

        map.entrySet()
           .stream()
           .forEach(item -> System.out.println(item.getValue()));

        //分区
        Map<Boolean, List<UserDomain>> map1 = ListData.stream()
                                                      .collect(Collectors.partitioningBy(item -> item.getAge() < 35));


        map1.entrySet()
            .stream()
            .forEach(item -> System.out.println(item.getValue()));

        //连接字符串
        String collect = ListData.stream()
                                 .map(UserDomain::getName)
                                 .collect(Collectors.joining(","));
        LongSummaryStatistics collect1 = ListData.stream()
                                                 .map(UserDomain::getAge)
                                                 .collect(Collectors.summarizingLong(Integer::intValue));

        System.out.println(collect1.getSum());

        System.out.println(collect);

        List<String> testJoin = Arrays.asList("1");
        String collect3 = testJoin.stream().collect(Collectors.joining(","));

        List<Long> strings =
                Splitter.on(",").splitToList(collect3).stream().map(Long::valueOf).collect(Collectors.toList());
    }

    /**
     * java8的map测试
     */
    @Test
    public void mapTest() {

        //map操作，对stream中的对象进行相关操作
        //#1.提取name集合
        List<String> collect = ListData.stream()
                                       .map(UserDomain::getName)
                                       .collect(Collectors.toList());

        collect.stream()
               .forEach(System.out::println);

        //#2过滤并转换成map集合
        Map<UserDomain, String> resultMap = ListData.stream()
                                                    .filter(item -> item.getName()
                                                                        .equals("张三"))
                                                    .collect(Collectors.toMap(item -> item,
                                                            item -> item.getName()));
        resultMap.entrySet()
                 .stream()
                 .forEach(item -> System.out.println(item.getKey() + "==" + item.getValue()));
        List<UserDomain> resultList = ListData.stream()
                                              .filter(item -> item.getAge() > 30)
                                              .collect(Collectors.toList());
        resultMap.entrySet().stream().forEach(item -> System.out.println(item.getKey() + "==" + item.getValue()));

        for (UserDomain item : resultList) {
            System.out.println(item);
        }

        TreeSet<Integer> resultSet = ListData.stream()
                                             .map(UserDomain::getAge)
                                             .collect(Collectors.toCollection(TreeSet::new));

        for (Integer item : resultSet) {
            System.out.println(item);
        }

        String resultString = ListData.stream()
                                      .map(UserDomain::getName)
                                      .collect(Collectors.joining(","));

        System.out.println(resultString);
    }

    @Test
    public void peekTest() {
        List<UserDomain> sorted = ListData.stream().sorted(Comparator.comparing(UserDomain::getAge).thenComparing(Comparator.comparing(UserDomain::getName)).reversed()).collect(Collectors.toList());
        String s = TimeUtils.formatDate(new Date(), "MM-dd HH:mm");
        Map<String, UserDomain> collect = ListData.stream().collect(Collectors.toMap(UserDomain::getGender, Function.identity(),(oldValue, newValue) -> newValue));
        List<UserDomain> tttt = ListData.stream().peek(item -> item.setName("XXXXXX")).collect(Collectors.toList());
        boolean equals = TestEnum.AUDIT_IMAGE_COUNT_UPPER_LIMIT.getCode().equals("80001014");
        Integer age = tttt.stream().filter(item -> item.getAge() == 23).findFirst().orElseGet(() -> new UserDomain("张三", "男", 13)).getAge();
        StringBuilder builder = new StringBuilder();
        builder.append("涉及到-");
        for (String str : Arrays.asList("1", "2")) {
            builder.append("test" + ",");
        }
        List<Integer> integers = Arrays.asList(1, 2, 4, 5);
        Collections.shuffle(integers, new Random(new Date().getTime()));
        System.out.println(integers);
        System.out.println(builder.substring(0, builder.length() - 1));
        DateTime now = DateTime.now();
        long startCreateTime = now.plusDays(-13).toDate().getTime();
        long endCreateTime = now.plusDays(-6).toDate().getTime();
        long l = endCreateTime - startCreateTime;
        long l1 = l / 1000 / 60 / 60 / 24;


    }

}

