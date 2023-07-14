package com.moon.algorithmicinterview.dp.no3;

/**
 * 64. Minimum Path Sum
 * 思路：f(n,n) = MIN(f(n+1, n), f(n, n+1)) + grid[n][n]
 * -                   往下走      往左走
 * 先选择递归，整理思路，递归必然超时滴
 *
 * @author Chanmoey
 * @date 2023/7/15
 */
class Solution {

    private int m;
    private int n;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int row, int col) {
        // 到达终点，递归终止
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
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

        return grid[row][col] + Math.min(right, down);
    }
}
