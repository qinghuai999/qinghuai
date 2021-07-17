package com.ssq.demo.base.dataStructure.linkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-01-19 19:17:04
 * @Description: 单链表反转 - 1.递归法(本质是栈实现)  2.遍历法
 */
public class ReverseLinkedList {
    private Node2 head;
    private Integer size;
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

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node2<T> {
        private T data;
        private Node2<T> next;

        public Node2(T data) {
            this.data = data;
        }
    }

    /**
     * 初始化链表
     */
    public void initStart() {
        head = new Node2(null, null);
        head.next = null;
        size = 0;
    }

    /**
     * 遍历指定元素
     * @param index
     * @return
     */
    public Node2 queryNode(int index) {
        Node2 nextNode;
        nextNode = head;
        if (index < size && index >= 0) {
            for (int q = 0; q < index; q++) {
                nextNode = nextNode.next;
            }
        }
        return nextNode;
    }

    /**
     * 添加元素
     * @param data
     */
    public <T> void add(T data) {
        // 创建一个节点存储要添加的元素值
        Node2 nowNode = new Node2(data);
        if (0 == size) {
            head = nowNode;
        } else {
            // 创建一个空节点存储链表头节点
            Node2 temp = head;
            // 如果头节点不为空
            while (null != temp.next) {
                // 一直遍历到链表末尾
                temp = temp.next;
            }
            // 将要添加的节点放到末尾节点的下一个
            temp.next = nowNode;
        }
        size++;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(queryNode(i).data);
        }
    }

    /**
     * 反转链表
     * @param linkedList
     * @return
     */
    public Node2 newQueryReverse(Node2 linkedList) {
        // 1.判断头结点或头结点的下一个元素是否为空,为空返回头结点
        if (null == linkedList || null == linkedList.next) {
            return linkedList;
        }
        // 2.定义两个节点
        Node2 prevNode = null;
        Node2 nextNode;
        while (null != head) {
            nextNode = linkedList.next;
            linkedList.next = prevNode;
            prevNode = linkedList;
            linkedList = nextNode;
        }
        return prevNode;
    }

    public static void main(String[] args) {
//        Node linkNode1 = new Node(1);
//        Node linkNode2 = new Node(2);
//        Node linkNode3 = new Node(3);
//        Node linkNode4 = new Node(4);
//        Node linkNode5 = new Node(5);
//        Node linkNode6 = new Node(6);
//        linkNode1.next = linkNode2;
//        linkNode2.next = linkNode3;
//        linkNode3.next = linkNode4;
//        linkNode4.next = linkNode5;
//        linkNode5.next = linkNode6;


        // 遍历法 - 打印反转前的链表
//        Node node1 =reverseByLoop(linkNode1);
//        while (node1!= null){
//            System.out.println(node1.data);
//            node1 = node1.next;
//        }

//        // 递归法
//        Node node2 = reverseByRecursion(linkNode1);
//        while (node2!= null){
//            System.out.println(node2.data);
//            node2 = node2.next;
//        }

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.initStart();
        reverseLinkedList.add("淇");
        reverseLinkedList.add("实");
        reverseLinkedList.add("都");
        reverseLinkedList.add("很");
        reverseLinkedList.add("好");
        reverseLinkedList.print();
        Node2 reverseList = reverseLinkedList.newQueryReverse(reverseLinkedList.head);
        while (null != reverseList) {
            System.out.println(reverseList.data);
            reverseList = reverseList.next;
        }

    }
}
