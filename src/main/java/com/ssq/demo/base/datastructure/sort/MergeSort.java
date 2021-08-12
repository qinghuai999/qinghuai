package com.ssq.demo.base.datastructure.sort;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-12 14:20:40
 * @Description: 归并排序
 *                  思路:
 *                      1.
 */
public class MergeSort {
    /**
     * 二分递归拆分数组
     * @param data
     * @param p
     * @param r
     */
    public void mergeSortInternally(int[] data, int p, int r) {
        // 递归退出条件
        if (p >= r) {
            return;
        }
        // 中间点 (防止p到r的和超过int类型最大值)
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(data, p, q);
        mergeSortInternally(data, q+1, r);

        // 合并两个数组
        merge(data, p, q, r);
    }

    /**
     * 对拆分数组分别排序
     * @param data 数组
     * @param p 二分左半边起始下标
     * @param q 二分左半边结束下标
     * @param r 二分右半边结束下标
     */
    public void merge(int[] data, int p, int q, int r) {
        // 数组二分左半段起始下标
        int i = p;
        // 数组二分右半段起始下标
        int j = q+1;
        // 当前下标
        int k = 0;
        // 申请一个数组长度相等的临时数组
        int[] temp = new int[r-p+1];
        // 若左半段和右半段起始下标小于末尾下标,遍历
        while (i <= q && j <= r) {
            // 若左边的元素大于右边的,互换位置
            if (data[i] >= data[j]) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组temp中
        while (start <= end) {
            temp[k++] = data[start++];
        }

        // 将temp中的数组拷贝回data[p,r]中
        for (i = 0; i <= r-p; ++i) {
            data[p+i] = temp[i];
        }
    }

    /**
     *
     * @param data 数组
     * @param p 二分左半边起始下标
     * @param q 二分左半边结束下标
     * @param r 二分右半边结束下标
     */
    public void mergeBySentry(int[] data, int p, int q, int r) {

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {5,9,1,6,4,3,11,7};
        mergeSort.mergeSortInternally(a,0, 7);
        for (int b : a) {
            System.out.println(b);
        }
    }

}
