package com.ssq.demo.base.dataStructure.queue.linkQueue;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020-08-07 14:34:53
 * @Description: 链式实现队列
 */
public class LinkedQueue<T> {
    static class Node<T> {
        /**
         * 节点的结果
         */
        T data;

        /**
         * 下一个连接的节点
         */
        Node next;


        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 相当于head 带头结点的
     */
    Node front;

    /**
     * 相当于end 尾部节点
     */
    Node rear;

    /**
     * 初始化队列
     */
    public LinkedQueue() {
        front = new Node<T>();
        rear = front;
    }

    /**
     * 队列长度
     */
    public int lenth() {
        int len = 0;
        Node team = front;
        while (team != rear) {
            len++;
            team = team.next;
        }
        return len;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 入队
     *
     * @param value
     */
    public void enQueue(T value) {
        Node va = new Node<T>(value);
        rear.next = va;
        rear = va;
    }

    /**
     * 出队
     */
    public T deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("已空");
        } else {
            T va = (T) front.next.data;
            front.next = front.next.next;
            return va;
        }
    }

    @Override
    public String toString() {
        Node team = front.next;
        String va = "队头： ";
        while (team != null) {
            va += team.data + " ";
            team = team.next;
        }
        return va;
    }

}
