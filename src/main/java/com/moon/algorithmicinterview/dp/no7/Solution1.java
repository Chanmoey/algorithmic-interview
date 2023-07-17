package com.moon.algorithmicinterview.dp.no7;

/**
 * 62. Unique Paths
 * f(m, n) = f(m+1, n) + f(m, n+1)
 * 思路：动态规划
 *
 * @author Chanmoey
 * @date 2023/7/18
 */
class Solution1 {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        // 最下面1排
        for (int col = n - 2; col >= 0; col--) {
            dp[m - 1][col] = 1;
        }
        for (int row = m - 2; row >= 0; row--) {
            dp[row][n - 1] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }

        return dp[0][0];
    }
}
