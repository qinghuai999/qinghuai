package com.ssq.demo.base.datastructure.coursera;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-14 12:56:57
 * @Description: 另一种斐波那契
 */
public class FibonacciOtherNum {

    private static BigDecimal getFibonacciHugeNaive(long n, long m) {
        if (n <= 0) {
            return BigDecimal.valueOf(n);
        }

        if (n == 1 || n == 2) {
            BigDecimal[] bigDecimals = BigDecimal.valueOf(1).divideAndRemainder(BigDecimal.valueOf(m));
            return bigDecimals[bigDecimals.length - 1];
        }
        BigDecimal[] a = new BigDecimal[3];
        a[0] = a[1] = BigDecimal.valueOf(1);
        for (int i = 2; i < n; i++) {
            a[2] = a[0].add(a[1]);
            a[0] = a[1];
            a[1] = a[2];
        }
        BigDecimal[] bigDecimals = a[2].divideAndRemainder(BigDecimal.valueOf(m));
        return bigDecimals[bigDecimals.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
