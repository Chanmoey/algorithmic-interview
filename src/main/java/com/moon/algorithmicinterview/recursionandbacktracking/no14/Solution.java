package com.moon.algorithmicinterview.recursionandbacktracking.no14;

/**
 * 79. Word Search
 *
 * @author Chanmoey
 * @date 2023/8/17
 */
class Solution {

    private static final int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length() - 1 && board[i][j] == word.charAt(idx)) {
            return true;
        }

        if (board[i][j] == word.charAt(idx)) {
            this.visited[i][j] = true;
            for (int[] d : DIR) {
                int nx = i + d[0];
                int ny = j + d[1];
                if (inArea(nx, ny) && !visited[nx][ny] && search(board, word, nx, ny, idx + 1)) {
                    return true;
                }
            }
            this.visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.m && ny >= 0 && ny < this.n;
    }
}
