package com.ssq.demo.base.staticDemo;

public class StaticSonTest extends StaticFatherTest{

    // 这是子类静态代码块
    static {
        System.out.println("子类静态代码块");
    }

    private static String id = "999";

    // 构造方法
    public StaticSonTest() {
        System.out.println("这是子类无参构造");
    }


    public static void main(String[] args) {
        new StaticSonTest();
    }
}
