package com.ssq.demo.base.dataStructure.arrayDemo;

import java.util.Arrays;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/17 4:37 下午
 * @Description: 数组&字符串转化
 *                数组常用函数
 */
public class ArrayStringTest {
    public static void main(String[] args) {
        String s = "1,2,55,6,887,56,9";
        String[] split = s.split(",");
        System.out.println("字符串:"+s);

        for (String s1 : split){
            System.out.println("数组:" + s1);
        }

        String[] a = {"2","jiu","qi","hua"};
        char[] c = {'1','2','d','f'};
        String ss = new String(c);
        System.out.println(ss);

        // 字符串转数组
        StringBuilder builder = new StringBuilder();
        for (String s1 : a){
            builder.append(s1).append(",");
        }
        String substring = builder.substring(0, builder.length() - 1);
        System.out.println(substring);

        // 查找指定元素位置
        double[] d ={1.5,22.3,59.6,99.7};
        int binarySearch = Arrays.binarySearch(d, 1,3,59.6);
        System.out.println(binarySearch);

        // 复制数组
        double[] doubles = Arrays.copyOf(d, 10);
        for (double v : doubles){
            System.out.println(v);
        }

        // 将某一段长度的值复制到新数组
        double[] doubles1 = Arrays.copyOfRange(d, 1, 2);
        for (double v : doubles1){
            System.out.println(v);
        }
    }
}
