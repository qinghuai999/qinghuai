package com.ssq.demo.base.datastructure.coursera;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-14 12:56:57
 * @Description: 另一种斐波那契
 */
public class FibonacciOtherNum {

    private static BigDecimal getFibonacciHuge1(long n, long m) {
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

    // 查询斐波那契数列和的最后一位数[优化]
    static BigDecimal[][] initMatirx = {{BigDecimal.valueOf(1), BigDecimal.valueOf(1)}, {BigDecimal.valueOf(1), BigDecimal.valueOf(0)}};
    static BigDecimal[][] unitMatirx = {{BigDecimal.valueOf(1), BigDecimal.valueOf(0)}, {BigDecimal.valueOf(0), BigDecimal.valueOf(1)}};
    private static BigDecimal getFibonacciHuge(long n, long k) {
        if(n <= 0) {
            return BigDecimal.valueOf(0);
        }
        if (n == 1 || n == 2) {
            return BigDecimal.valueOf(1);
        }
        BigDecimal[][] result = unitMatirx;
        BigDecimal[][] tem = initMatirx;
        long m = n - 2;
        while (m != 0){
            if ((m & 1) == 1) {
                result = matirxMulti(tem, result);
            }
            tem = matirxMulti(tem, tem);
            m >>= 1;
        }
        BigDecimal[] bigDecimals = result[0][0].add(result[1][0]).divideAndRemainder(BigDecimal.valueOf(k));
        return bigDecimals[bigDecimals.length-1];
    }

    private static BigDecimal[][] matirxMulti(BigDecimal[][] a, BigDecimal[][] b) {
        BigDecimal[][] temp = new BigDecimal[2][2];
        temp[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        temp[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        temp[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        temp[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}
