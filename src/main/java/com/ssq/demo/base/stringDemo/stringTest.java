package com.ssq.demo.base.stringDemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/18 5:12 下午
 * @Description: String常量和两种变量
 */
public class stringTest {
    StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        int k = 0;
        k  = k++ + ++k + k++ + ++k;
        System.out.println(k);
    }
}