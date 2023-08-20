package com.moon.algorithmicinterview.recursionandbacktracking.no17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 *
 * @author Chanmoey
 * @date 2023/8/19
 */
class Solution {

    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // -1表示可以到达Pacific Ocean, 1表示可以到达Atlantic Ocean
    // 2表示可以到达两个海洋，3表示什么都不可以
    private int[][] memo;
    private int n;
    private int m;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        this.n = heights.length;
        this.m = heights[0].length;
        if (n == 1 && m == 1) {
            res.add(List.of(0, 0));
            return res;
        }

        this.memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (floodFill(heights, i, j) == 2) {
                    res.add(List.of(i, j));
                }
            }
        }
        System.out.println(Arrays.deepToString(memo));
        return res;
    }

    private int floodFill(int[][] heights, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        boolean pacific = false;
        boolean atlantic = false;
        if (i == 0 || j == 0) {
            pacific = true;
        }
        if (i == this.n - 1 || j == this.m - 1) {
            atlantic = true;
        }


        for (int[] d : DIR) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (inArea(nx, ny) && heights[nx][ny] <= heights[i][j]) {
                int res = floodFill(heights, nx, ny);
                if (res == -1) {
                    pacific = true;
                } else if (res == 1) {
                    atlantic = true;
                } else if (res == 2) {
                    pacific = true;
                    atlantic = true;
                }
            }

            if (pacific && atlantic) {
                memo[i][j] = 2;
            } else if (pacific) {
                memo[i][j] = -1;
            } else if (atlantic) {
                memo[i][j] = 1;
            } else {
                memo[i][j] = 3;
            }
        }

        return memo[i][j];
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.n && ny >= 0 && ny < this.m;
    }
}
