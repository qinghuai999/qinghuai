package com.ssq.demo.base.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-07-26 15:01:03
 * @Description: 判断两链表是否相交
 */
public class MargeLinkedList<T> {
    /**
     * 定义链表结构
     *
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
     * 第一个链表
     */
    Node<T> headF;
    /**
     * 第二个链表
     */
    Node<T> headS;

    int sizeF;
    int sizeS;

    /**
     * 添加链表元素
     *
     * @param data
     * @param linkedList
     */
    public void add(T data, Node<T> linkedList, Integer check) {
        Node<T> nowNode = new Node(data);
        if (1 == check) {
            // 若链表为空,直接添加至头结点
            if (null == linkedList) {
                headF = nowNode;
            } else {
                linkedList = headF;
                // 否则遍历链表,将元素插入链表尾部
                while (null != linkedList.next) {
                    linkedList = linkedList.next;
                }
                linkedList.next = nowNode;
            }
            sizeF++;
        } else {
            if (null == linkedList) {
                headS = nowNode;
            } else {
                linkedList = headS;
                // 否则遍历链表,将元素插入链表尾部
                while (null != linkedList.next) {
                    linkedList = linkedList.next;
                }
                linkedList.next = nowNode;
            }
            sizeS++;
        }
    }

    /**
     * 根据索引判断
     *
     * @param index
     * @param linkedList
     * @param check
     * @return
     */
    public Node<T> queryByIndex(int index, Node<T> linkedList, int check) {
        // 判断该链表是否为空
        if (null == linkedList) {
            return null;
        }
        if (check == 1) {
            // 判断该索引是否小于总长度
            if (index > 0 && index <= sizeF) {
                // 循环遍历该链表,找到对应的索引
                for (int q = 1; q < index; q++) {
                    linkedList = linkedList.next;
                }
                return linkedList;
            }
        } else {
            // 判断该索引是否小于总长度
            if (index > 0 && index <= sizeS) {
                // 循环遍历该链表,找到对应的索引
                for (int q = 1; q < index; q++) {
                    linkedList = linkedList.next;
                }
                return linkedList;
            }
        }
        return null;
    }

    /**
     * 查找两链表的相交点之比较法
     * 思路:
     * 自己盲写时出现一个问题: 两个链表长度不相等,导致从头开始无法对比
     * 1.若链表相交,相交点之后的长度是一致的
     * 2.我们可以同时遍历两个链表,如:A链表较长,B链表较短
     * 3.判断两链表元素是否相等,若不相等
     * 1> 同时遍历两个链表,B节点为null时A内还有节点,这时当B指向A链表的头结点继续遍历
     * 2> 当B为null时让B指向A链表的头结点,继续循环,这样两个链表总会在相交处遇到.
     * 即A=A链表相交前长度
     * B=B链表相交前长度
     * C为相交后的长度
     * A+C+B+C = B+C+A+C  所以若链表相交,一定会相遇.
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public Node<T> isMarge(Node<T> firstList, Node<T> secondList) {
        // 判断两个链表是否为空,或者下个节点是否为空
        if (null == firstList || null == firstList.next) {
            return null;
        }
        if (null == secondList || null == secondList.next) {
            return null;
        }
        Node<T> A = firstList;
        Node<T> B = secondList;
        // 判断两个链表(及后续节点)是否一样 问题: 两个链表长度可能并不一样,
        while (A != B) {
            A = A == null ? secondList : A.next;
            B = B == null ? firstList : B.next;
        }
        return A;
    }


    public static void main(String[] args) {
        MargeLinkedList margeLinkedList = new MargeLinkedList();
        margeLinkedList.add("越", margeLinkedList.headF, 1);
        margeLinkedList.add("来", margeLinkedList.headF, 1);
        margeLinkedList.add("越", margeLinkedList.headF, 1);
        margeLinkedList.add("不", margeLinkedList.headF, 1);
        margeLinkedList.add("懂", margeLinkedList.headF, 1);
        System.out.println(margeLinkedList.headF);
        margeLinkedList.add("越", margeLinkedList.headS, 2);
        margeLinkedList.add("长", margeLinkedList.headS, 2);
        margeLinkedList.add("大", margeLinkedList.headS, 2);
        System.out.println(margeLinkedList.headS);
        // 使两链表相交
        margeLinkedList.queryByIndex(3, margeLinkedList.headS, 2).next = margeLinkedList.queryByIndex(3, margeLinkedList.headF, 1);
        System.out.println("第一个链表: " + margeLinkedList.headF + "第二个链表: " + margeLinkedList.headS);
        MargeLinkedList.Node isMarge = margeLinkedList.isMarge(margeLinkedList.headF, margeLinkedList.headS);
        System.out.println(isMarge);
    }
}
