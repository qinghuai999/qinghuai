package com.ssq.demo.base.datastructure.interviewtest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 苏诗淇
 * @CreateDate: 2022/3/21 11:20 上午
 * @Description: dp
 */
public class InterviewTest {

    public boolean wordBreak(String s, List<String> wordDict) {

        // 建立dp数组, 表示i位置是否可以匹配
        boolean[] dp = new boolean[s.length() + 1];

        // 由递推公式dp[i + word.lenth()] = true; 进行初始化, 先全部初始化为false, dp[0]空字符串写为true
        Arrays.fill(dp, false);
        dp[0] = true;
        // 对数组进行遍历
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                // 如果是false则跳过语句直接进入下次循环
                continue;
            }

            for (String word : wordDict) {
                // 遍历到的word长度加上当前dp的长度如果比s小, 且s的位置以word开始, 在用startsWith()方法检测字符串是否以指定的子字符串开始
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
