package com.ssq.demo.base.datastructure.sort;
/**
 * @Author 苏诗淇
 * @Date 2021-08-18 21:52:32
 * @Description: 快速排序
 *                  思路:
 *                      1.
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

        int q = partition1(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition1(int[] a, int p, int r) {
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
        int[] a = {3, 2, 6, 4, 5, 1, 9, 20, 13};
        quickSort.quickSortInternally(a, 0, a.length-1);
        for (int b : a) {
            System.out.println(b);
        }
    }
}
