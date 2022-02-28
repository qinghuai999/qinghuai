package com.ssq.demo.base.datastructure.coursera.fourthweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-28 14:27:14
 * @Description: 查找数组内是否存在重复元素数量超过总数一半的主要元素
 */
public class MajorityElement {

    private static boolean getMajorityElement(long[] array, int left, int right) {
        // 对已有数组从小到大排序
        divideArray(array, left, right);
        // 寻找重复元素数量 -> 因为该元素数量需超过数组一半,所以只需要查询中位数的元素数量是否大于数组一半就可
        int num = 0;
        int middle = array.length / 2;
        for (int i = 0; i <= right; i++) {
            if (array[i] == array[middle]) {
                ++num;
            }
        }
        if (num > middle) {
            return true;
        }
        return false;
    }

    /**
     * 拆分数组
     *
     * @param array
     * @param left
     * @param right
     */
    private static void divideArray(long[] array, int left, int right) {
        // 从小到大将所有元素排序 -> 使用归并排序(因为他的平均/最好/最坏时间复杂度都是NlogN)
        if (left >= right) {
            return;
        }
        // 求中间数
        int middle = left + (right - left) / 2;
        // 拆分数组
        divideArray(array, left, middle);
        divideArray(array, middle + 1, right);
        // 合并排序
        margeSort(array, left, middle, right);
    }

    private static void margeSort(long[] array, int left, int middle, int right) {
        // 定义左右两段的初始索引值
        int i = left;
        int j = middle + 1;
        // 定义当前索引所在位置
        int k = 0;
        long[] temp = new long[right - left + 1];
        while (i <= middle && j <= right) {

            if (array[i] > array[j]) {
                temp[k++] = array[j++];
            } else {
                temp[k++] = array[i++];
            }
        }

        int start = i;
        int end = middle;
        if (j <= right) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[k++] = array[start++];
        }
        // 将临时数组内的元素放入原数组
        for (int t = 0; t <= right - left; t++) {
            array[left + t] = temp[t];
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        if (getMajorityElement(array, 0, array.length - 1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
