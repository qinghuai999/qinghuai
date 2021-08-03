package com.ssq.demo.base.javabase.classdemo;

/**
 * 内部类 --> 定义方法
 * @Author: sushiqi
 * @Description:
 * @Date: 11:20 上午 2020/5/16
 */
public class ClassDemo {

    class ClassDemo1{
        public int i= 1;
        class jiu{

        }
    }

    class ClassDemo2{
        public int i = 9;
    }

    class add extends ClassDemo1.jiu{
        add(ClassDemo1 classDemo1){
            classDemo1.super();
        }

    }

    public static void main(String[] args) {
        // new 一个外部类
        ClassDemo classDemo = new ClassDemo();
        // 然后在调用内部类
        ClassDemo.ClassDemo1 demo1 = classDemo.new ClassDemo1();
        demo1.i++;
    }
}
