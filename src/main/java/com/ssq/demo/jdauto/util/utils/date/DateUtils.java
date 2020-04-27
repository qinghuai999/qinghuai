package com.ssq.demo.jdauto.util.utils.date;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * @author 王守钰
 * @program jdauto-common
 * @date 2020年04月19日20:47:42
 * @description: 日期工具类
 */
public class DateUtils {

    private DateUtils() {
    }

    public static final String DATE_SHORT_FORMAT = "yyyyMMdd";
    public static final String DATE_CH_FORMAT = "yyyy年MM月dd日";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_MONTH_FORMAT = "yyyy-MM";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String DAYTIME_START = "00:00:00";
    public static final String DAYTIME_END = "23:59:59";


    /**
     * 当天开始时间
     * @return
     */
    public static Date dayStart(){
        return dayStart(null);
    }

    /**
     * 一天开始时间
     * @param date
     * @return
     */
    public static Date dayStart(Object date){
        DateTime dateTime = null;
        if(null == date){
            dateTime = new DateTime();
        }else{
            dateTime = new DateTime(date);
        }
        return dateTime.withTime(0,0,0,0).toDate();
    }

    /**
     * 当天结束时间
     * @return
     */
    public static Date dayEnd(){
        return dayEnd(null);
    }

    /**
     * 一天结束时间
     * @param date
     * @return
     */
    public static Date dayEnd(Object date){
        DateTime dateTime = null;
        if(null == date){
            dateTime = new DateTime();
        }else{
            dateTime = new DateTime(date);
        }
        return dateTime.withTime(23,59,59,999).toDate();
    }
}
