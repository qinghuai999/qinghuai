package com.ssq.demo.base.datatype.stringdemo;

public class StringInterviewTest {
    public static void main(String[] args) {

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        final String f = getHello();
        String c = b + 2;
        String e = d + 2;
        String g = f + 2;
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println(a == g);
    }
    public static String getHello() {
        return "hello";
    }
}
