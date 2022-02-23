package com.ssq.demo.base.datastructure.coursera.thirdweek;

import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-20 17:28:41
 * @Description: 输入背包总容量W, 和能容纳的物品数量n
 *                  找出最大价值的物品放入背包
 *                  物品数量为v[i], 重量为wi
 */
public class FractionalKnapsack {

    private static double money(int capacity, int[] values, int[] weights, int n) {
        double value = 0;
        double[] singleValue = new double[n];
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            // 算出每一种物品的单价
            singleValue[i] = (double) values[i] / weights[i];
        }

        // 排序(冒泡,效率较低)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (singleValue[j] < singleValue[j + 1]) {
                    double k = singleValue[j];
                    int h = weights[j];
                    // 单价排序
                    singleValue[j] = singleValue[j + 1];
                    singleValue[j + 1] = k;
                    // 重量排序
                    weights[j] =weights[j + 1];
                    weights[j+1] = h;
                }
            }
        }
        // 找出单价最低的物品,判断总量是否大于背包容量,若不够,则进行循环,找到单价第二低的物品,循环判断...
        for (int i = 0; i < n; i++) {
            if (weights[i] >= capacity) {
                value += capacity * singleValue[i];
                break;
            } else {
               value += weights[i] * singleValue[i];
               capacity -= weights[i];
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(money(capacity, values, weights, n));
    }
}
