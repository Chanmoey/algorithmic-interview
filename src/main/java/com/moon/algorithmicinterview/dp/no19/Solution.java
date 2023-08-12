package com.moon.algorithmicinterview.dp.no19;

/**
 * 494. Target Sum
 * 思路：回溯法
 *
 * @author Chanmoey
 * @date 2023/8/12
 */
class Solution {

    private int count;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return count;
    }

    private void dfs(int[] nums, int idx, int target) {

        if (idx == nums.length - 1) {

            if (nums[idx] == 0 && target == 0) {
                this.count += 2;
            } else if (Math.abs(nums[idx]) == Math.abs(target)) {
                this.count++;
            }
            return;
        }

        dfs(nums, idx + 1, target + nums[idx]);
        dfs(nums, idx + 1, target - nums[idx]);
    }
}

