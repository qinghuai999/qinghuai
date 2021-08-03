package com.ssq.demo.base.datastructure.linkedlist;

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
     * 递归法
     *       - 原:正向遍历整个链表,取到链表最后一个结点做头结点
     *       - 现:没理解递归是怎么把结点返回去的,暂时挂起
     * @param linkedList
     * @return
     */
    public static Node reverseByRecursion(Node linkedList) {
        if (null == linkedList || null == linkedList.next) {
            return linkedList;
        }
        Node temp = linkedList.next;
        // 遍历正序链表
        Node newHead = reverseByRecursion(linkedList.next);
        temp.next = linkedList;
        // 只保留链表中的当前节点元素,与后续节点断开连接[抛弃]
        linkedList.next = null;
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
     * 反转链表 --> 遍历法
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
        while (null != linkedList) {
            nextNode = linkedList.next;
            linkedList.next = prevNode;
            prevNode = linkedList;
            linkedList = nextNode;
        }
        return prevNode;
    }

    /**
     * 反转链表 --> 递归法
     *      递归概念: 从开始遍历到结尾,再从结尾回到开始
     *          递归会将每一次调用自己的数据暂存到内存中,直到找到出口,在从最后一个开始循环回到第一个
     *      递归运行机制:
     *          1.从开始调用自己,直到满足结束递归的出口条件,跳出循环,本次递归数据随着返回值出栈
     *          2.拿到上一个栈的数据执行递归之后的逻辑代码,直到将所有的栈都处理完成.
     *      递归反转逻辑:
     *          1.从头开始遍历链表,直到找到最后一个元素
     *          2.返回最后一个元素值
     *          3.从栈中取出上一个节点值,反转链表 [让链表头结点的指针指向下下个,断开头节点与下个节点的联系]
     *          4.循环到所有节点出栈
     *      图解:
     *          入栈1: 1->2->3->4->5->null
     *          入栈2: 2->3->4->5->null
     *          入栈3: 3->4->5->null
     *          入栈4: 4->5->null
     *          入栈5: 5->null
     *          出栈5: 找到递归出口的返回值,返回链表 linkedList = 5->null
     *          出栈4: linkedList 4->5->null
     *                 新节点 = linkedList.next = 5
     *                 head.next.next [4.next.next = null]
     *                 此时将head赋值下下个指针,head.next.next = 4
     *                 head.next = null  [4->5变为4 5 两个节点断开了]
     *                 返回新节点: 5
     *          出栈3: linkedList 3->4->null
     *                 新节点 = linkedList.next = 4
     *                 head.next.next = 3
     *                 head.next = null [3->4变为3 4 两个节点又断开了]
     *                 返回新结点: 5->4
     *          出栈2: 按上述步骤类推即可
     *
     * @param linkedList
     * @return
     */
    public Node2 newAddReverse(Node2 linkedList) {
        if (null == linkedList || null == linkedList.next) {
            return linkedList;
        }
        Node2 newHead = newAddReverse(linkedList.next);
        System.out.println(newHead);
        linkedList.next.next = linkedList;
        linkedList.next = null;
        System.out.println(linkedList);
        return newHead;
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
//        Node2 reverseList = reverseLinkedList.newQueryReverse(reverseLinkedList.head);
//        // 遍历法
//        while (null != reverseList) {
//            System.out.println(reverseList.data);
//            reverseList = reverseList.next;
//        }
        // 递归法
        Node2 reverseList = reverseLinkedList.newAddReverse(reverseLinkedList.head);
        while (null != reverseList) {
            System.out.println(reverseList.data);
            reverseList = reverseList.next;
        }

    }
}
