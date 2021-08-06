package com.ssq.demo.base.datastructure.sort;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-06 14:17:05
 * @Description: 希尔排序
 */
public class ShellSort {
    public void shellSort(int[] data) {
        if (data.length == 1) {
            return;
        }
        // 记录数组长度一半处的下标
        int step = data.length/2;
        while (step >= 1) {
            for (int i = step; i < data.length; ++i) {
                int value = data[i];
                int j = i - step;
                for (; j >= 0; j -= step) {

                }
            }
        }
    }
}
