package com.ssq.demo.base.dataType.stringDemo;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2020/5/18 5:12 下午
 * @Description: String常量和两种变量
 */
public class stringTest {
    StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        int k = 0;
        k = k++ + ++k + k++ + ++k;
        System.out.println(k);
        String headerUrl = "{\"image\":\"\\/ke\\/upload\\/image\\/2018\\/03\\/18\\/abbbbb2768b58a373c5730dc634f5c89.jpg\",\"head\":\"\\/ke\\/upload\\/image\\/2018\\/03\\/19\\/fe086207a69b4238b5d050067fb752cb.png\",\"school\":\"中国美术学院\",\"working\":\"3年\",\"character\":\"活泼开朗，亲和力高，富有爱心\",\"interest\":\"美术 音乐 舞蹈\",\"specialty\":\"儿童画，水彩画，装饰画，纸黏土手工，粘贴画，彩铅画，幼儿舞蹈\",\"education\":\"\"}";

        String[] split = headerUrl.split("\"");

        for (String s : split) {
            System.out.println(s);

        }
    }
}
