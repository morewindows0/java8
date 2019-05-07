package com.dev.java.thread.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 14:18
 * @description:Timer定时类测试
 */
public class TimerTest {
    //控制是否为守护线程，通过构造函数
    private static Timer timer = new Timer();

    public static class MyTask1 extends TimerTask {

        @Override
        public void run() {
            System.out.println("A运行了！时间为" + new Date());
        }
    }

    //TimerTask是以队列的方式一个一个被顺序执行的
    public static class MyTask2 extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了！时间为" + new Date());
        }
    }


    public static void main(String[] args) {

        MyTask1 task = new MyTask1();
        MyTask2 task2 = new MyTask2();


        timer.schedule(task, 5000);
        timer.schedule(task2, new Date(1542695775000L), 3000);

    }

}
