package com.ssq.demo.base.interfaceDemo;

import org.junit.Test;
/**
 * @Author: sushiqi
 * @Description:
 * @Date: 11:20 上午 2020/5/16
 * JDK1.8 接口默认方法和静态方法
 * 默认方法接口 --> 同名方法优先访问本类
 */
public class ImplomentDemo implements TestInterface,TestInterface2{
    @Override
    public void methodDemo(String name) {

    }

    @Override
    public void methodDemo4(String name) {

    }

    public void methodDemo2(){
        TestInterface2.super.methodDemo2();
    }



    @Test
    public void test(){
        ImplomentDemo implomentDemo = new ImplomentDemo();
        implomentDemo.methodDemo2();
        TestInterface.methodDemo3();
    }



}
