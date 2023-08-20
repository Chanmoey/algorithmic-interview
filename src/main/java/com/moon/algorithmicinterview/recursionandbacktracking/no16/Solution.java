package com.moon.algorithmicinterview.recursionandbacktracking.no16;

/**
 * 130. Surrounded Regions
 * 错
 *
 * @author Chanmoey
 * @date 2023/8/19
 */
class Solution {

    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private int n;
    private int m;

    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    floodFill(board, i, j);
                }
            }
        }
    }

    /**
     * @return true表示需要将状态变回来
     */
    private boolean floodFill(char[][] board, int i, int j) {
        if (!inArea(i, j)) {
            return true;
        } else if (board[i][j] == 'X') {
            return false;
        }

        // 先翻转过去
        board[i][j] = 'X';
        this.visited[i][j] = true;
        boolean returnBack = false;
        for (int[] d : DIR) {
            int nx = i + d[0];
            int ny = j + d[1];
            returnBack = returnBack || floodFill(board, nx, ny);
        }
        if (returnBack) {
            board[i][j] = 'O';
        }

        return returnBack;
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.n && ny >= 0 && ny < this.m;
    }
}