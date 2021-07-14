package com.ssq.demo.base.algorithm.sortDemo;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-05-20 20:46:32
 * @Description: 选择排序算法
 */
public class SelectSort {
    public static void main(String[] args) {
        Integer []arrays = new Integer[]{7,5,9,10,13};
        // length/length()/size()区别
        System.out.println("数组长度: " + arrays.length);
        ArrayList<Integer> arrayList = Lists.newArrayList(1,2,4,6,3,9);
        System.out.println("集合长度: " + arrayList.size());
        String arr = "12345";
        System.out.println("字符串长度: " + arr.length());
        // 按照从小到大顺序排序
        // 思路1: 每次查出最小的数,放到新数组的最后
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < arrays[arrays.length-i]) {

            }
        }
    }
}
