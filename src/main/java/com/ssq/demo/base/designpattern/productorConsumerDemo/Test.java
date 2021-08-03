package com.ssq.demo.base.designpattern.productorConsumerDemo;
/**
 * @Author 苏诗淇
 * @Date 2020/6/2 20:44
 * @Description: 生产消费者测试
 */
public class Test {
    public static void main(String[] args) {
        DepositoryTest depositoryTest = new DepositoryTest();
        ConsumerTest consumerTest = new ConsumerTest(depositoryTest);
        ProductorTest productorTest = new ProductorTest(depositoryTest);
        new Thread(consumerTest).start();
        new Thread(productorTest).start();
    }
}
