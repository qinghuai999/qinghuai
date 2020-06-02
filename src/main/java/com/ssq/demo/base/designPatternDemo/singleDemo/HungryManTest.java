package com.ssq.demo.base.designPatternDemo.singleDemo;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author 苏诗淇
 * @Date 2020/6/2 11:53
 * @Description: 设计模式 - 单例模式之饿汉式
 *                         不管会不会被调用，先new出来（天生线程安全）
 */
public class HungryManTest implements Runnable{
    // 不管用不用，先new出来
    private static HungryManTest hungryManTest = new HungryManTest();

    // 私有化无参构造,保证大家不能同时实例化
    private HungryManTest() {
    }

    // 定义一个方法为用户端提供类实例
    public static HungryManTest getInstance(){
        return hungryManTest;
    }

    public static void main(String[] args) {
        HungryManTest hungryManTest = new HungryManTest();
        HungryManTest hungryManTest1 = new HungryManTest();
        Thread thread = new Thread(hungryManTest);
        Thread thread1 = new Thread(hungryManTest1);
        thread.start();
        thread1.start();
    }

    @Override
    public void run() {
        System.out.println(HungryManTest.getInstance());
    }
}
