package com.ssq.demo.base.arrayDemo;

import org.junit.Test;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/17 6:42 下午
 * @Description: 冒泡排序
 */
public class BubbleSort {
    /**
     * 时间复杂度为N²(稳定)
     */
    @Test
    public void bubbleSort(){
        int[] arr = {12,43,64,12,3,4,1};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
//                System.out.print(arr[j] + ",");
            }
            /*System.out.print("[");
            for (int j = arr.length-1 - i; j < arr.length; j++){
                System.out.print(arr[j] + " ");
            }
            System.out.println("]");*/

        }

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }

    }
}
