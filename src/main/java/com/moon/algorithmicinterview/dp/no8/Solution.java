package com.moon.algorithmicinterview.dp.no8;

/**
 * 63. Unique Paths II
 * 大体思路和62差不多，只是多考虑一下下障碍物
 *
 * @author Chanmoey
 * @date 2023/7/18
 */
class Solution {

    private int[][] memo;
    private int m;
    private int n;
    private int[][] grid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        this.grid = obstacleGrid;
        this.memo = new int[m][n];
        this.memo[m - 1][n - 1] = 1;
        return search(0, 0);
    }

    private int search(int row, int col) {
        if (this.memo[row][col] != 0) {
            return this.memo[row][col];
        }

        int right = 0;
        int down = 0;

        if (col + 1 < n && this.grid[row][col + 1] != 1) {
            right = search(row, col + 1);
        }
        if (row + 1 < m && this.grid[row + 1][col] != 1) {
            down = search(row + 1, col);
        }
        this.memo[row][col] = right + down;
        return this.memo[row][col];
    }
}
