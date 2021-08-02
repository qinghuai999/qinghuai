package com.ssq.demo.base.dataStructure.queue;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-02 20:02:36
 * @Description: 顺序队列
 */
public class ArrayQueue {
    /**
     * 数组
     */
    private String[] items;

    /**
     * 数组大小
     */
    private int n = 0;

    /**
     * head表示队头下标
     */
    private int head = 0;

    /**
     * tail表示队尾下标
     */
    private int tail = 0;

    /**
     * 申请一个大小为capacity的数组
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队 [考虑头和尾都到了最右边,但头部还有空余的空间,使用数据迁移]
     *      时间复杂度: O(1)
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 若队尾下标等于数组大小,说明该队列末尾已满
        if (tail == n) {
            // 判断队头是否还有空闲
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
            // 重新更新tail和head的值
            tail-=head;
            head = 0;
        }
        // 将元素插入队尾
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        // 如果head == tail,表示队列为空
        if (head == tail) {
            return null;
        }
        // 取出队头元素
        String tem = items[head];
        ++head;
        return tem;
    }

}
