package com.ssq.demo.base.datastructure.sort;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-03 19:27:30
 * @Description: 冒泡排序
 *                  1.创建两个数组,嵌套遍历
 *                  2.第一层控制总的遍历次数
 *                  3.第二层控制元素排序规则,元素间进行交换
 */
public class BubbleSort {
    /**
     * 升序排列
     * @param a 数组
     * @param n 总数
     */
    public void bubbleSort(int[] a, int n) {
        // 判断是否只有一个元素
        if (n < 1) {
            return;
        }
        // 创建提前退出循环的标识
        boolean flag = false;
        // 遍历该数组
        for (int i = 0; i < a.length; i++) {
            // 比较该数组的元素
            for (int j = 0; j < a.length - 1 - i; j++) {
                // 若前一个元素比后一个元素大
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {1,7,9,11,6,3};
        bubbleSort.bubbleSort(a, 6);
    }
}
