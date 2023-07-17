package com.moon.algorithmicinterview.dp.no8;

/**
 * 63. Unique Paths II
 * 大体思路和62差不多，只是多考虑一下下障碍物
 *
 * @author Chanmoey
 * @date 2023/7/18
 */
class Solution1 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        int way = 1;
        // 最下面1排
        for (int col = n - 2; col >= 0; col--) {
            // 看看有没有障碍物
            if (obstacleGrid[m - 1][col] == 1) {
                way = 0;
            }
            dp[m - 1][col] = way;
        }
        way = 1;
        for (int row = m - 2; row >= 0; row--) {
            if (obstacleGrid[row][n-1] == 1) {
                way = 0;
            }
            dp[row][n - 1] = way;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
                }
            }
        }

        return dp[0][0];
    }
}
