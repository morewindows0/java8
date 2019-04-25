package com.dev.java.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author: dengxin.chen
 * @date: 2018/8/27 16:12
 * @description:数学计算相关函数
 */
public class MathUtils {
    /**
     * double数据类型相加
     * 解决double相加多小数问题
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double doubleAdd(double v1, double v2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.add(bd2).doubleValue();
    }

    /**
     * double数据类型相减
     *
     * @param v1 被减数
     * @param v2 减数
     * @return
     */
    public static double doubleSub(double v1, double v2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * double数据类型相乘
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double doubleMul(double v1, double v2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(v1));
        BigDecimal bd2 = new BigDecimal(Double.toString(v2));
        return bd1.multiply(bd2).doubleValue();
    }

    /**
     * double数据类型相除 四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 保留几位小数
     * @return
     */
    public static double doubleDiv(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        /**
         * 改变ROUND_HALF_UP参数可改变是否进行四舍五入
         */
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留两位小数 最后一位直接舍去
     *
     * @param value 传入值
     * @return
     */
    public static String keepTwoDecimals(Double value) {
        if (value == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        //通过调整参数可控制是否进行四舍五入
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(value);
    }

    /**
     * 将BigDecimal转换成比分数
     *
     * @param value
     * @return
     */
    public static String bigDecimal2Percent(BigDecimal value) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(5); //这里设置保留百分数的位数
        String result = numberFormat.format(value).replace("%", "");//这里去除百分号
        return result;
    }

}
