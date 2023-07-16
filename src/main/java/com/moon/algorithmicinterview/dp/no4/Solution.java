package com.moon.algorithmicinterview.dp.no4;

import java.util.Arrays;

/**
 * 343. Integer Break
 * 给定数字n，n可以拆成k个数字的和，求k个数字乘积的最大值
 * 假设我们知道n-1的结果，那么n的结果就是1*(n-1)的结果，依次类推
 * 记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/17
 */
class Solution {

    private int[] memo;

    public int integerBreak(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }

    /**
     * 将n拆分成两个数字的和，返回这两个数字的最大值
     */
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            // i * (n - i)表示n-i不往下继续拆，直接将n拆成两份
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        this.memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
