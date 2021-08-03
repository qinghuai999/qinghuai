package com.ssq.demo.base.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-07-27 20:02:51
 * @Description: 删除链表倒数第n个节点
 *                  方法一: 遍历法
 *                  方法二: 快慢指针法
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
        size++;
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

    /**
     * 删除倒数第n个结点之计算链表长度法
     *   思路:
     *      1.先遍历链表,得到该链表长度
     *      2.判断索引大小是否符合条件,找到要删除节点的前一个
     *      3.改变指针位置
     *      4.TODO 输出变更后的链表 (数据传递还是没弄懂)
     * @param index
     * @return
     */
    public Node<T> deleteNode(Integer index, Node<T> linkedList) {
        Node<T> nowLinked = linkedList;
        if (null == linkedList) {
            return null;
        }
        Node<T> temp = nowLinked;
        // 判断索引是否超过链表长度
        if (index > 0 && index <= size) {
            // 将链表倒序遍历或算出正序索引,并找出要删除节点的前一个
            for (int q = 0; q < size-index-1; q++) {
                temp = temp.next;
            }
        }
        // 删除该元素,判断该节点是否为尾结点/头结点
        if (null == temp.next || size-index-1 < 0) {
            temp = null;
        } else {
            temp.next = temp.next.next;
        }
        Node<T> node = nowLinked;
        return node;
    }

    /**
     * 删除倒数第n个节点之快慢指针法
     *   思路:
     *      1.定义两个指针,初始值都指向头结点
     *      2.快指针先走n个节点
     *      3.然后快慢指针一起走,等快指针的下一个节点为空的时候退出循环
     *      4.此时慢指针的位置就是要删除的节点的前一个,改变指针位置即可
     * @param index
     * @param linkedList
     * @return
     */
    public Node<T> doublePointerDelete(Integer index, Node<T> linkedList) {
        Node<T> nowNode = linkedList;
        if (null == linkedList) {
            return null;
        }
        Node<T> quick = nowNode;
        Node<T> slow = nowNode;
        for (int i = 0; i < index; i++) {
            quick = quick.next;
        }
        while (null != quick.next) {
            quick = quick.next;
            slow = slow.next;
        }
        Node<T> tempPrev = slow;
        tempPrev.next = tempPrev.next.next;

        return nowNode;
    }

    public static void main(String[] args) {
        DeleteLinkedListNode deleteLinkedListNode = new DeleteLinkedListNode();
        String str = "杏,花,弦,外,雨";
        String[] split = str.split(",");
        for (String s : split) {
            deleteLinkedListNode.add(s, null, null);
        }
        DeleteLinkedListNode.Node deleteNode = deleteLinkedListNode.doublePointerDelete(3, deleteLinkedListNode.head);
        System.out.println(deleteNode);
    }

}
