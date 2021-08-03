package com.ssq.demo.base.datastructure.arraylist;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/18 12:11 下午
 * @Description: 求数组元素的最大值和最小值
 */
public class ArrayMaxMixTest {
    public static void main(String[] args) {
        int[] score = {56,43,89,66,21,97};
        int max = 0;
        int min= 0;
        max = min = score[0];
        for (int i = 0; i < score.length; i++){
            if (score[i] > max){
                max = score[i];
            }

            if (score[i] < min){
                min = score[i];
            }
        }

        System.out.println("最高分: " + max);
        System.out.println("最低分: " + min);


    }
}
