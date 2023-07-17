package com.moon.algorithmicinterview.dp.no5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 279. Perfect Squares
 * 思路：优化记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/17
 */
class Solution1 {

    private int[] memo;

    public int numSquares(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return minNumSquares(n);
    }

    private int minNumSquares(int n) {
        // 这里可以去掉
        if (n == 1) {
            return 1;
        }

        if (this.memo[n] != -1) {
            return this.memo[n];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; ; i++) {
            int temp = n - i * i;
            if (temp < 0) {
                break;
            } else if (temp == 0) {
                res = 1;
            } else {
                res = Math.min(res, minNumSquares(temp) + 1);
            }
        }
        this.memo[n] = res;
        return res;
    }
}
