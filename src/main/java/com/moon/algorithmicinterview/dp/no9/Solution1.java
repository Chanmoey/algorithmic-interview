package com.moon.algorithmicinterview.dp.no9;

/**
 * 198. House Robber
 * 状态定义：f(0)表示，从0号开始，尝试偷取，所能获取到的最大收益。
 * f(0) = max{0 + f(2), 1 + f(3), 2 + f(4), ..., n - 3 + f(n - 1), n - 2, n - 1}
 *
 * @author Chanmoey
 * @date 2023/7/18 9:47
 */
class Solution1 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        // dp[i]表示从[i, n-1]所能偷取到的最大值
        int[] dp = new int[n];
        // 最后一个必然偷
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}