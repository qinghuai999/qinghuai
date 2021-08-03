package com.ssq.demo.base.javabase.fordemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-05-18 18:57:49
 * @Description: for循环与递归
 */
public class ForAndRecursion {
    public static void main(String[] args) {
        // 开始打点时间
        long startTime = System.currentTimeMillis();

        // 测试代码
        for (int i = 0; i <= 3000; i++) {
            System.out.println(i + "\n");
        }

        // 结束打点时间
        long endTime = System.currentTimeMillis();

        // 程序运行时间
        double differ = endTime - startTime;

        // 开始打点时间
        long startTime1 = System.currentTimeMillis();
        // 递归
        recursion(3000);

        // 结束打点时间
        long endTime1 = System.currentTimeMillis();

        // 程序运行时间
        double differ1 = endTime1 - startTime1;
        System.out.println("for循环执行时间为: " + differ + "ms");
        System.out.println("递归执行时间为: " + differ1 + "ms");

    }

    /**
     * 递归
     */
    public static void recursion(int n) {
        if (n == 1) {
            System.out.println(n + "\n");
            return ;
        } else {
            System.out.println(n + "\n");
            recursion(n - 1);
        }
    }
}
