package com.ssq.demo.base.datastructure.sort;

/**
 * @Author 苏诗淇
 * @Date 2021-08-11 23:41:02
 * @Description: 排序复习类
 */
public class SortTest {
    // -------------------------双循环--------------------------

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        // 校验
        if (arr.length <= 1) {
            return;
        }

        // 排序 第一层,判断要排序的次数
        for (int i = 0; i < arr.length; i++) {
            // 第二层,元素两两比较,将最大的向后移动
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序 --> 先插入再比较
     */
    public static void insertSort(int[] arr) {
        // 校验
        if (arr.length <= 1) {
            return;
        }
        // 确定插入元素的次数
        for (int i = 0; i < arr.length; i++) {
            int data = arr[i];
            //遍历的是要保持有序的下标为i以前的数组
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = data;
        }
    }

    /**
     * 选择排序 --> 先比较再插入
     */
    public static void selectSort(int[] arr) {
        // 遍历整个数组,确定插入次数
        for (int i = 0; i < arr.length; i++) {
            // 找到整个数组里最小的元素
            // 记录当前元素下标
            int index = i;
            // 记录当前元素
            int data = arr[i];
            // 循环无序列表, 找出最小元素
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            arr[i] = arr[index];
            arr[index] = data;
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr) {
        // 确定出口
        if (arr.length == 1) {
            return;
        }
        // 找出数组的间隔值
        int q = arr.length / 2;
        // 当间隔>=1时,进行比较
        while (q >= 1) {
            // 比较次数(循环从间隔点到数组最后的长度)
            for (int i = q; i <= arr.length; i++) {
                // 记录间隔点元素
                int data = arr[i];
                // 记录起始点
                int j = i - q;
                for (; j >= 0; j--) {
                    // 比较起始点和间隔点元素,若间隔点元素大,则交换位置,否则跳出循环
                    if (data > arr[j]) {
                        arr[j + q] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j] = data;
            }
            // 处理更小间隔点数据
            q /= 2;
        }

    }

    // ------------------------递归--------------------------

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr, int p, int r) {
        // 找出口
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        // 先分组在排序
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    public static void merge(int[] arr, int p, int q, int r) {
        // 记录数组左半边起始下标
        int i = p;
        // 记录右半边起始下标
        int j = q + 1;
        // 创建一个当前下标
        int k = 0;
        // 创建一个新数组,存放当前要处理的所有元素
        int[] temp = new int[r - p + 1];
        // 判断左半边和右半边的起始下边是否小于末尾下表
        while (i <= q && j <= r) {
            if (arr[i] >= arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        // 判断哪个子数组中存在多于元素
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            arr[k++] = arr[start++];
        }
        // 将临时数组中的元素拷贝回原数组中
        for (i = 0; i <= r - p; i++) {
            arr[p + i] = temp[i];
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 寻找分区点下标
        int q = quickMerge(arr, p, r);
        quickSort(arr, p, q-1);
        quickSort(arr, q+1, r);

    }

    public static int quickMerge(int[] arr, int p, int r) {
        // 设置最后一个元素为基准值
       int pivot = arr[r];
       // 定义初始下标,记录比基准值大的元素下标
       int i = p;
       // 循环整个数组
        for (int j = p; j < r; j++) {
            // 如果当前元素是否小于基准值
            if (arr[j] < pivot) {
                // i和j相等则增加i的值
                if (i == j) {
                    i++;
                } else {
                    // 否则交换两个元素的位置
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // 交换 基准值和比基准值大的,并且下标最靠前的元素
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 9, 1, 2, 8};
        selectSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
