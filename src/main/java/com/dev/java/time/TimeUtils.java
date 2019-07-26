package com.dev.java.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

import com.dev.java.enums.TimeTntervalEnum;

/**
 * @author: developer
 * @date: 2018/8/26 22:40
 * @description: java8时间api使用
 */

public class TimeUtils {

    private TimeUtils() {
    }

    /**
     * LocalDateTime=>Date
     *
     * @param localDateTime 输入时间
     * @return
     */
    private static Date localDateTime2Date(LocalDateTime localDateTime) {

        if (localDateTime == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();

        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        return Date.from(zdt.toInstant());
    }

    /**
     * Date->LocalDateTime
     *
     * @param date 输入时间
     * @return
     */
    private static LocalDateTime date2LocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * 获取某天的开始时间 yyyy-MM-dd 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartOfDay(Date date) {

        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date2LocalDateTime(date);
        LocalDateTime tmpLocalDateTime = localDateTime.toLocalDate().atStartOfDay();

        return localDateTime2Date(tmpLocalDateTime);
    }

    /**
     * 获取某天的结束时间 yyyy-MM-dd 23:59:59
     *
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {

        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date2LocalDateTime(date);
        LocalDateTime tmpLocalDateTime = localDateTime.withHour(23).withMinute(59).withSecond(59);

        return localDateTime2Date(tmpLocalDateTime);
    }

    /**
     * 获取月初开始时间 yyyy-MM-01 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getStartOfMonthDay(Date date) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date2LocalDateTime(date);
        LocalDateTime tmpLocalDateTime = LocalDate.of(localDateTime.getYear(), localDateTime.getMonth(), 1).atStartOfDay();

        return localDateTime2Date(tmpLocalDateTime);
    }

    /**
     * 获取月末时间 注意平闰年的判断
     *
     * @param date
     * @return
     */
    public static Date getEndOfMonthDay(Date date) {
        if (date == null) {
            return null;
        }

        LocalDateTime tmpDateTime = date2LocalDateTime(date);

        //这里获取一个月的最大天数，进行了平闰年的判断
        int days = tmpDateTime.getMonth().length(tmpDateTime.toLocalDate().isLeapYear());

        LocalDateTime tmpLocalDateTime = tmpDateTime.withDayOfMonth(days).withHour(23).withMinute(59).withSecond(59);

        return localDateTime2Date(tmpLocalDateTime);
    }


    /**
     * 获取时间间隔
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param calFlag   计算标志
     * @return
     */
    public static Long betweenTime(Date startDate, Date endDate, int calFlag) {

        if (startDate == null || startDate == null) {
            return null;
        }

        LocalDateTime tmpStartDate = date2LocalDateTime(startDate);
        LocalDateTime tmpEndDate = date2LocalDateTime(endDate);

        Long between = null;
        if (calFlag == TimeTntervalEnum.CAL_SECONDS.getIndex()) {
            between = ChronoUnit.SECONDS.between(tmpStartDate, tmpEndDate);
        }
        if (calFlag == TimeTntervalEnum.CAL_MINUTES.getIndex()) {
            between = ChronoUnit.MINUTES.between(tmpStartDate, tmpEndDate);
        }
        if (calFlag == TimeTntervalEnum.CAL_HOURS.getIndex()) {
            between = ChronoUnit.HOURS.between(tmpStartDate, tmpEndDate);
        }
        if (calFlag == TimeTntervalEnum.CAL_DAYS.getIndex()) {
            between = ChronoUnit.DAYS.between(tmpStartDate, tmpEndDate);
        }
        if (calFlag == TimeTntervalEnum.CAL_MONTHS.getIndex()) {
            between = ChronoUnit.MONTHS.between(tmpStartDate, tmpEndDate);
        }
        if (calFlag == TimeTntervalEnum.CAL_YEARS.getIndex()) {
            between = ChronoUnit.YEARS.between(tmpStartDate, tmpEndDate);
        }
        return between;
    }

    /**
     * 增加天数
     *
     * @param date
     * @param incDays
     * @return
     */
    public static Date addDays(Date date, int incDays) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date2LocalDateTime(date);
        LocalDateTime tmpLocalDateTime = localDateTime.plusDays(incDays);
        return localDateTime2Date(tmpLocalDateTime);
    }

    /**
     * 增加月
     *
     * @param date
     * @param incMonths
     * @return
     */
    public static Date addMonths(Date date, int incMonths) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date2LocalDateTime(date);
        LocalDateTime tmpLocalDateTime = localDateTime.plusMonths(incMonths);
        return localDateTime2Date(tmpLocalDateTime);

    }

    /**
     * 格式化日期
     *
     * @param date       日期
     * @param dateFormat 日期格式
     */
    public static String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(dateFormat);
        return fastDateFormat.format(date);
    }

}
