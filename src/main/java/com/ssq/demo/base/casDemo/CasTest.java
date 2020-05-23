package com.ssq.demo.base.casDemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/20 7:46 下午
 * @Description: 基于CAS延伸的乐观锁思想
 */
public class CasTest {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i<2; i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            for (int j = 0; j<500; j++){
                                synchronized (CasTest.class) {
                                    count++;
                                }
                            }
                        }
                    }
            ).start();
            Thread thread = new Thread();
            thread.join();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
