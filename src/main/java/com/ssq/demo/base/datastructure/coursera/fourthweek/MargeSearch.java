package com.ssq.demo.base.datastructure.coursera.fourthweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-27 18:54:46
 * @Description: 不想写代码的一天QAQ
 * 题目: 输入一组integer类型非负数组A,输入该数组长度,输入要对比的数组值B
 * 根据第B数组的值去A数组内查找,若有相同的值,返回第一数组的下标,若没有,返回-1
 */
public class MargeSearch {

    private static int[] margeSearch(int[] firstArray, int[] secondData) {
        int[] searchIndex = new int[secondData.length];
        // 1. 二分法
        int left = 0, right = firstArray.length - 1;
        int[] margeArray = divideArray(firstArray, left, right);
        // 根据有序数组找出匹配的索引下标 TODO 用二分查找效率更高
        for (int j = 0; j < secondData.length; j++) {
            for (int i = 0; i < margeArray.length; i++) {
                if (margeArray[i] == secondData[j]) {
                    searchIndex[j] = i;
                    break;
                }
                searchIndex[j] = -1;
            }

        }
        return searchIndex;

    }

    /**
     * 拆分数组
     *
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private static int[] divideArray(int[] array, int leftIndex, int rightIndex) {
        // 递归出口
        if (leftIndex >= rightIndex) {
            return array;
        }

        // 求中间值是最关键
        int middle = leftIndex + (rightIndex - leftIndex) / 2;
        divideArray(array, leftIndex, middle);
        divideArray(array, middle + 1, rightIndex);
        // 合并数组
        int[] margeSort = margeSort(array, leftIndex, rightIndex, middle);
        return margeSort;
    }

    /**
     * 合并排序
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @param middleNum
     * @return
     */
    private static int[] margeSort(int[] array, int leftIndex, int rightIndex, int middleNum) {
        // 左右半段下标起始索引
        int i = leftIndex;
        int j = middleNum + 1;
        // 当前下标
        int k = 0;
        // 申请一个临时数组, 长度与原始数组相同
        int[] temp = new int[rightIndex - leftIndex + 1];

        // 若左半段起始下标和右半段起始下标都小于末尾下标, 遍历数组
        while (i <= middleNum && j <= rightIndex) {
            if (array[i] > array[j]) {
                temp[k++] = array[j++];
            } else {
                temp[k++] = array[i++];
            }
        }

        // 判断子数组中是否存在剩余数据
        int start = i;
        int end = middleNum;
        if (j <= rightIndex) {
            start = j;
            end = rightIndex;
        }

        // 将剩余数组拷贝至临时数组中
        while (start <= end) {
            temp[k++] = array[start++];
        }

        // 将临时数组中的值拷贝到原数组
        for (int l = 0; l <= rightIndex - leftIndex; l++) {
            array[leftIndex + l] = temp[l];
        }
        return array;
    }

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int n = fastScanner.nextInt();
        int[] firstArray = new int[n];
        for (int i = 0; i < n; i++) {
            firstArray[i] = fastScanner.nextInt();
        }
        int num = fastScanner.nextInt();
        int[] b = new int[num];
        for (int i = 0; i < num; i++) {
            b[i] = fastScanner.nextInt();
        }
        int[] binarySearch = margeSearch(firstArray, b);
        for (int i = 0; i < num; i++) {
            System.out.println(binarySearch[i] + " ");
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
