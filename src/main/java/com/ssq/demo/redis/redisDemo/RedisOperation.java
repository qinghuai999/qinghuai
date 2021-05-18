package com.ssq.demo.redis.redisDemo;

import com.google.common.collect.Lists;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-01-30 16:28:01
 * @Description: Redis操作 - 数据类型
 */
public class RedisOperation {

    public static void main(String[] args) {
        Calendar endCalender = Calendar.getInstance();
        endCalender.add(Calendar.DATE, -1);
        endCalender.set(Calendar.HOUR_OF_DAY, 23);
        endCalender.set(Calendar.MINUTE, 59);
        endCalender.set(Calendar.SECOND, 59);
        endCalender.set(Calendar.MILLISECOND, 999);
        System.out.println(endCalender.getTime());
    }
}
