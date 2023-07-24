package com.moon.algorithmicinterview.dp.no15;

/**
 * 322. Coin Change
 * 类似01背包问题
 *
 * @author Chanmoey
 * @date 2023/7/25
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = 10001;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i] <= j) {
                    for (int k = 1; coins[i] * k <= j; k++) {
                        dp[i][j] = Math.min(dp[i - 1][j - coins[i] * k] + k, dp[i][j]);
                    }
                }
            }
        }

        return dp[coins.length - 1][amount] == 10001 ? -1 : dp[coins.length - 1][amount];
    }
}
