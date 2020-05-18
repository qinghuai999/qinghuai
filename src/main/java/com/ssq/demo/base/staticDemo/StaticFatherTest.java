package com.ssq.demo.base.staticDemo;

public class StaticFatherTest {
    // 父类静态代码块
    static{
        System.out.println("这是一个父类静态代码块");
    }

    // 父类构造函数

    public StaticFatherTest() {
        System.out.println("父类构造函数");
    }
}
