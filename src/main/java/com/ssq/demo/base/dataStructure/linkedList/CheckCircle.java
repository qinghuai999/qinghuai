package com.ssq.demo.base.dataStructure.linkedList;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-01-21 19:52:29
 * @Description: 链表中的环检测 - 判断一个链表中是否存在闭环
 * - 方法一: 1-1.快慢指针
 * - 方法二: 1-2.足迹法(用了HashSet做缓存)
 * - 实例之间互相引用会报StackOverflowError:
 * JAVA虚拟机在实际调用方法时会设置一个最大栈深度.如果无限循环会占满所有内存.
 *
 *
 * 延伸题:   2-1.环入口定位
 *          2-2.环的长度
 *          2-3.判断两个单向链表是否相交，如果相交，求出交点
 */
public class CheckCircle {
    /**
     * 定义指针
     *
     * @param <T>
     */
    @Data
    static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getNextNodeData() {
            return next != null ? (T) next.data : null;
        }

    }

    /**
     * 1.快慢指针法
     *
     * @param head
     * @return
     */
    public static boolean hasLoopFS(Node head) {
        if (null == head) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;
        // 快指针未能遍历完所有节点
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 设一个缓存点,保存足迹信息
    private static HashMap<Object, Integer> nodeMap = new HashMap<>();

    /**
     * 2.足迹法
     * @param node
     * @param index
     * @return
     */
    public static boolean hasLoopHash(Node node, Integer index) {
        if (null == node || null == node.next) {
            return false;
        }
        if (nodeMap.containsKey(node.data)) {
            return true;
        } else {
            nodeMap.put(node.data, index);
            return hasLoopHash(node.next, ++index);
        }

    }

    public static Object queryLookEntry(Node node, Integer index) {
        // 判断该结点是否为空
        if (null == node || null == node.next) {
            return null;
        }
        if (nodeMap.containsKey(node)) {
            return node.data;
        } else {
            nodeMap.put(node.data, index);
            return queryLookEntry(node.next, ++index);
        }
    }

    public static void main(String[] args) {
        Node link1 = new Node(1);
        Node link2 = new Node(2);
        Node link3 = new Node(3);
        Node link4 = new Node(4);
        Node link5 = new Node(5);
        Node link6 = new Node(6);
        Node link7 = new Node(7);
        Node link8 = new Node(8);
        link1.next = link2;
        link2.next = link3;
        link3.next = link4;
        link4.next = link5;
        link5.next = link6;
        link6.next = link7;
        link7.next = link8;
        link8.next = link4;
//        boolean hasLoopFS = hasLoopFS(link1);
//        if (hasLoopFS == true) {
//            System.out.println("有环");
//        }
        boolean b = hasLoopHash(link1, 1);
        if (b == true) {
            System.out.println("有环");
        }

    }

}
