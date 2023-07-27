package com.moon.algorithmicinterview.dp.no15;

import java.util.Arrays;

/**
 * 322. Coin Change
 * 状态定义f(amount),当金额为amount时，硬币数组中，能组合成amount的最小硬币数
 * f(amount) = min{f(amount), f(amount - coins[i]) + 1}
 *
 * @author Chanmoey
 * @date 2023/7/25
 */
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // amount为0时，有且只有1中方法，那就是什么都不要，所以需要0个硬币
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
