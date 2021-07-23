package com.ssq.demo.datastructure.linkedlist;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-07-14 17:10:58
 * @Description: 链表单测 -->
 *                  初始化链表,添加链表元素,根据索引遍历链表元素,判断该链表中是否存在某元素,反转链表(递归法,遍历法)
 */
public class LinkedListTest1<T> {
    @Data
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;

    private int size;

    /**
     * 初始化
     */
    public void init() {
        head = new Node<T>(null, null);
        head.next = null;
        size = 0;
    }

    /**
     * 添加元素
     */
    public void addLinkedListData(T add) {
        Node<T> nowNode = new Node<>(add);
        if (0 == size) {
            head = nowNode;
            System.out.println("head: " + head.hashCode());
        } else {
            // 创建临时节点存储链表元素,遍历元素,在末尾插入新节点
            Node<T> temp = head;
            System.out.println("temp: " + temp.hashCode());
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = nowNode;
        }
        size++;
    }

    /**
     * 通过下标遍历元素
     *
     * @param i
     * @param linkedList
     * @return
     */
    public Object queryLinkedListByIndex(int i, Node<T> linkedList) {
//        Node temp = new Node(linkedList);
        // 1.判断该链表是否为空
        if (0 == size) {
            return null;
        }
        // 2.遍历查找i=3的元素
        if (i < size && i >= 0) {
            for (int j = 1; j < i; j++) {
                linkedList = linkedList.next;
            }
            return linkedList.data;
        }
        return null;
    }

    /**
     * 查找链表中是否存在该元素
     *
     * @param data
     * @return
     */
    public Boolean queryLinkedListByData(T data, Node<T> linkedList) {
        // 1.判断该链表是否为空
        if (null == linkedList) {
            return false;
        }
        // 2.对比链表内元素是否相等
        while (!data.equals(linkedList.data)) {
            if (null == linkedList.next) {
                return false;
            }
            linkedList = linkedList.next;
        }
        return true;
    }

    /**
     * 递归方法一,通过断开指针倒序排列
     *
     * @param linkedList
     * @return
     */
    public Node recursionReverse(Node linkedList) {
        // 给出退出递归的条件
        if (null == linkedList || null == linkedList.next) {
            return linkedList;
        }
        // 递归遍历链表取到最后一个元素
        Node newNode = recursionReverse(linkedList.next);
        // 递归完成后,开始反转链表
        linkedList.next.next = linkedList;
        linkedList.next = null;
        return newNode;
    }

    /**
     * 递归方法二,调换元素位置完成反转
     *
     * @param linkedList
     * @return
     */
    public Node recursionReverse1(Node linkedList) {
        if (null == linkedList || null == linkedList.next) {
            return linkedList;
        }
        Node temp = linkedList.next;
        // 递归
        Node newNode = recursionReverse1(linkedList.next);
        // 开始反转,temp临时结点存储linkedList的值,使链表两个元素互换位置
        temp.next = linkedList;
        linkedList.next = null;
        return newNode;
    }

    public Node<T> queryReverse(Node<T> linkedList) {
        // 判断该链表是否只存在一个节点或没有节点
        if (null == linkedList || null == linkedList.next) {
            return linkedList;
        }
        // 创建前后指针节点
        Node<T> prevNode = null;
        Node<T> nextNode;
        // 遍历链表,从第一个元素开始反转
        while (null != linkedList.next) {
            nextNode = linkedList.next;
            linkedList.next = prevNode;
            prevNode = linkedList;
            linkedList = nextNode;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        LinkedListTest1<String> linkedClass = new LinkedListTest1<>();
        linkedClass.init();
        linkedClass.addLinkedListData("什");
        linkedClass.addLinkedListData("么");
        linkedClass.addLinkedListData("都");
        linkedClass.addLinkedListData("不");
        linkedClass.addLinkedListData("懂");
//        System.out.println(linkedClass.head);
        // 递归反转
//        linkedClass.queryReverse(linkedClass.head);
//        System.out.println(linkedClass.head);
//        Object o = linkedClass.queryLinkedListByIndex(3, linkedClass.head);

        Boolean str = linkedClass.queryLinkedListByData("都", linkedClass.head);
        System.out.println(str);

    }
}
