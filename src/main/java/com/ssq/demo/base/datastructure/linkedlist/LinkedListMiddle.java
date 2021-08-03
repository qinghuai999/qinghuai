package com.ssq.demo.base.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-02 15:58:09
 * @Description: 求链表中间的节点
 *                  方法一: 遍历法
 *                  方法二: 快慢指针法
 */
public class LinkedListMiddle<T> {
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

    Node<T> head = new Node<>(null, null);
    int size = 0;

    /**
     * 添加元素
     * @param data
     * @param linkedList
     */
    public void add(T data, Node<T> linkedList) {
        Node<T> nowNode = new Node(data);
        while (null != linkedList.next) {
            linkedList = linkedList.next;
        }
        linkedList.next = nowNode;
        ++size;
    }

    /**
     * 根据索引查询节点
     * @param index
     * @param linkedList
     * @return
     */
    public Node<T> queryByIndex(int index, Node<T> linkedList) {
        if (index > 0 && index < size) {
            for (int q = 0; q < index; q++) {
                linkedList = linkedList.next;
            }
        }
        return linkedList;
    }

    /**
     * 查找链表中间节点之遍历法
     * @param linkedList
     * @return
     */
    public Node<T> middleNode(Node<T> linkedList) {
        for (int i = 0; i <= size/2; i++) {
            linkedList = linkedList.next;
        }
        return linkedList;
    }

    /**
     * 查找链表中间节点之快慢指针法
     * @param linkedList
     * @return
     */
    public Node<T> middleNodePoint(Node<T> linkedList) {
        Node<T> quick = linkedList;
        Node<T> slow = linkedList;
        while (null != quick.next.next) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public static void main(String[] args) {
        LinkedListMiddle listMiddle = new LinkedListMiddle();
        String str = "其,实,你,不,懂";
        String[] split = str.split(",");
        for (String s : split) {
            listMiddle.add(s, listMiddle.head);
        }
        LinkedListMiddle.Node node = listMiddle.queryByIndex(3, listMiddle.head);
        System.out.println(node);
        LinkedListMiddle.Node node1 = listMiddle.middleNode(listMiddle.head);
        System.out.println(node1);
        LinkedListMiddle.Node node2 = listMiddle.middleNodePoint(listMiddle.head);
        System.out.println(node2);
    }
}
