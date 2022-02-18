package com.ssq.demo.base.datastructure.coursera.firstweek;

import java.util.Scanner;

public class AddNum {
    static int addNum(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(addNum(a, b));
    }
}
