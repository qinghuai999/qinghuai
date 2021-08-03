package com.ssq.demo.base.designpattern.productorConsumerDemo;
/**
 * @Author 苏诗淇
 * @Date 2020/6/2 13:33
 * @Description: 生产消费者模式之中间件 --> 仓库
 */
public class DepositoryTest {
    // 创建一个数组存放消息
    private String[] strings = new String[10];

    private int index;

    /**
     * 供生产者调用 --> 生产者传输消息至仓库
     * @param sst
     */
    public synchronized void push(String sst){
        if (index == sst.length()) {
            try {
                // 当仓库满时,让线程休眠
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 仓库未满时,则唤醒在此对象监视器上等待的单个线程
        this.notify();
        // 然后把sst的值赋给数组下标为index的变量
        strings[index] = sst;
        // 防止sst的值被覆盖,让数组下标+1
        index ++;
    }

    /**
     * 供消费者调用 --> 消费者从仓库获取消息
     * @return product
     */
    public synchronized String pop(){
        if (index == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index --;
        String product = strings[index];
        System.out.println("生产者product:" + product);
        return product;
    }

    /**
     * 定义返回数组的方法 --> 查看该数组下的元素
     * @return
     */
    public String[] pro(){
        return strings;
    }
}
