package com.ssq.demo.base.datastructure.sort;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-06 14:17:05
 * @Description: 希尔排序 - 希尔于1959年提出
 *                  简介:
 *                      1.希尔于1959年提出
 *                      2.是插入排序的一种优化升级版,同时也是第一批在时间复杂度上突破O(N2)的排序算法
 *                  性能最优:
 *                      1.在大多数元素有序的情况下
 *                      2.在元素数量比较少的情况下
 *
 *                  思路:
 *                      1.规定一个间隔,按间隔组成多个子数组
 *                      2.分别对子数组进行直接插入排序 -- 此时符合元素数量比较少的情况
 *                      3.渐渐缩小间隔值,直到间隔为1,变成直接插入排序 -- 通过大间隔的排序后,此时数组基本有序
 */
public class ShellSort {
    public void shellSort(int[] data) {
        if (data.length == 1) {
            return;
        }
        // 记录数组长度一半处的下标
        int step = data.length/2;
        // 循环条件: 下标大于1
        while (step >= 1) {
            // 从中间开始往后遍历
            for (int i = step; i < data.length; ++i) {
                // 长度一半处的元素值
                int value = data[i];
                // 从0开始往后遍历
                int j = i - step;
                for (; j >= 0; j -= step) {
                    // 若后面的元素比前面的元素大,交换位置
                    if(value < data[j]) {
                        data[j+step] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + step] = value;
            }
            step = step / 2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 5, 1, 9, 20, 13};
        // bubbleDownSort(arr);
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }

    }
}
