package com.dev.java.thread.forkjoin;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: dengxin.chen
 * @date: 2019/5/7 20:58
 * @description:
 */
@Slf4j
public class ForkJoinTest {

    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = Maps.newHashMap();
        map.put(1, 1);
        map.put(2, 1);
        log.info("日志测试");
        BigDecimal bigDecimal = BigDecimal.valueOf(508.820);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2);
        System.out.println(bigDecimal1.doubleValue());
        System.out.println(map.toString());
        log.info(map.toString());
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<Integer> list = Arrays.asList(1, 2, 3, 12, 32, 322, 32323, 11, 245, 5556);
        ProcessMetricTask task = new ProcessMetricTask(list);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }


}

class ProcessMetricTask extends RecursiveTask<Integer> {
    private int threshold = 2;
    private List<Integer> records;

    public ProcessMetricTask(List<Integer> records) {
        this.records = records;
        System.out.println(this.getClass() + "" + ProcessMetricTask.class);
    }

    @Override
    protected Integer compute() {
        // 任务数小于阈值
        if (records.size() < threshold) {
            return execute(records);
        }
        // 任务数大于等于阈值
        int size = records.size();
        // 分成两个子任务
        ProcessMetricTask firstTask = new ProcessMetricTask(records.subList(0, size / 2));
        ProcessMetricTask secondTask = new ProcessMetricTask(records.subList(size / 2, size));
        invokeAll(firstTask, secondTask);
        return firstTask.join() + secondTask.join();
    }

    /**
     * 具体执行函数
     */
    private int execute(List<Integer> records) {
        System.out.println("插入了：" + Arrays.toString(records.toArray()));

        return records.size();
    }
}
