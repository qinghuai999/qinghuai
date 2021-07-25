package com.ssq.demo.base.dataStructure.linkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

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
public class CheckCircle<T> {

    /**
     * 创建一个指针类
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
     * 该链表长度
     */
    int size;

    /**
     * 初始化链
     */
    public void init() {
        head = new Node<>(null, null);
        head.next = null;
        size = 0;
    }

    /**
     * 根据下标/元素值查找元素
     * @param data
     * @param i
     * @return
     */
    public Node<T> queryNode(T data, int i) {
        Node<T> newNode = head;
        // 按元素查找
        if (!ObjectUtils.isEmpty(data)){
            //否则循环链表,查找是否存在值相同的元素
            while (null != newNode.next) {
                if (data.equals(newNode.data)) {
                    return newNode;
                }
                newNode = newNode.next;
            }
            return null;
        }

        // 按下标查找,判断下标是否大于0,小于总链表长度
        if (0 < i && i <= size) {
          // 寻找链表内符合的下标元素
            for (int q = 1; q < i; q++) {
                newNode = newNode.next;
            }
            return newNode;
        }
        return null;
    }

    /**
     * 添加元素
     * @param data
     */
    public void add(T data) {
        // 创建一个新结点
        Node<T> newNode = new Node(data);
        // 判断头结点是否为空,若为空,直接给头结点赋值
        if (0 == size) {
            head = newNode;
        } else {
            // 否则遍历整个链表,将元素插入至链表尾部
            Node temp = head;
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    /**
     * 链表是否存在闭环之快慢指针法(最优解,时间复杂度为O(N), 空间复杂度为1)
     *  思路:
     *      1.创建快/慢两个指针
     *      2.慢指针指头结点,快指针指向下一个节点
     *      3.判断快指针和快指针的下一个是否为空,不为空则指针继续往下指
     *      4.慢指针指向下一个,快指针指向后两个(相当于快指针的速度是慢指针的2倍,所以若有闭环,快慢指针早晚会重合相遇)
     * @return
     */
    public Boolean isCircle(Node<T> linkedList) {
        // 判断该指针是否为空,为空则不存在闭环
        if (null == linkedList) {
            return false;
        }
        // 创建两个指针
        Node<T> slowNode = linkedList;
        Node<T> quickNode = linkedList.next;
        // 两个指针同时出发,若循环后两指针元素值相同,则说明存在闭环
        while (null != quickNode && null != quickNode.next) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
            if (slowNode == quickNode) {
                return true;
            }
        }
        return false;
    }

    private HashMap<Object, Integer> code = new HashMap<>();
    /**
     * 链表是否存在闭环之足迹法
     *  思路:
     *      1.判断该链表是否为空或只有一个节点
     *      2.判断哈希表里是否存在相同的链表节点,若存在,则证明有环
     *      3.否则将该节点及索引值放入哈希表内,递归循环后续节点
     *  弊端:
     *      若该链表内存在相同元素的节点,则会判断有误
     *  复杂度:
     *      时间复杂度: O(N)
     *      空间复杂度: O(N)
     * @param linkedList 链表
     * @param index 索引
     * @return
     */
    public Boolean isCircleFootprint(Node<T> linkedList, Integer index) {
        // 判断该链表是否为空或者只存在一个节点
        if (null == linkedList || null == linkedList.next) {
            return false;
        }
        // 判断哈希表里是否存在相同的链表节点,若存在,证明有环,否则无
        if (code.containsKey(linkedList.data)) {
            return true;
        } else {
            code.put(linkedList.data, index);
            return isCircleFootprint(linkedList.next, ++index);
        }
    }



    public static void main(String[] args) {
        CheckCircle checkCircle = new CheckCircle();

        String str = "热,爱,生,活,热,爱,你";
        String[] split = str.split(",");
        for (String s : split) {
            checkCircle.add(s);
        }
        // 给链表添加环
        CheckCircle.Node newHead = checkCircle.head;
        checkCircle.queryNode(null, 7).next = checkCircle.queryNode(null, 5);
        // 执行环检测
        Boolean isCircle = checkCircle.isCircle(newHead);
//        Boolean isCircle = checkCircle.isCircleFootprint(node1, 1);
        System.out.println(isCircle);

    }

}
