package com.ssq.demo.base.dataStructure.stack;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-02 18:08:16
 * @Description: 基于数组实现一个顺序栈
 *                  时间/空间复杂度: O(1)
 */
public class ArrayStack {
    /**
     * 数组
     */
    private String[] items;

    /**
     * 栈中元素个数
     */
    private int count;

    /**
     * 栈的大小
     */
    private int n;

    /**
     * 初始化数组,申请一个大小为n的数组空间
     * @param n
     */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        // 若数组空间不够,直接返回false
        if (count == n) {
            return false;
        }
        // 入栈操作
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        // 若栈为空,直接返回null
        if (count == 0) {
            return null;
        }
        // 返回下标-1的元素
        String tem = items[count-1];
        --count;
        return tem;
    }
}
