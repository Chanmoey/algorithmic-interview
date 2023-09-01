package com.moon.algorithmicinterview.recursionandbacktracking.no19;

/**
 * 52. N-Queens II
 * @author Chanmoey
 * @date 2023/8/29
 */
class Solution {

    private boolean[] col;
    private boolean[] rightUp;
    private boolean[] leftUp;
    private int res;

    public int totalNQueens(int n) {
        // 列，ture表示该列已经有皇后了
        this.col = new boolean[n];
        this.rightUp = new boolean[2 * n - 1];
        this.leftUp = new boolean[2 * n - 1];
        combination(0, n);
        return res;
    }

    /**
     * 考虑在x行放置皇后
     * @param x x
     */
    private void combination(int x, int n) {

        if (x == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !rightUp[x + i] && !leftUp[x - i + n - 1]) {
                col[i] = true;
                rightUp[x + i] = true;
                leftUp[x - i + n - 1] = true;
                combination(x + 1, n);
                col[i] = false;
                rightUp[x + i] = false;
                leftUp[x - i + n - 1] = false;
            }
        }
    }
}