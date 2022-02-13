package com.ssq.demo.base.datastructure.coursera;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-13 20:23:33
 * @Description: 斐波那契数列: 若数列内只有0和1两个值,直接返回结果.否则Sum = 前两项之和
 *                   小记: 1 - 递归的本质是把每一次的方法调用暂存到内存中,当我们递归次数过多时,有栈溢出风险.并且效率非常低
 *                        2 - 可以创建临时空间存储每次计算后的值
 *                        3 - 应该还可以只存三项值 该方法时间和空间复杂度较低
 *                        4 - 矩阵 + 快速幂[没懂]
 */
public class FibonacciNum {
    // 斐波那契数列和
    private static BigDecimal sum(int n) {
        if (n <= 0) {
            return BigDecimal.valueOf(n);
        }

        if (n == 1 || n == 2) {
            return BigDecimal.valueOf(1);
        }
        BigDecimal[] a = new BigDecimal[3];
        a[0] = a[1] = BigDecimal.valueOf(1);
        for (int i = 2; i < n; i++) {
            a[2] = a[0].add(a[1]);
            a[0] = a[1];
            a[1] = a[2];
        }
        return a[2];
    }

    // 查询斐波那契数列和的最后一位数[数字大了之后巨慢]
    private static BigDecimal lastDigit(int n) {
        if (n <= 1) {
            return BigDecimal.valueOf(n % 10);
        }
        BigDecimal[] a = new BigDecimal[3];
        a[0] = a[1] = BigDecimal.valueOf(1);
        for (int i = 2; i < n; i++) {
            a[2] = a[1].add(a[0]);
            a[0] = a[1];
            a[1] = a[2];
        }
        if (n == 2) {
            BigDecimal[] bigDecimals = a[n - 1].divideAndRemainder(BigDecimal.valueOf(10));
            return bigDecimals[bigDecimals.length - 1];
        } else {
            BigDecimal[] bigDecimals = a[2].divideAndRemainder(BigDecimal.valueOf(10));
            return bigDecimals[bigDecimals.length - 1];
        }
    }

    // 查询斐波那契数列和的最后一位数[优化]
    static BigDecimal[][] initMatirx = {{BigDecimal.valueOf(1), BigDecimal.valueOf(1)}, {BigDecimal.valueOf(1), BigDecimal.valueOf(0)}};
    static BigDecimal[][] unitMatirx = {{BigDecimal.valueOf(1), BigDecimal.valueOf(0)}, {BigDecimal.valueOf(0), BigDecimal.valueOf(1)}};
    private static BigDecimal lastDigitOptimization(int n) {
        if(n <= 0) {
            return BigDecimal.valueOf(0);
        }
        if (n == 1 || n == 2) {
            return BigDecimal.valueOf(1);
        }
        BigDecimal[][] result = unitMatirx;
        BigDecimal[][] tem = initMatirx;
        int m = n - 2;
        while (m != 0){
            if ((m & 1) == 1) {
                result = matirxMulti(tem, result);
            }
            tem = matirxMulti(tem, tem);
            m >>= 1;
        }
        BigDecimal[] bigDecimals = result[0][0].add(result[1][0]).divideAndRemainder(BigDecimal.valueOf(10));
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
        int n = scanner.nextInt();
        System.out.println(sum(n));
        System.out.println(lastDigitOptimization(n));
    }
}
