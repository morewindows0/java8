package com.dev.java.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.dev.java.domain.UserDomain;
import com.dev.java.math.MathUtils;
import com.dev.java.time.TimeUtils;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author: dengxin.chen
 * @date: 2018/8/27 16:18
 * @description:
 */
public class AppTest {

    @Test
    public void lambdaTest1() {

        List<Integer> list = Arrays.asList(100, 3, 2, 54, 2);

        //排序，用第一个比较第二个即为升序，x<y返回-1，不用改变，大于1就变换位置
        //反之为降序，倒叙
        //关键点：比较时大于1就会变换位置
        List<Integer> collect = list.stream().sorted((x, y) -> x.compareTo(y)).collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
    }

    @Test
    public void lambdaTest2() {
        Consumer<String> con = (consumer) -> System.out.println(consumer);

        con.accept("test");
    }

    @Test
    public void lambdaTest3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

        int compare = com.compare(1, 2);
        System.out.println(compare);
    }

    @Test
    public void lambdaTest4() throws Exception {

        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer max = list.stream().max((x, y) -> x.compareTo(y)).get();
        //在lambda中进行操作返回
        Integer first = list.stream().filter(item -> item == 5).findFirst().orElseThrow(() -> new Exception("fdsaf"));
        System.out.println(first);

        System.out.println(max);

    }

    @Test
    public void lambdaTest5() {
        List<UserDomain> list = Lists.newArrayList();
        UserDomain td = new UserDomain();
        td.setGender("男");
        td.setName("测试");
        list.add(td);
        list.stream().forEach(item -> {
            if (item.getName().equals("测试")) {
                item.setGender("发");
            }
        });

        System.out.println(list);
    }

    @Test
    public void lambdaTest6() {
        List<String> list = Arrays.asList("abc", "cde", "fgh");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void lambdaTest7() {

        List<Integer> list = Arrays.asList(3, 2, 19, 3, 2);

        //sorted里不加参数就是自然排序（Comparable），默认为升序
        list.stream().sorted().forEach(System.out::println);
        System.out.println("==========================");
        //使用Comparator就进行定制排序
        list.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }


    @Test
    public void testMathApi() {
        double d = 1d;

        double d1 = 1.2d;

        double v = MathUtils.doubleAdd(d, d1);

        System.out.println(v);

        String twoDecimals = MathUtils.keepTwoDecimals(d);

        System.out.println(twoDecimals);
    }

    @Test
    public void testTimeApi() {

        Date date = new Date();

        Date date1 = TimeUtils.addMonths(date, 10);

        System.out.println(date1);

    }


    @Test
    public void testStream() {

        List<Integer> list = Arrays.asList(1, 6, 6, 6, 5, 6, 7, 8);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        boolean b = list.stream().allMatch(integer -> integer != 3);
        System.out.println(b);
        List<Integer> collect = list.parallelStream().map(integer -> integer * integer).collect(Collectors.toList());

        collect.stream().forEach(integer -> System.out.println(integer));

        list.stream().forEach(item -> list2.stream().forEach(item2 -> {
            if (item == item2) System.out.println("找到相等的数：" + item + "和" + item2);
        }));

        long count = list.stream().filter(item -> item == 10).count();

        System.out.println(count);
    }

    @Test
    public void lambdaTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> first = list.stream().filter(item -> item.equals(new Integer(5))).findFirst();

        System.out.println(first.get());


    }

    public static void test() {
        List<Long> mytest = mytest(11L, 12L);

    }

    public static List<Long> mytest(Long... t) {
        List<Long> longs = Arrays.asList(t);
        return longs;

    }

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(5);
        BigDecimal value = new BigDecimal(0.1234688);
        String result = numberFormat.format(value).replace("%", "");
        System.out.println(result);

        try {
            int x = 0;
            int i = 1 / x;

        } catch (Exception e) {


        }
    }

    @Test
    public void testEnum() {

        System.out.println(Ensemble.SOLD.getSize());

        String fileName = new String(("券使用记录").getBytes(), StandardCharsets.ISO_8859_1);

        String tmpFileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
       /* int x=3263335;
        int x = 3263335;
        Long aLong = Long.valueOf(x);
        Integer m = null;
       /* if (x != m) {
            System.out.println("f");
        }
*/

       /* GasGroupVO gasInfo= GasGroupVO.builder().gasStationId(123L).build();
        List<GasGroupVO> list = Arrays.asList(gasInfo);
        String gasInfoJsonString = JSONObject.toJSONString(list);

        List<GasGroupVO> list1 = JSONObject.parseArray(gasInfoJsonString, GasGroupVO.class);

        Set<Long> tss= Sets.newHashSet();

        List<Long> item1=Arrays.asList(1L,1L,2L);
        tss.addAll(item1);*/

        UserDomain userDomain = UserDomain.builder()
                                          .age(12)
                                          .build();

        System.out.println(userDomain.toString());

        //测试所用

        GasGroupVO gasInfo = GasGroupVO.builder().gasStationId(3L).name("111").id(11L).build();
        GasGroupVO gasInfo1 = GasGroupVO.builder().gasStationId(1L).name("111").id(11L).build();
        GasGroupVO gasInfo2 = GasGroupVO.builder().gasStationId(2L).name("112").id(11L).build();

        List<GasGroupVO> list = Lists.newArrayList();
        list.add(gasInfo);
        list.add(gasInfo1);
        list.add(gasInfo2);

        Optional<GasGroupVO> first = list.stream().findFirst();

        Map<String, GasGroupVO> collect3 = list.stream().collect(Collectors.toMap(item -> String.valueOf(item.getGasStationId()), item -> item));

        // 通过属性过滤重复值
        ArrayList<GasGroupVO> collect2 = list.stream()
                                             .collect(Collectors.collectingAndThen(
                                                     Collectors.toCollection((() -> new TreeSet<>(Comparator.comparing(GasGroupVO::getName)))),
                                                     ArrayList::new));


        List<GasGroupVO> list1 = list.subList(0, 2);
        List<GasGroupVO> collect1 = list.stream()
                                        .sorted((x, y) -> y.getGasStationId().compareTo(x.getGasStationId()))
                                        .collect(Collectors.toList());
        Map<String, List<GasGroupVO>> collect = list.stream().collect(Collectors.groupingBy(GasGroupVO::getName));

        Map<String, GasGroupVO> map = Maps.newHashMap();
        for (Map.Entry<String, List<GasGroupVO>> entry : collect.entrySet()) {

            if (entry.getValue().size() > 1) {

                long sum = entry.getValue().stream()
                                .collect(Collectors.summingLong(GasGroupVO::getGasStationId)).longValue();

                long xx = sum;
            } else {
                map.put(entry.getKey(), entry.getValue().get(0));
            }


        }

    }

    @Test
    public void testNum() {
        Long g = null;
        String.valueOf(g);
        Map<String, String> t = Maps.newHashMap();
        t.put("ff", String.valueOf(g));
        String sp = " ,4343, ,43434,,";
        List<String> strings = Splitter.on(",")
                                       .trimResults()
                                       .omitEmptyStrings()
                                       .splitToList(sp);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        // 改成这样就好了
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Long seconds = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;

        LocalDate now = LocalDate.now();
        long l = now.plusDays(1).toDate().getTime() - System.currentTimeMillis();
        long l1 = l / 1000;
        System.out.println(l1);

        System.out.println(this.getClass().getSimpleName().equals(AppTest.class.getSimpleName()));
        System.out.println(seconds);
        Set<Integer> set = Sets.newHashSet();
        set.add(1);
        set.add(1);
    }

    public static String cent2TenNoSymbol(Long cent) {

        BigDecimal yuan = point2ten(cent);
        if (null == yuan) {
            yuan = new BigDecimal(0L);
        }
        return yuan.toString();
    }

    private static Integer scale;

    private static BigDecimal point2ten(Long point) {
        if (null == point) {
            point = 0L;
        }
        BigDecimal centBigDecimal = new BigDecimal(point);
        if (null == scale) {
            scale = 2;
        }
        BigInteger divisor = BigInteger.valueOf(1L);
        for (int i = 0; i < scale; i++) {
            divisor = divisor.multiply(BigInteger.valueOf(10L));
        }
        return centBigDecimal.divide(new BigDecimal(divisor)).setScale(scale);
    }

    @Test
    public void groupBYData() {
        GasGroupVO groupVO = GasGroupVO.builder().name("油品好").id(96L).build();
        GasGroupVO groupVO1 = GasGroupVO.builder().name("油品好").id(96L).build();
        GasGroupVO groupVO2 = GasGroupVO.builder().name("油耐烧").id(97L).build();
        GasGroupVO groupVO3 = GasGroupVO.builder().name("开票快").id(100L).build();
        GasGroupVO groupVO4 = GasGroupVO.builder().name("开票快").id(100L).build();
        GasGroupVO groupVO5 = GasGroupVO.builder().name("开票快").id(100L).build();

        List<GasGroupVO> testList = Lists.newArrayList();
        testList.add(groupVO);
        testList.add(groupVO1);
        testList.add(groupVO2);
        testList.add(groupVO3);
        testList.add(groupVO4);
        testList.add(groupVO5);
        List<ResultLabel> list;
        List<ResultLabel> collect = testList.stream()
                                            .filter(item -> Objects.nonNull(item.getName()))
                                            .collect(Collectors.groupingBy(GasGroupVO::getName,
                                                                           Collectors.counting())).entrySet().stream()
                                            .map(item -> new ResultLabel(item.getKey(), item.getValue()))
                                            .collect(Collectors.toList());


        List<ResultLabel> collect1 = testList.stream().map(item -> ResultLabel.builder().name(item.getName()).build()).collect(Collectors.toList());

        System.out.println("成功");

    }
}

enum Ensemble {
    SOLD(1), DUET(2), TRIO(3);

    private int size;

    Ensemble(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

}

