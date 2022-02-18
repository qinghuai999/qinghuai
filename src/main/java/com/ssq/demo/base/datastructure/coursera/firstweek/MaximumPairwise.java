package com.ssq.demo.base.datastructure.coursera.firstweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-03 19:29:47
 * @Description: 找出数组内的最大两个数并得出乘积
 */
public class MaximumPairwise {
    public static long maximumPairwiseProduct(int[] numbers){
        int firstNumIndex = 0;
        int n = numbers.length;
        // 找出该数组内最大的数
        for (int i = 0; i < n; i++) {
            if (numbers[i] > numbers[firstNumIndex]) {
                firstNumIndex = i;
            } else {
                continue;
            }
        }
        // 找出第二大的数 -> 如果第一位数最大,就永远比不出来  怎么绕过第一大的数,找到第二个最大数
        long secondNum = -1;
        for (int j = 0; j < n; j++) {
            // 保证不会比到与第一位数下标相同的值
            if (j != firstNumIndex && numbers[j] > secondNum) {
                // 把第一大的数剔出去
                secondNum = numbers[j];
            }
        }

        long firstNum = numbers[firstNumIndex];
        return firstNum * secondNum;
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            int[] num = new int[10];

            Random rd = new Random();

            for (int n = 0; n < 10; n++) {
                num[n] = rd.nextInt(10) + 1;
                System.out.print(num[n] + ", ");
            }

            System.out.println(maximumPairwiseProduct(num));
            System.out.println("OK");
        }
    }

//    public static void main(String[] args){
//        FastScanner fastScanner = new FastScanner(System.in);
//        int n = fastScanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = fastScanner.nextInt();
//        }
//        System.out.println(maximumPairwiseProduct(numbers));
//
//    }
//
//    public static class FastScanner {
//        BufferedReader br;
//        StringTokenizer st;
//
//        FastScanner(InputStream inputStream) {
//            try {
//                br = new BufferedReader(
//                        new InputStreamReader(inputStream));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreTokens()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//    }
}
