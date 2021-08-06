package com.ssq.demo.base.datastructure.sort;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-05 17:53:18
 * @Description: 选择排序
 *                  思路: 在原始数组中找出最小的元素,放入数组头部
 *                      1. 遍历数组,存储下标
 *                      2. 嵌套遍历数组,每次与第一次存储的下标元素进行比较,若位置错误,存储当前下标
 *                      3. 继续遍历,知道遍历完整个数组,得到的下标就是最小元素的下标数
 *                      4. 然后在外层交换两个下标元素的位置
 *
 */
public class SelectionSort {
    public void selectionSort(int[] data) {
        if (data.length <= 1) {
            return;
        }
        // 1.找到原始数组内最小的元素
        for (int i = 0; i < data.length; ++i) {
            int k = i;
            int j = data.length-1;
            for (; j >= i; --j) {
                if (data[j] < data[k]) {
                    k = j;
                }
            }
            int temp = data[i];
            data[i] = data[k];
            data[k] = temp;
        }
        for (int a : data) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = {9,1,7,6,3};
        selectionSort.selectionSort(a);
    }
}
