package com.ssq.demo.base.dataStructure.arrayDemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/17 3:11 下午
 * @Description: 数组初始化 --> 系统默认初始化值及自定义值
 */
public class ArrayInitTest {
    public static void main(String[] args) {
        // 一维数组
        int[] a = new int[10];
        a[0] = 9;
        a[2] = 2;
        a[5] = 7;
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

        System.out.println("----------二维数组-----------");


        // 二维数组
        int[][] two = {{1,2},{2,9},{5,7},{6,3}};
        for (int i = 0; i < two.length; i++){
            for (int j = 0; j < two[i].length; j++){
                System.out.println(two[i][j]);
            }
        }

        System.out.println("----------增强for循环实现---------");

        for (int[] i : two){
            for (int j : i){
                System.out.println(j);
            }
        }

        System.out.println("--------获取整行数据-----------");

        for (int i = 3; i < two.length;i++){
            for (int j = 0; j<two[3].length;j++){
                System.out.println(two[i][j]);
            }
        }

        System.out.println("--------获取整列数据-----------");

        for (int j = 0; j < two.length; j++){
            System.out.println(two[j][1]);
        }
    }
}
