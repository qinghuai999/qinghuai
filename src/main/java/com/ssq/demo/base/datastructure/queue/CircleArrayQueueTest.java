package com.ssq.demo.base.datastructure.queue;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-03 15:21:12
 * @Description: 循环队列
 */
public class CircleArrayQueueTest {
    private String[] arrays;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    /**
     * 队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        if ((tail + 1) % n == head) {
            return true;
        }
        return false;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 判断队列是否已满
        if (isFull()) {
            return false;
        }
        arrays[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        // 判断队列是否已空
        if (isEmpty()) {
            return null;
        }
        String temp = arrays[head];
        head = (head + 1) % n;
        return temp;
    }
}
