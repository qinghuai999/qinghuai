package com.ssq.demo.base.multiThreadingDemo;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020-10-26 16:01:18
 * @Description: 线程的两种继承方式 -
 * 实现Runnable接口
 */
public class ImplementRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            if (i == 20) {
                ImplementRunnable runnable = new ImplementRunnable();
                new Thread(runnable, "新线程-1").start();
                new Thread(runnable, "新线程-2").start();
            }
        }
    }
}
