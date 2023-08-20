package com.moon.algorithmicinterview.recursionandbacktracking.no17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * 逆向思考，从海洋能逆向升上陆地的
 *
 * @author Chanmoey
 * @date 2023/8/19
 */
class Solution2 {

    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // -1表示可以到达Pacific Ocean, 1表示可以到达Atlantic Ocean
    // 2表示可以到达两个海洋，3表示什么都不可以

    private int n;
    private int m;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] atlantic;
        boolean[][] pacific;
        List<List<Integer>> res = new ArrayList<>();
        this.n = heights.length;
        this.m = heights[0].length;
        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];

        for (int i = 0; i < this.m; i++) {
            floodFill(heights, 0, i, pacific);
            floodFill(heights, this.n - 1, i, atlantic);
        }

        for (int i = 0; i < this.n; i++) {
            floodFill(heights, i, 0, pacific);
            floodFill(heights, i, this.m - 1, atlantic);
        }

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void floodFill(int[][] heights, int i, int j, boolean[][] sea) {
        sea[i][j] = true;

        for (int[] d : DIR) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (inArea(nx, ny) && !sea[nx][ny] && heights[nx][ny] >= heights[i][j]) {
                floodFill(heights, nx, ny, sea);
            }
        }
    }

    private boolean inArea(int nx, int ny) {
        return nx >= 0 && nx < this.n && ny >= 0 && ny < this.m;
    }
}
