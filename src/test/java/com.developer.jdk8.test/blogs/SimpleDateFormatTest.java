package com.developer.jdk8.test.blogs;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @author: dengxin.chen
 * @date: 2018/11/20 18:09
 * @description:SimpleDateFormat非线程安全
 */
public class SimpleDateFormatTest extends Thread {

//    private SimpleDateFormat sdf;

    private FastDateFormat fastDateFormat;

    private String dateString;

    public SimpleDateFormatTest(FastDateFormat fdf, String dateString) {
        this.fastDateFormat = fdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
//            Date date = fastDateFormat.parse(dateString);
            Date date = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse(dateString);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        String[] dateStringArray = {"2001-01-01", "2001-01-01", "2001-01-01", "2001-01-01", "2001-01-01"};

        SimpleDateFormatTest[] threadArray = new SimpleDateFormatTest[5];

        for (int i = 0; i < 5; i++) {
            threadArray[i] = new SimpleDateFormatTest(fastDateFormat, dateStringArray[i]);
        }
        for (int i = 0; i < 5; i++) {
            threadArray[i].start();
        }
    }
}
