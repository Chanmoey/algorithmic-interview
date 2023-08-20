package com.moon.algorithmicinterview.recursionandbacktracking.no16;

import java.util.HashSet;
import java.util.Set;

/**
 * 130. Surrounded Regions
 * 逆向思维：找出不能反转的位置，其他都翻转过来
 *
 * @author Chanmoey
 * @date 2023/8/19
 */
class Solution2 {

    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private int n;
    private int m;

    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.visited = new boolean[n][m];

        Set<int[]> list = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        floodFill(board, i, j, list);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = 'X';
            }
        }

        for (int[] p : list.stream().toList()) {
            board[p[0]][p[1]] = 'O';
        }
    }

    private void floodFill(char[][] board, int i, int j, Set<int[]> list) {

        list.add(new int[]{i, j});
        this.visited[i][j] = true;
        for (int[] d : DIR) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (inArea(nx, ny) && !visited[nx][ny] && board[nx][ny] == 'O') {
                floodFill(board, nx, ny, list);
            }
        }
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.n && ny >= 0 && ny < this.m;
    }
}