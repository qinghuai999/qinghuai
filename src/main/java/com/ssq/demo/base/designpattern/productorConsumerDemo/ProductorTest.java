package com.ssq.demo.base.designpattern.productorConsumerDemo;
/**
 * @Author 苏诗淇
 * @Date 2020/6/2 13:28
 * @Description: 生产者消费者模式之创建生产者
 */
public class ProductorTest implements Runnable{

    // 引用仓库
    private DepositoryTest depositoryTest;

    // 创建有参构造
    public ProductorTest(DepositoryTest depositoryTest) {
        this.depositoryTest = depositoryTest;
    }

    // 重写runable接口,开启线程
    @Override
    public void run() {
        for (int i = 0; i < depositoryTest.pro().length; i++){
            // 从数组中取出数量,定义消息
            String producter = "产品: " + i;
            // 发送消息
            depositoryTest.push(producter);
            System.out.println("生产了:" + producter);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
