package com.ssq.demo.base.dataStructure.linkedList;

import lombok.Data;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-01-19 19:17:04
 * @Description: 单链表反转 - 1.递归法(本质是栈实现)  2.遍历法
 */
public class reverseLinkedList {
    /**
     * 定义指针
     * @param <T>
     */
    @Data
    static
    class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 遍历法
     *       - 置换指针顺序
     *       - 原: 1->2->3->4->5->6->null
     *       - 现: null<-1<-2<-3<-4<-5<-6
     * @param head
     * @return
     */
    public static Node reverseByLoop(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node preNode = null;
        Node nextNode = null;
        while (null != head) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }

    /**
     * TODO 递归法
     *       - 原:正向遍历整个链表,取到链表最后一个结点做头结点
     *       - 现:没理解递归是怎么把结点返回去的,暂时挂起
     * @param head
     * @return
     */
    public static Node reverseByRecursion(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node temp = head.next;
        // 遍历正序链表
        Node newHead = reverseByRecursion(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Node linkNode1 = new Node(1);
        Node linkNode2 = new Node(2);
        Node linkNode3 = new Node(3);
        Node linkNode4 = new Node(4);
        Node linkNode5 = new Node(5);
        Node linkNode6 = new Node(6);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;

        // 遍历法 - 打印反转前的链表
//        Node node1 =reverseByLoop(linkNode1);
//        while (node1!= null){
//            System.out.println(node1.data);
//            node1 = node1.next;
//        }

        // 递归法
        Node node2 = reverseByRecursion(linkNode1);
        while (node2!= null){
            System.out.println(node2.data);
            node2 = node2.next;
        }

    }
}
