package com.dev.java.thread.chapter02.syn;

/**
 * @author: dengxin.chen
 * @date: 2018/11/9 15:16
 * @description: 利用同步代码块来优化同步方法
 */
public class Task {
    private String getData1;
    private String getData2;

    public /*synchronized*/ void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String tmpData1 = "长时间处理任务后获取的值1 threadname=" + Thread.currentThread().getName();
            String tmpData2 = "长时间处理任务后获取的值2 threadname=" + Thread.currentThread().getName();
            synchronized (this) {
                getData1 = tmpData1;
                getData2 = tmpData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
