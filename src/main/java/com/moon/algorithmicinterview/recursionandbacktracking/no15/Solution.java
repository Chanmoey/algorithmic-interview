package com.moon.algorithmicinterview.recursionandbacktracking.no15;

/**
 * 200. Number of Islands
 *
 * @author Chanmoey
 * @date 2023/8/19
 */
class Solution {

    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    /**
     * n行
     * m列
     */
    private int n;
    private int m;

    private int islandNum = 0;

    public int numIslands(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;

        this.visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandNum++;
                    floodFill(grid, i, j);
                }
            }
        }

        return islandNum;
    }

    private void floodFill(char[][] grid, int x, int y) {

        this.visited[x][y] = true;

        for (int[] d : DIR) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (inArea(nx, ny) && grid[nx][ny] == '1' && !visited[nx][ny]) {
                floodFill(grid, nx, ny);
            }
        }

    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.n && ny >= 0 && ny < this.m;
    }
}