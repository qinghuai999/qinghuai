package com.ssq.demo.datastructure.linkedlist;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-07-14 17:10:58
 * @Description: 链表单测
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
    @Test
    public void addLinkedListData(T add) {
        Node<T> nowNode = new Node<>(add);
        if (0 == size) {
            head = nowNode;
        } else {
            // 遍历元素,在末尾插入元素
            Node<T> temp = head;
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = nowNode;
        }
        size ++;
    }

    public static void main(String[] args) {
        LinkedListTest1<String> linkedClass = new LinkedListTest1<>();
        linkedClass.init();
        linkedClass.addLinkedListData("什");
        linkedClass.addLinkedListData("么");
        linkedClass.addLinkedListData("都");
        linkedClass.addLinkedListData("不");
        linkedClass.addLinkedListData("懂");
        System.out.println(linkedClass.head);
    }
}
