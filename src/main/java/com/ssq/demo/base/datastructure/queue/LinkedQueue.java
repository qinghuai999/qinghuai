package com.ssq.demo.base.datastructure.queue;

import lombok.Data;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-02 20:27:52
 * @Description: 链表实现一个队列
 */
public class LinkedQueue<T> {
    /**
     * 创建一个Node结构
     */
    @Data
    class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
        }
    }
    /**
     * 创建一个头结点
     */
    private Node head = null;
    /**
     * 创建一个尾结点
     */
    private Node tail = null;

    /**
     * 入队
     *      最后为啥要给尾结点多赋个值?
     *          尾指针永远要指向最后一个,所以要给tail重新赋值
     * @param data
     * @return
     */
    public void enqueue(String data) {
        Node nowNode = new Node(data);
        // 判断队列是否为空
        if (null == tail) {
            head = nowNode;
            tail = nowNode;
        } else {
            tail.next = nowNode;
            tail = tail.next;
        }
    }

    public String dequeue() {
        // 判断头结点是否为空
        if (null == head) {
            return null;
        }
        // 取出要出队的节点元素
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("啊");
        linkedQueue.enqueue("西");
        linkedQueue.enqueue("巴");
    }
}
