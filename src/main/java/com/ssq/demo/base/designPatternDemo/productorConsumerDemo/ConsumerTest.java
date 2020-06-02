package com.ssq.demo.base.designPatternDemo.productorConsumerDemo;

public class ConsumerTest implements Runnable{

    // 引用仓库
    private DepositoryTest depositoryTest;

    // 创建有参构造
    public ConsumerTest(DepositoryTest depositoryTest) {
        this.depositoryTest = depositoryTest;
    }

    @Override
    public void run() {
        for (int i = 0; i < depositoryTest.pro().length; i++){
            String consumer = depositoryTest.pop();
            System.out.println("消费了: " + consumer);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
