package com.ssq.demo.base.thread;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020-10-24 14:20:54
 * @Description: 线程的两种继承方式 -
 *                  继承Thread类
 */
public class ExtendThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " --- " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " --- " + i);
            if (i == 5) {
                new ExtendThread().start();
                new ExtendThread().start();
            }
        }
    }
}
