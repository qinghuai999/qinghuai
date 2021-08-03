package com.ssq.demo.base.datastructure.linkedlist;

import lombok.Data;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-01-08 18:03:58
 * @Description: 循环链表实现约瑟夫环
 * 约瑟夫环问题的起源来自犹太历史学家约瑟夫和他的朋友以及39其余的犹太人，总共41人为了躲避敌人，藏在一个山洞中，
 * 39个犹太人决定宁愿死也不被敌人抓到，于是决定自杀，所有人排成一个圈，由第一个人开始报数，每当数到3，就自杀。
 * 这个游戏接着从自杀的位置开始，还是从1数到3。依次类推，约瑟夫将朋友和自己安排在了16和31的位置，最后顺利逃过了
 * 自杀这一劫，因为最后就剩他一个人了。
 */
public class JosefCircle {
    public static void count(int n) {
        // 数到3出局,中间间隔两个人
        int k = 3;
        // 头结点不存储数据
        Node head = new Node();
        Node cur = head;
        // 循环构造这个链表
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        // 链表有数据的部分首尾相连形成一个环
        cur.next = head.next;
        // 统计开始时,除去头结点,然后从第一个有数据的结点开始报数
        Node p = head.next;
        // 循环退出的条件是最后只剩一个结点,也就是这个结点的下一个结点是它本身
        while (p.next != p) {
            // 正常报数的逻辑
            for (int i = 1; i < k-1; i++){
                p = p.next;
            }
            // 当数到3的时候,出局
            System.out.println(p.next.data + "-->");
            p.next = p.next.next;
            p = p.next;
        }
        // 最后剩下的一个结点
        System.out.println("(left: " + p.data + " )");
    }

    public static void main(String[] args) {
        count(4);
    }

    /**
     * 定义一个指针
     */
    @Data
    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
