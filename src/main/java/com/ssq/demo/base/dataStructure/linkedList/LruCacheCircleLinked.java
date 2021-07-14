package com.ssq.demo.base.dataStructure.linkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.security.util.Length;

import java.util.LinkedList;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-07-14 17:37:34
 * @Description: 基于循环链表实现的LRU缓存淘汰算法
 * LRU -- 最少使用策略
 */
public class LruCacheCircleLinked<T> {
    /**
     * 定义一个链表结构
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Node<T> {
        /**
         * 数据值
         */
        private T data;

        /**
         * 上一个的节点
         */
        private Node<T> prev;

        /**
         * 下一个的节点
         */
        private Node<T> next;
    }

    /**
     * 创建一个循环链表
     */
    class CircleLinkedList {
        // 链表长度
        private int size;

        // 头节点
        private Node<T> head;

        // 尾节点
        private Node<T> end;

        // 初始化链表
        public void initList() {
            // end节点的前一个是head,下一个也是head,构成了一个环
            end = new Node<>(null, null, null);
            head = new Node<>(null, null, null);
            end.prev = head;
            end.next = head;
        }

        // 获取长度
        public int linkedSize() {
            return size;
        }

        // 获取下标为index的节点元素
        public Node<T> getNode(int index) {
            // 定义节点来存储需要寻找的节点值
            Node<T> queryNode;
            // 若下标 > 该链表长度的一半,从链尾开始遍历
            if (index > size / 2) {
                queryNode = end;
                for (int i = linkedSize(); i > index; i--) {
                    queryNode = queryNode.prev;
                }
            } else {
                queryNode = head;
                for (int i = 0; i < index; i++) {
                    queryNode = queryNode.next;
                }
            }
            return queryNode;
        }

        // 添加节点
        public void add(T addData) {
            // 创建节点,并让该节点与链表的最后一个节点产生联系
            Node<T> addNode = new Node<>(addData, getNode(size - 1), end);
            addNode.prev.next = addNode;
            addNode.next.prev = addNode;
            size++;
        }

        // 在某节点处插入元素
        public void insert(int i, T addData) {
            // 索引为i的节点元素为n
            Node<T> n = getNode(i);
            // 定义要插入节点的前一个节点,和后一个节点
            Node<T> addNode = new Node<>(addData, n.prev, n);
            n.prev.next = addNode;
            n.prev = addNode;
        }

        // 删除元素
        public T remove(int i) {
            Node<T> n = getNode(i);
            T removeNode = n.data;
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
            return removeNode;
        }

        // 清空链表
        public void clear() {
            initList();
        }

        // 遍历链表
        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.println(getNode(i).data);
            }
        }
    }

    public static void main(String[] args) {
//        new CircleLinkedList();
    }
    

}
