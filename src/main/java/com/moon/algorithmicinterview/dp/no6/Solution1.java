package com.moon.algorithmicinterview.dp.no6;

import java.util.Arrays;

/**
 * 91. Decode Ways
 * 以"11106"为例，索引start为0的位置，可以由"1101" + "106"的可能是组成，以此类推
 * 思路：动态规划
 *
 * @author Chanmoey
 * @date 2023/7/17
 */
class Solution1 {

    public int numDecodings(String s) {

        if (s.length() == 1) {
            return "0".equals(s) ? 0 : 1;
        }

        int[] dp = new int[s.length() + 1];
        // ""有一种表示方式，那就什么都不表示
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i+1];
                if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26) {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
