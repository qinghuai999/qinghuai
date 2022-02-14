package com.ssq.demo.base.datastructure.coursera;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-14 11:34:54
 * @Description: 最小公倍数
 */
public class LeastCommonMultiple {

    private static BigDecimal publicMultipleNum(int a, int b) {
        // 求出最大公倍数
        int maxDivisor = a;
        if (a != b) {
            int smallNum = Math.min(a, b);
            int bigNum = Math.max(a, b);
            int restNum = bigNum % smallNum;
            while (restNum != 0) {
                bigNum = smallNum;
                smallNum = restNum;
                restNum = bigNum % smallNum;
            }
            maxDivisor = smallNum;
        }
        // 计算最大公约数是否存在继续简化可能性
        // 对于任意正整数,有(a,b) * [a,b] = ab ()为公约数 []为公倍数
        BigDecimal minMultiple = BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).divide(BigDecimal.valueOf(maxDivisor));
        return minMultiple;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(publicMultipleNum(a, b));
    }
}
