package com.ssq.demo.base.datastructure.sort;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-04 20:16:07
 * @Description: 插入排序
 *   思路:
 *      1.根据下标遍历该数组
 *      2.创建一个临时变量存放该下标的元素
 *      3.嵌套循环从当前元素的前一个开始从后往前遍历
 *      4.若两个元素比较大小后位置错误,则交换位置,直到找到合适的位置,插入
 *
 *   小知识:
 *      1.for循环的++i和i++作用是一样的,因为都是在执行完循环体内的代码之后才会执行++i/i++
 *      2.执行时间有差距,++i需要一个临时变量存储返回自增前的值,而++i是处理完之后在自增,无需占用内存,所以性能相对好
 */
public class InsertionSort {
    public void insertionSort(int[] data) {
        // 遍历需要排序的数组
        for (int i = 0; i < data.length; ++i) {
            // 得到要排序的元素
            int temp = data[i];
            // 从后往前遍历该数组,比较元素的大小
            int j = i - 1;
            for (; j >= 0; --j) {
                // 若前一个元素比后一个大,则元素向后移动,否则跳出循环
                if (data[j] > temp) {
                    data[j+1] = data[j];
                } else {
                    break;
                }
            }
            // 将要排序的元素插入当前下标的位置
            data[j+1] = temp;
        }
        for (int s : data) {
            System.out.println(s);
        }
    }

    public void insertTest(int[] data) {
        if (data.length == 0) {
            return;
        }
        for (int i = 0; i < data.length; ++i) {
            int temp = data[i];
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
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] a = {6,3,9,7,10,4};
        insertionSort.insertionSort(a);
    }
}
