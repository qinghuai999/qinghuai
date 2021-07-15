package com.ssq.demo.base.dataStructure.linkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.security.util.Length;

import java.util.LinkedHashMap;
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

        public Node(T data) {
            this.data = data;
        }
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
            head = new Node<>(null, null, end);
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
            Node<T> addNode;
            if (0 == size) {
                addNode = new Node<>(addData);
                head = addNode;
                head.next = end;
                head.prev = end;
            } else {
                addNode = new Node<>(addData, getNode(size - 1), end);
                addNode.prev.next = addNode;
                addNode.next.prev = addNode;
            }
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

    /**
     * 通过循环链表实现LRU缓存淘汰算法 -- 最少使用策略
     */
    class LruCircleCache {
        // 链表长度
        private Integer size;

        // 链表头结点
        private Node<T> head;

        // 链表尾结点
        private Node<T> end;

        // 链表初始容量
        private final Integer DEFAULT_CAPACITY = 10;

        // 链表容量
        private Integer capacity;

        // 无参构造初始化容量
        public void initStart() {
            this.size = 0;
            this.capacity = DEFAULT_CAPACITY;
            // 给头尾结点的前后结点赋值
            end = new Node<>(null, null, null);
            head = new Node<>(null, null, end);

            // 链接头尾指针 --> 尾结点的前后都指向头结点
            end.prev = head;
            end.next = head;
        }

        // 有参构造初始化容量
        public void initStart(int capacity) {
            end = new Node<>(null, null, null);
            head = new Node<>(null, null, end);
            end.next = head;
            end.prev = head;
            this.capacity = capacity;
            this.size = 0;
        }

        // 添加元素
        // TODO 有问题,循环链表无法区分顺序
        public void lruAdd(T data) {
            // 中心思想: 判断该元素链表中是否存在
            // 1.判断该链表是否为空,为空则直接插入元素
            if (0 == size) {
                add(data);
            } else {
                // 2.不为空则遍历整个链表,查询是否存在该元素,若不存在,直接插入结点末端
                if (null == queryLinked(data)) {
                    add(data);
                } else {
                    // 若存在则删除该节点,在头部新建,
                }
            }
        }

        // 查询链表中是否存在某元素
        public Node queryLinked(T data) {
            Node nextNode = head;
            while (nextNode.next != null) {
                if (data.equals(nextNode.next.data)) {
                    return nextNode;
                }
                nextNode = nextNode.next;
            }
            return null;
        }

        // 添加元素
        public void add(T data) {
            if (0 == size) {
                head = new Node<>(data);
                end = head.next;
                size++;
            } else {
                Node nextN = new Node(data);
                end.next = nextN;
                end = nextN.next;
                end.next = head;
            }
        }

        // 插入


    }

    public static void main(String[] args) {
        // 内部类方法调用 --> 1.外部类实例化对象
        LruCacheCircleLinked cacheCircleLinked = new LruCacheCircleLinked();
        // 2.实例化内部对象
        LruCacheCircleLinked.CircleLinkedList circle = cacheCircleLinked.new CircleLinkedList();
        circle.initList();
        circle.add("淇");
        circle.add("三");
        circle.add("岁");
        circle.print();

//        LruCacheCircleLinked.LruCircleCache lruCache = cacheCircleLinked.new LruCircleCache();
//        lruCache.initStart();
//        lruCache.add("淇");
    }
    

}
