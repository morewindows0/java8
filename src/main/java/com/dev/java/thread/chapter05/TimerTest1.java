package com.dev.java.thread.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 15:02
 * @description:
 */
public class TimerTest1 {
    private static Timer timer = new Timer();
    private static int runCount = 0;

    public static class MyTask extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("1 begin运行了！时间为：" + new Date());
                Thread.sleep(1000);
                System.out.println("1 end运行了！时间为：" + new Date());
                runCount++;
                if (runCount == 5) {
                    timer.cancel();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        MyTask task = new MyTask();

        //理解这里的延时：循环直接的时间比程序运行的时间短 如这里的3000如果小于Thread.sleep(5000)就叫延时
//        timer.schedule(task, new Date(1542697670000L), 3000);

        timer.scheduleAtFixedRate(task,new Date(1542697670000L), 3000);

    }
}
