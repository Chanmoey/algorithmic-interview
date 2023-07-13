package com.moon.algorithmicinterview.dp.no1;

/**
 * 70. Climbing Stairs
 * 误区：为什么不是f(n) = f(n-1) + f(n-2) + 2
 * 想爬上n阶楼梯，必须先爬上n-1阶楼梯或者n-2阶楼梯，那么从n-1到n阶楼梯的方式只有一种，所以0爬到n阶楼梯的方式和从0爬到n-1的走法是一样的。
 * n-2阶楼梯也同理
 * 做法：使用动态规划
 *
 * @author Chanmoey
 * @date 2023/7/14
 */
public class Solution1 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
