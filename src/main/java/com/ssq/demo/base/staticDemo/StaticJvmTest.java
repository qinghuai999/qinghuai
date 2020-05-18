package com.ssq.demo.base.staticDemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/16 11:48 上午
 * @Description: 静态变量/方法和jvm方法区关系
 */
public class StaticJvmTest {
    // 静态变量 --> 方法区
    static String firstName;

    // 成员变量 --> 堆
    String lastName;

    // 普通方法
    public void showName(){
        System.out.println(firstName + lastName);
    }

    // 静态方法 --> 方法区
    public static void viewName(){
        System.out.println(firstName);
    }

    public static void main(String[] args) {
        // StaticJvmTest --> 堆里   staticJvmTest --> 对象的引用 在栈
        StaticJvmTest staticJvmTest = new StaticJvmTest();
        StaticJvmTest.firstName = "淇";
        staticJvmTest.lastName = "话";
        staticJvmTest.showName();

        StaticJvmTest jvmTest = new StaticJvmTest();
        StaticJvmTest.firstName = "jiu";
        jvmTest.lastName = "999";
        jvmTest.showName();


    }
}
