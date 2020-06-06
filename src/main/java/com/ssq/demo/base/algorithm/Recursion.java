package com.ssq.demo.base.algorithm;
/**
 * @Author 苏诗淇
 * @Date 2020/6/6 14:15
 * @Description: 斐波那契数列 --> 1,1,2,3,5,8,13...找出规律取出后面第N位的数
 */
public class Recursion {

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public static long recursion(int n){
        // 如果下标为0,则返回结果0
        if (n == 0){
            return 0;
        }

        // 如果下标为1和2,则返回结果为1(因为数组下标比实际看到的数字位置靠前一位)
        if (n == 1 || n ==2){
            return 1;
        }

        // 把当前下标的前两位数相加,得出当前元素值
        return recursion(n-1)+recursion(n-2);
    }

    /**
     * 递归取值
     * @param args
     */
    public static void main(String[] args) {
        long result = recursion(50);
        System.out.println(result);
    }

}
