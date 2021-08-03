package com.ssq.demo.base.aopdemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/26 7:08 下午
 * @Description: 通知类
 */
public class MyAspect {

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}
