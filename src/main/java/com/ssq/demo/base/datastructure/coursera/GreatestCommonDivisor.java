package com.ssq.demo.base.datastructure.coursera;

import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-14 08:47:47
 * @Description: 求最大公约数:
 *                  1.遍历法 - 设置初始公约数1,循环遍历a/b次(取最小值). 效率低下,O(n)=N
 *                  2.相减法 - 大数-小数,然后较小数-差/差-较小数(取决于哪个数大).效率次之
 *                  3.辗转相除法 - 大数对小数取余,小数对余数继续取余,直到余数为0
 */
public class GreatestCommonDivisor {

    private static int gcdNaiveNum(int a, int b) {
        // 初始公约数为1, 任何数/1=任何数
        int publicGcd = 1;
        // 设置公约数
        for (int d = 2; d <= a && d <= d; d++) {
            if (a % d == 0 && b % d == 0) {
                publicGcd = d;
            }
        }
        return publicGcd;
    }

    private static int gcdNum(int a, int b) {
        if (a == b) {
            return a;
        }
        int smallNum = Math.min(a, b);
        int bigNum = Math.max(a, b);
        int restNum = bigNum % smallNum;
        while (restNum != 0) {
            bigNum = smallNum;
            smallNum = restNum;
            restNum = bigNum % smallNum;
        }
        return smallNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcdNum(a, b));
    }
}
