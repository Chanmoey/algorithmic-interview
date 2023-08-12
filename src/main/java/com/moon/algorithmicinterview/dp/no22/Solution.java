package com.moon.algorithmicinterview.dp.no22;

import java.util.Arrays;

/**
 * 1143. Longest Common Subsequence
 *
 * @author Chanmoey
 * @date 2023/8/13
 */
class Solution {

    /**
     * 求text1的0到m与text20到n的最长公共子序列
     */
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        this.memo = new int[m][n];
        for (int[] row : this.memo) {
            Arrays.fill(row, -1);
        }
        return search(text1, text2, m - 1, n - 1);
    }

    private int search(String text1, String text2, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (this.memo[m][n] != -1) {
            return this.memo[m][n];
        }

        int res = 0;
        if (text1.charAt(m) == text2.charAt(n)) {
            res = search(text1, text2, m - 1, n - 1) + 1;
        } else {
            res = Math.max(search(text1, text2, m - 1, n), search(text1, text2, m, n - 1));
        }

        this.memo[m][n] = res;
        return res;
    }
}