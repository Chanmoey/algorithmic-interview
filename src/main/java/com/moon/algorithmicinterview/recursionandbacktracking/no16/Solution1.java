package com.moon.algorithmicinterview.recursionandbacktracking.no16;

import java.util.ArrayList;
import java.util.List;

/**
 * 130. Surrounded Regions
 * 错
 * @author Chanmoey
 * @date 2023/8/19
 */
class Solution1 {

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
                    List<int[]> list = new ArrayList<>();
                    boolean returnBack = floodFill(board, i, j, list);
                    if (!returnBack) {
                        for (int[] p : list) {
                            board[p[0]][p[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    /**
     * @return true表示需要将状态变回来
     */
    private boolean floodFill(char[][] board, int i, int j, List<int[]> list) {
        if (board[i][j] == 'X') {
            return false;
        }

        list.add(new int[]{i, j});
        this.visited[i][j] = true;
        boolean returnBack = false;
        for (int[] d : DIR) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (!inArea(nx, ny)) {
                return true;
            }
            if (!visited[nx][ny]) {
                returnBack = returnBack || floodFill(board, nx, ny, list);
            }
        }
        return returnBack;
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.n && ny >= 0 && ny < this.m;
    }
}