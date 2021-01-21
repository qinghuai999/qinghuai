package com.ssq.demo.base.javabase.interfaceDemo;
/**
 * @Author: sushiqi
 * @Description:
 * @Date: 11:20 上午 2020/5/16
 * JDK1.8 接口默认方法和静态方法
 */
public interface TestInterface2 {

    default void methodDemo2(){
        System.out.println("这是另一个冲突接口");
    }
}
