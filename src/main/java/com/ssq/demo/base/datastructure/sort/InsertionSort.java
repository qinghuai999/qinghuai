package com.ssq.demo.base.datastructure.sort;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-04 20:16:07
 * @Description: 插入排序
 * 思路:
 * 1.创建两个数组,一个存放原始元素,一个空数组,用来存放有序元素
 * 2.将原始元素放入有序数组中,然后每次移动元素时进行比较,找到合适的位置在插入.
 */
public class InsertionSort {
    public void insertionSort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            // 对有序数组里的元素进行比较
            int j = i - 1;
            for (; j >= 0; --j) {
                if (data[j] > temp) {
                    data[j+1] = data[j];
                } else {
                    break;
                }
            }
            data[j+1] = temp;
        }
        for (int s : data) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] a = {6,3,9,7,10,4};
        insertionSort.insertionSort(a);
    }
}
