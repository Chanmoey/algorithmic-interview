package com.moon.algorithmicinterview.dp.no7;

/**
 * 62. Unique Paths
 * f(m, n) = f(m+1, n) + f(m, n+1)
 * 思路：记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/18
 */
class Solution {

    private int[][] memo;
    private int m;
    private int n;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
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

        if (col + 1 < n) {
            right = search(row, col + 1);
        }
        if (row + 1 < m) {
            down = search(row + 1, col);
        }
        this.memo[row][col] = right + down;
        return this.memo[row][col];
    }
}
