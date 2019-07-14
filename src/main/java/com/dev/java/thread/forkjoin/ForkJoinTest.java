package com.dev.java.thread.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author: developer
 * @date: 2019/5/6 21:52
 * @description: forkJoin测试
 */

public class ForkJoinTest {

    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<Integer> list = Arrays.asList(1, 2, 3,12,32,322,32323,11,245,5556);
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