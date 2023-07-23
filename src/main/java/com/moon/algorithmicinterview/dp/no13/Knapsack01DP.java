package com.moon.algorithmicinterview.dp.no13;

/**
 * 01背包问题：每个物品，有重量wi，和价值vi，背包容量C，如何使得装到背包里的物品，价值最大
 * f(n, c)为：当背包容量为c时，考虑将n号货物装到背包里的最大价值
 * f(n, c) = max{f(n - 1, c), vn + f(n-1, c - wn)))}
 * 意思为：不将n号物品装进背包，此时背包容量不变，或者将n号物品放进背包，加上状态f(n-1, c - wn)
 *
 * @author Chanmoey
 * @date 2023/7/24
 */
public class Knapsack01DP {

    /**
     * 货物（重量，价值）：(1, 6), (2, 10), (3, 12)，容量：5
     * ---0  1  2  3  4  5
     * 0  0  6  6  6  6  6
     * 1  0  6  10 16 16 16
     * 2  0  6  10 16 18 22
     */
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        //  0到n-1行，0到c列
        int[][] dp = new int[n][c + 1];
        // 初始化第0行，也就是第0个物品时
        for (int j = 0; j <= c; j++) {
            dp[0][j] = w[0] > j ? 0 : v[0];
        }
        // 每次更新第i行，只需要i-1行的信息，所以，空间复杂度还可以再优化
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }

        return dp[n - 1][c];
    }

}
