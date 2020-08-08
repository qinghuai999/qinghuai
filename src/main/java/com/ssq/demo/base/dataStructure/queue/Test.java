package com.ssq.demo.base.dataStructure.queue;

import com.ssq.demo.base.dataStructure.queue.arrayQueue.SeqQueue;
import com.ssq.demo.base.dataStructure.queue.linkQueue.LinkedQueue;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020-08-08 16:32:58
 * @Description:  队列测试
 */
public class Test {
    public static void main(String[] args) throws Exception{
        SeqQueue<String> seqQueue = new SeqQueue<>(4);
        seqQueue.enQueue("淇");
        seqQueue.enQueue("家");
        seqQueue.enQueue("小");
        seqQueue.enQueue("宝");
        System.out.println(seqQueue.length());
        System.out.println(seqQueue.toString());
        System.out.println(seqQueue.deQueue());
        System.out.println("-------------------");

        LinkedQueue<String> linkQueue = new LinkedQueue<>();
        linkQueue.enQueue("久");
        linkQueue.enQueue("音");
        linkQueue.enQueue("阿");
        linkQueue.enQueue("淇");
        linkQueue.enQueue("话");
        System.out.println(linkQueue.deQueue());
        System.out.println(linkQueue.deQueue());
        linkQueue.enQueue("啾");
        linkQueue.enQueue("21");
        System.out.println(linkQueue.lenth());
        System.out.println(linkQueue.toString());

    }
}
