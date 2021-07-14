package com.ssq.demo.base.dataStructure.linkedList;

import lombok.Data;

import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-01-11 18:37:34
 * @Description: 基于单链表实现的LRU缓存淘汰算法
 * LRU -- 最少使用策略
 */
public class LruCacheMiniVisits<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 无参构造初始化指针,链表初始容量和初始长度
     */
    public LruCacheMiniVisits() {
        this.headNode = new SNode();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    /**
     * 有参构造初始化指针,指定容量和初始长度
     * @param capacity
     */
    public LruCacheMiniVisits(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        // 链表中存在,删除原数据,在插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 链表头部插入结点
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        // 给node赋头结点的值
        SNode node = headNode;
        // 若头结点的下一个结点不为空时
        while (node.getNext() != null) {
            // 如果当前数据与头结点的下一节点元素一样
            if (data.equals(node.getNext().getElement())) {
                // 则返回该结点
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }
        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.println(node.getElement() + ", ");
            node = node.getNext();
        }
        System.out.println();
    }

    @Data
    public class SNode<T> {
        private T element;

        private SNode next;

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public SNode(T element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        LruCacheMiniVisits list = new LruCacheMiniVisits();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }


}
