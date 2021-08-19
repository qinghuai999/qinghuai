package com.ssq.demo.base.datastructure.sort;
/**
 * @Author 苏诗淇
 * @Date 2021-08-18 21:52:32
 * @Description: 快速排序
 *                  思路:
 *                      1.定义基准点规则(例: 设置数据最后一个元素为基准点)
 *                      2.根据基准点遍历数组,将比基准点小的数和比基准点大的数互换位置,直到数据全部更换完成.
 *                      3.找到下标最靠前的比基准点大的元素,和基准点互换位置
 *                      4.记录当前基准点的下标
 *                      5.递归基准点左边的元素,根据上述逻辑排序,调换数组元素位置,满足条件后退出,执行右半部分同样的逻辑,直到数组完全有序,程序结束
 */
public class QuickSort {
    public void quickInternally(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // 获取分区点
        int q = partition(arr, low, high);
        quickInternally(arr, low, q-1);
        quickInternally(arr, q+1, high);
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; --j) {
            if (pivot > arr[j]) {
                if (i == j) {
                    ++i;
                }
            } else {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
        System.out.println("i = " + i);
        return i;
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        // 获取基准点的下标
        int q = partition1(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition1(int[] a, int p, int r) {
        // 设置最后一个节点为基准值
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {3, 2, 6, 16, 14, 1, 13, 20, 9, 8, 4, 5};
        quickSort.quickSortInternally(a, 0, a.length-1);
        for (int b : a) {
            System.out.println(b);
        }
    }
}
