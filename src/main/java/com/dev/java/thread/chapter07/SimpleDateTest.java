package com.dev.java.thread.chapter07;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 17:08
 * @description: SimpleDateFormat线程不安全，用FastDateFormat进行代替
 */
public class SimpleDateTest extends Thread {
    private SimpleDateFormat simpleDateFormat;
    private String dateString;

    private FastDateFormat fastDateFormat;

    public SimpleDateTest(FastDateFormat fastDateFormat, String dateString) {
        this.fastDateFormat = fastDateFormat;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date date = fastDateFormat.parse(dateString);
            String newDateString = fastDateFormat.format(date).toString();
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName=" + this.getName() + "日期转换出错：" + dateString + "转换成了" + newDateString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        String[] dateStringArray = {"2000-01-01", "2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06"};

        SimpleDateTest[] threadArray = new SimpleDateTest[7];

        for (int i = 0; i < 7; i++) {
            //如果使用共享的SimpleDateFormat会出现线程安全问题，于是可以为每个线程新增一个SimpleDateFormat对象
            //但是这样开销会比较大
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            threadArray[i] = new SimpleDateTest(fastDateFormat, dateStringArray[i]);
        }
        for (int i = 0; i < 7; i++) {
            threadArray[i].start();
        }
    }
}
