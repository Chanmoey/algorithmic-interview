package com.moon.algorithmicinterview.dp.no13;

import java.util.Arrays;

/**
 * 01背包问题：每个物品，有重量wi，和价值vi，背包容量C，如何使得装到背包里的物品，价值最大
 * f(n, c)为：当背包容量为c时，考虑将n号货物装到背包里的最大价值
 * f(n, c) = max{f(n - 1, c), vn + f(n-1, c - wn)))}
 * 意思为：不将n号物品装进背包，此时背包容量不变，或者将n号物品放进背包，加上状态f(n-1, c - wn)
 *
 * @author Chanmoey
 * @date 2023/7/24
 */
public class Knapsack01 {

    /**
     * 第i行，第j列表示，当背包容量为j时，考虑将i号物品装进背包的最大价值
     */
    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        //  0到n-1行，0到c列
        this.memo = new int[n][c + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return search(w, v, n - 1, c);
    }

    // 用[0...i]的物品，填充溶剂为c的背包的最大价值
    public int search(int[] w, int[] v, int i, int c) {
        if (c <= 0 || i < 0) {
            return 0;
        }

        if (this.memo[i][c] != -1) {
            return this.memo[i][c];
        }

        int res = search(w, v, i - 1, c);
        if (c >= w[i]) {
            res = Math.max(res, search(w, v, i - 1, c - w[i]) + v[i]);
        }

        this.memo[i][c] = res;
        return res;
    }

}
