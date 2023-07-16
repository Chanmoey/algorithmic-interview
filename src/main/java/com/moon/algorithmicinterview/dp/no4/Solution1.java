package com.moon.algorithmicinterview.dp.no4;

import java.util.Arrays;

/**
 * 343. Integer Break
 * 给定数字n，n可以拆成k个数字的和，求k个数字乘积的最大值
 * 假设我们知道n-1的结果，那么n的结果就是1*(n-1)的结果，依次类推
 * 动态规划
 *
 * @author Chanmoey
 * @date 2023/7/17
 */
class Solution1 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = -1;
            for (int j = 1; j < i; j++) {
                max = max3(max, j * (i - j), j * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
