package com.moon.algorithmicinterview.dp.no5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 279. Perfect Squares
 * 思路：记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/17
 */
class Solution {

    private int[] memo;
    private Set<Integer> allSquare = new HashSet<>();

    public int numSquares(int n) {
        int i = 1;
        int square = i * i;
        while (square <= 10000) {
            allSquare.add(square);
            i++;
            square = i * i;
        }
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return minNumSquares(n);
    }

    private int minNumSquares(int n) {
        if (n == 1) {
            return 1;
        }

        if (n <= 0) {
            return 10000;
        }

        if (this.memo[n] != -1) {
            return this.memo[n];
        }

        if (allSquare.contains(n)) {
            this.memo[n] = 1;
            return 1;
        }

        int res = Integer.MAX_VALUE;
        int i = 1;
        int square = i * i;
        while (square < n) {
            if (allSquare.contains(n - square)) {
                res = 2;
                break;
            }
            res = Math.min(res, minNumSquares(n - square) + 1);
            i++;
            square = i * i;
        }
        this.memo[n] = res;
        return res;
    }
}
