package com.ssq.demo.base.datastructure.coursera.thirdweek;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: 苏诗淇
 * @Date: 2022-02-18 17:23:32
 * @Description: 输入一个数字,使用最少的1,5,10组合出输入的数字
 */
public class ChangeMoney {
    private static long change(long m) {
        ArrayList<Integer> list = Lists.newArrayList(10, 5, 1);
        long count = 0;
        long restNum = m;
        for (Integer i : list) {
            count += restNum / i;
            restNum = restNum % i;

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(change(m));
    }
}
