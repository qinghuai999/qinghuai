package com.ssq.demo.base.dataStructure.arrayDemo;
/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/17 6:44 下午
 * @Description: 快速排序
 */
public class QuickSort {
    /**
     * 寻找中间数(基准数)
     * @param list 数组
     * @param low 低位(基准数左边的起始部分,小于基准数的值)
     * @param high 高位(基准数右边的结束部分,大于基准数的值)
     * @return 中间轴的位置
     */
    public static int getMiddle(int[] list, int low, int high){
        // 设置该数组的第一个值为基准数
        int temp = list[low];
        // 如果低位下标比高位下标小
        while (low < high){
            // 如果低位下标比高位小并且高位下标的值大于基准数
            while (low < high && list[high] >= temp){
                // 向前移动高位指针
                high --;
            }
            // 如果当高位的元素的值小于低位,需要将高位值赋给低位
            list[low] = list[high];
            // 当低位的值小于高位并且低位的值小于基准数
            while (low < high && list[low] < temp){
                // 向后移动低位指针
                low ++;
            }
            // 当低位元素大于高位,则把低位的值赋给高位
            list[high] = list[low];
        }
        // 跳出循环时,说明低位和高位相等,这时的低位/高位就处于基准数的位置了
        // 由原理部分可以很清楚的知道低位的值不是基准数,所以需要将基准数赋值给低位
        list[low] = temp;
        // 返回temp的正确位置
        return low;
    }

    /**
     * 快速排序
     * @param list 数组
     * @param low 低位数值
     * @param high 高位数值
     */
    public static void unckSort(int[] list, int low, int high){
        // 如果低位下标小于高位下标
        if (low < high) {
            // 将list数组一分为二
            int middle = getMiddle(list, low, high);
            // 对低位进行递归排序
            unckSort(list, low, middle - 1);
            // 对高位进行递归排序
            unckSort(list, middle + 1, high);
        }
    }

    /**
     * 递归入口/出口,判断数组是否为空,不为空走排序
     * @param str
     */
    public static void quick(int[] str){
        if (str.length > 0) {
            // 数组元素,数组低位下标和高位下标
            unckSort(str, 0, str.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] number = {14,2,4,7,33,55,89,12,7};
        System.out.println("排序前:");
        for (int i : number){
            System.out.print(i+ ",");
        }
        System.out.println();
        quick(number);
        System.out.println("排序后:");
        for (int val : number){
            System.out.print(val + ",");
        }
    }
}
