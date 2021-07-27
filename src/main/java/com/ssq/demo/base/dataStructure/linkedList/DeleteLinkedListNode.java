package com.ssq.demo.base.dataStructure.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-07-27 20:02:51
 * @Description: 删除链表倒数第n个节点
 */
public class DeleteLinkedListNode<T> {
    /**
     * 定义链表结构
     * @param <T>
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 头结点
     */
    Node<T> head;

    /**
     * 链表长度
     */
    int size;

    /**
     * 初始化
     */
    public void init() {
        head = new Node<>(null, null);
        head.next = null;
        size = 0;
    }

    /**
     * 在某下标处/节点处添加新元素
     * @param data
     */
    public void add(T data, Integer index, Node<T> insertData) {
        Node<T> newNode = new Node<>(data);
        Node<T> linkedList = head;

        if (null != index) {
            //
        } else if (null != insertData) {
            //
        } else {
            // 遍历链表将元素插入链表尾部
            if (null == linkedList) {
                head = newNode;
            } else {
                while (null != linkedList.next) {
                    linkedList = linkedList.next;
                }
                linkedList.next = newNode;
            }
        }

        // 将data插入当前节点的下一个
    }

    /**
     * 根据下标查询节点
     * @param index
     * @return
     */
    public Node<T> queryNodeByIndex(int index, Node<T> linkedList) {
        if (null == linkedList) {
            return null;
        }
        while (0 < size && index < size) {
            linkedList = linkedList.next;
        }
        return linkedList;
    }

    /**
     * 根据元素查找节点
     * @param data
     * @return
     */
    public Node<T> queryNodeByData(Node<T> data, Node<T> linkedList) {
        if (null == linkedList) {
            return null;
        }
        // 遍历链表元素
        while (!data.equals(linkedList)) {
            if (null == linkedList.next) {
                return null;
            }
            linkedList = linkedList.next;
        }
        return linkedList;
    }

    public static void main(String[] args) {
        DeleteLinkedListNode deleteLinkedListNode = new DeleteLinkedListNode();
        String str = "杏,花,弦,外,雨";
        String[] split = str.split(",");
        for (String s : split) {
            deleteLinkedListNode.add(s, null, null);
        }
    }

}
