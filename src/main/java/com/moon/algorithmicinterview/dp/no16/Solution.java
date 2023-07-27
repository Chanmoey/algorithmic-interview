package com.moon.algorithmicinterview.dp.no16;

import java.util.Arrays;

/**
 * 377. Combination Sum IV
 * 状态f(target)表示，在nums中，和为target的排列数量
 * 状态转移：f(target) = sum{f(target-nums[0]]), f(target-nums[1]]), ..., f(target-nums[n-1]])}
 * @author Chanmoey
 * @date 2023/7/27
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int res = 0;
            for (int num : nums) {
               if (i >= num) {
                   res += dp[i - num];
               }
            }
            dp[i] = res;
        }

        return dp[target];
    }
}
