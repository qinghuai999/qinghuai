package com.ssq.demo.base.datastructure.coursera.fourthweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-28 12:56:07
 * @Description: 给定一组有序数组, 最快速度找出重复元素的数组下标,有重复取第一个
 * (二分查找)
 */
public class BinarySearch {

    /**
     * 无重复元素写法
     * @param firstArray
     * @param i
     * @return
     */
    private static int binarySearch(int[] firstArray, int i) {
//        int[] newIndex = new int[secondArray.length];
        // 使用二分法确定范围
        int left = 0;
        int right = firstArray.length - 1;
        int index = -1;
        while (right >= left) {
            int middle = left + (right - left) / 2;
            if (i == firstArray[middle]) {
                index = middle;
                break;
            }
            if (i > firstArray[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return index;
    }

    /**
     * 有重复元素写法 - 找到相同值后继续向前遍历.
     * @param firstArray
     * @param i
     * @return
     */
    private static int repeatBinarySearch(int[] firstArray, int i) {
        int left = 0, right = firstArray.length - 1;
        int index = -1;
        while (right >= left) {
            int middle = left + (right - left) / 2;
            if (i > firstArray[middle]) {
                left = middle + 1;
            } else {
                if (i == firstArray[middle]) {
                    index = middle;
                }
                right = middle - 1;
            }
        }
        return index;
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
        for (int i = 0; i < num; i++) {
            System.out.println(repeatBinarySearch(firstArray, b[i]) + " ");
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
