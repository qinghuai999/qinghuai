package com.ssq.demo.jdauto.util.utils.number;

import java.math.BigDecimal;

/**
 * @author 王守钰
 * @program dms-auth
 * @date 2020年04月19日20:49:50
 * @description: 精度数学加减乘除
 */
public class ArithUtils {

    /**
     * 除法精度（除不尽时保留10为小数）
     */
    private static final int DIV_SCALE = 10;

    /**
     * 小数精确加法
     * @param d1
     * @param d2
     * @return
     */
    public static double add(double d1,double d2) {
        BigDecimal bd1 = BigDecimal.valueOf(d1);
        BigDecimal bd2 = BigDecimal.valueOf(d2);
        return bd1.add(bd2).doubleValue();
    }

    /**
     * 小数精确减法
     * @param d1 被减数
     * @param d2 减数
     * @return
     */
    public static double sub(double d1,double d2) {
        BigDecimal bd1 = BigDecimal.valueOf(d1);
        BigDecimal bd2 = BigDecimal.valueOf(d2);
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * 小数精确乘法
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1,double d2) {
        BigDecimal bd1 = BigDecimal.valueOf(d1);
        BigDecimal bd2 = BigDecimal.valueOf(d2);
        return bd1.multiply(bd2).doubleValue();
    }

    /**
     * 小数精确除法
     * @param d1 被除数
     * @param d2 除数
     * @param scale 保留小数位数
     * @return
     */
    public static double div(double d1,double d2, int scale) {
        BigDecimal bd1 = BigDecimal.valueOf(d1);
        BigDecimal bd2 = BigDecimal.valueOf(d2);
        /*
         * 当除不尽时，以四舍五入的方式（关于除不尽后的值的处理方式有很多种）保留小数点后scale位小数
         */
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 小数精确除法
     * @param d1
     * @param d2
     * @return
     */
    public static double div(double d1,double d2) {
        return div(d1, d2, DIV_SCALE);
    }
}
