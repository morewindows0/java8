package com.developer.jdk8.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 15:33
 * @description:
 */
public class SynThread1 extends Thread {

    private Task task;

    public SynThread1(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        SynThread1 thread1 = new SynThread1(task);
        thread1.setName("A");
        thread1.start();

        SynThread2 thread2 = new SynThread2(task);
        thread2.setName("B");
        thread2.start();

        Thread.sleep(10000);

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }
        System.out.println("耗时：" + (endTime - beginTime) / 1000);


        /*
        begin task
        begin task
        长时间处理任务后获取的值1 threadname=B
        长时间处理任务后获取的值2 threadname=A
        end task
        长时间处理任务后获取的值1 threadname=A
        长时间处理任务后获取的值2 threadname=A
        end task
        耗时：3
        虽然耗时减少了，但是这里出现了脏读的情况
        但是通过synchronized还是可以缩短执行的时间，不需要所有全部同步
        */

    }
}

class
SynThread2 extends Thread {
    private Task task;

    public SynThread2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
