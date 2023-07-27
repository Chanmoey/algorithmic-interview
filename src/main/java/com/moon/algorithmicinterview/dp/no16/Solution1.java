package com.moon.algorithmicinterview.dp.no16;

import java.util.Arrays;

/**
 * 377. Combination Sum IV
 * 状态f(target)表示，在nums中，和为target的排列数量
 * 状态转移：f(target) = sum{f(target-nums[0]]), f(target-nums[1]]), ..., f(target-nums[n-1]])}
 * @author Chanmoey
 * @date 2023/7/27
 */
class Solution1 {

    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        this.memo = new int[target + 1];
        Arrays.fill(this.memo, -1);
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        if (this.memo[target] != -1) {
            return this.memo[target];
        }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }

        this.memo[target] = res;
        return res;
    }
}
