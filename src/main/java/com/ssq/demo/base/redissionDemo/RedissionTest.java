package com.ssq.demo.base.redissionDemo;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RedissonClient;

import java.util.ArrayList;
import java.util.List;

public class RedissionTest {

    @Test
    public void test(){
        List list = new ArrayList<>(0);
        list.add(1);
        list.add(2);
        System.out.println(list);
    }

    public static void main(String[] args) {
//        RedissonClient redissonClient;
//        Redisson redisson;
//        RedissonLock redissonLock;
        List list = new ArrayList<>(0);
        list.add(1);
        System.out.println(list);
    }
}
