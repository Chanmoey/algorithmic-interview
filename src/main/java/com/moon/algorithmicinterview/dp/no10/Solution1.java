package com.moon.algorithmicinterview.dp.no10;

/**
 * 213. House Robber II
 * 思路和198差不多，只是因为首位相邻，需要特殊考虑，通双dp数组，分别考虑两种不同的情况
 * @author Chanmoey
 * @date 2023/7/20
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
        // dp1[i]表示从[i, n-1]所能偷取到的最大值
        int[] dp1 = new int[n];
        // 最后一个可能偷
        dp1[n - 1] = nums[n - 1];
        dp1[n - 2] = Math.max(nums[n - 1], nums[n - 2]);

        // 最后一个不偷
        int[] dp2 = new int[n];
        dp2[n-2] = nums[n-2];
        for (int i = n - 3; i >= 1; i--) {
            dp1[i] = Math.max(dp1[i + 1], nums[i] + dp1[i + 2]);
            dp2[i] = Math.max(dp2[i + 1], nums[i] + dp2[i + 2]);
        }
        // dp1第0个不偷
        dp1[0] = dp1[1];
        // dp2第0个可能偷
        dp2[0] = Math.max(nums[0] + dp2[2], dp2[1]);
        return Math.max(dp1[0], dp2[0]);
    }
}
