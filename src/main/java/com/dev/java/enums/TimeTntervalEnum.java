package com.dev.java.enums;

/**
 * @author: dengxin.chen
 * @date: 2018/8/27 11:27
 * @description: 时间间隔计算枚举值
 */
public enum TimeTntervalEnum {

    CAL_SECONDS(1, "计算秒间隔"),
    CAL_MINUTES(2, "计算分间隔"),
    CAL_HOURS(3, "计算小时间隔"),
    CAL_DAYS(4, "计算天间隔"),
    CAL_MONTHS(5, "计算月间隔"),
    CAL_YEARS(6, "计算月间隔"),
    CAL_OTHERS(7, "后续扩展");


    private Integer index;
    private String name;

    TimeTntervalEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

}
