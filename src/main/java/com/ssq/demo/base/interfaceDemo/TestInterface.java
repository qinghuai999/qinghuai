package com.ssq.demo.base.interfaceDemo;
/**
 * @Author: sushiqi
 * @Description:
 * @Date: 11:20 上午 2020/5/16
 * JDK1.8 接口默认方法和静态方法
 */
public interface TestInterface {

    void methodDemo(String name);

    void methodDemo4(String name);

    /**
     * 默认方法
     */
    default void methodDemo2(){
        System.out.println("999");
    }

    /**
     * 静态方法
     */
    static boolean methodDemo3(){
        System.out.println(1);
        return true;
    }

}
