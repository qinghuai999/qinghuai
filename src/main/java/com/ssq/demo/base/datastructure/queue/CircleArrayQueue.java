package com.ssq.demo.base.datastructure.queue;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020-08-08 14:13:59
 * @Description: 循环数组实现队列
 */
public class CircleArrayQueue<T> {
    /**
     * 数组容器
     */
    private T[] data;

    /**
     * 头
     */
    private int front;

    /**
     * 尾
     */
    private int rear;

    /**
     * 最大长度
     */
    private int maxsize;

    /**
     * 队列长度及参数初始化
     *
     * @param i
     */
    public CircleArrayQueue(int i) {
        data = (T[]) new Object[i + 1];
        front = 0;
        rear = 0;
        maxsize = i + 1;
    }

    /**
     * 队列元素个数
     *
     * @return
     */
    public int length() {
        return (rear + maxsize - front) % maxsize;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 队列是否占满
     */
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    /**
     * 入队
     */
    public void enQueue(T i) throws Exception {
        if (isFull()) {
            throw new Exception("该队列已满");
        } else {
            data[rear] = i;
            rear = (rear + 1) % maxsize;
        }
    }

    /**
     * 出队
     */
    public T deQueue() throws Exception{
        if (isEmpty()){
            throw new Exception("队列已空");
        } else {
            T va = data[front];
            front = (front + 1) % maxsize;
            return va;
        }
    }

    /**
     * 输出队列
     */
    @Override
    public String toString(){
        String va = "队头";
        int length = length();
        for (int i = 0; i < length; i++){
            va += data[(front + i) % maxsize] + "";
        }
        return va;
    }


}
