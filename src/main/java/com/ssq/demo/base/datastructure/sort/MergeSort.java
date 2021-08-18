package com.ssq.demo.base.datastructure.sort;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2021-08-12 14:20:40
 * @Description: 归并排序
 *                  思路:
 *                      1.本质上是递归,先从原数组中找到数组中间下标.
 *                      2.从左半边的元素中找到中点,继续递归,直到左半边起点和终点相等,跳出递归
 *                      3.然后判断右半边是否也起点终点相等,若相等执行后续代码.
 *                      4.执行完后从栈中取出上一层的元素下标,判断是否拆分成最小元素,若最小元素执行完后将左右两段元素整体排序
 *                  特点:
 *                      1.时间复杂度O(nlogn)
 *                      2.空间复杂度O(n)
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
        int[] a = {3, 2, 6, 4, 5, 1, 9, 20, 13};
        mergeSort.mergeSortInternally(a,0, 8);
        for (int b : a) {
            System.out.println(b);
        }
    }

}
