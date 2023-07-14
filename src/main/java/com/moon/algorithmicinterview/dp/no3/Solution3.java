package com.moon.algorithmicinterview.dp.no3;

import java.util.Arrays;

/**
 * 64. Minimum Path Sum
 * 思路：f(n,n) = MIN(f(n+1, n), f(n, n+1)) + grid[n][n]
 * -                   往下走      往左走
 * 记忆化搜索：Solution2太啰嗦
 *
 * @author Chanmoey
 * @date 2023/7/15
 */
class Solution3 {

    private int m;
    private int n;
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n];
        for (int[] row : this.memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int row, int col) {

        // 到达了终点，递归结束
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }

        if (this.memo[row][col] != Integer.MIN_VALUE) {
            return this.memo[row][col];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        // 能往右走
        if (col < n - 1) {
            right = minPathSum(grid, row, col + 1);
        }
        // 能往下走
        if (row < m - 1) {
            down = minPathSum(grid, row + 1, col);
        }

        this.memo[row][col] = grid[row][col] + Math.min(right, down);
        return this.memo[row][col];
    }
}
