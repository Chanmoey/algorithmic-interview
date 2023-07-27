package com.moon.algorithmicinterview.dp.no15;

import java.util.Arrays;

/**
 * 322. Coin Change
 * 状态定义f(amount),当金额为amount时，硬币数组中，能组合成amount的最小硬币数
 * f(amount) = min{f(amount), f(amount - coins[i]) + 1}
 * 使用记忆化搜索
 * @author Chanmoey
 * @date 2023/7/25
 */
class Solution2 {

    private int[] memo;
    private int max;

    public int coinChange(int[] coins, int amount) {
        this.max = amount + 1;
        this.memo = new int[amount + 1];
        Arrays.fill( this.memo, -1);
        // amount为0时，有且只有1中方法，那就是什么都不要，所以需要0个硬币
        this.memo[0] = 0;

        int res = search(coins, amount);
        return res == max ? -1 : res;
    }

    private int search(int[] coins, int amount) {
        if (this.memo[amount] != -1) {
            return this.memo[amount];
        }

        int res = max;
        for (int coin : coins) {
            if (amount >= coin) {
                res = Math.min(res, search(coins, amount - coin) + 1);
            }
        }

        this.memo[amount] = res;
        return res;
    }
}
