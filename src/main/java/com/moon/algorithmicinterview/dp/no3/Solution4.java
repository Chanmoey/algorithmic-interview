package com.moon.algorithmicinterview.dp.no3;

/**
 * 64. Minimum Path Sum
 * 思路：f(n,n) = MIN(f(n+1, n), f(n, n+1)) + grid[n][n]
 * -                   往下走      往左走
 * 使用动态规划
 *
 * @author Chanmoey
 * @date 2023/7/15
 */
class Solution4 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 先算最下面一层
        for (int col = n - 2; col >= 0; col--) {
            grid[m - 1][col] = grid[m - 1][col] + grid[m - 1][col + 1];
        }
        // 算最右边一排
        for (int row = m - 2; row >= 0; row--) {
            grid[row][n - 1] = grid[row][n - 1] + grid[row + 1][n - 1];
        }
        // 开始动态规划
        for (int i = m - 2; i >= 0 ; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                grid[i][j] = grid[i][j] + Math.min(grid[i][j+1], grid[i+1][j]);
            }
        }
        return grid[0][0];
    }
}