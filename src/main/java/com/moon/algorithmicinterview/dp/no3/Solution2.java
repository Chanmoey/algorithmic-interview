package com.moon.algorithmicinterview.dp.no3;

/**
 * 64. Minimum Path Sum
 * 思路：f(n,n) = MIN(f(n+1, n), f(n, n+1)) + grid[n][n]
 * -                   往下走      往左走
 * 记忆化搜索：
 *
 * @author Chanmoey
 * @date 2023/7/15
 */
class Solution2 {

    private int m;
    private int n;
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n];
        // 初始化记忆集
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                this.memo[i][j] = Integer.MIN_VALUE;
            }
        }
        this.memo[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int col = n - 2; col >= 0; col--) {
            this.memo[m - 1][col] = grid[m - 1][col] + this.memo[m - 1][col + 1];
        }
        for (int row = m - 2; row >= 0; row--) {
            this.memo[row][n - 1] = grid[row][n - 1] + this.memo[row + 1][n - 1];
        }
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int row, int col) {
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

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }
}
