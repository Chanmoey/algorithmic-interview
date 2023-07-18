package com.moon.algorithmicinterview.dp.no9;

import java.util.Arrays;

/**
 * 198. House Robber
 * 状态定义：f(0)表示，从0号开始，尝试偷取，所能获取到的最大收益。
 * f(0) = max{0 + f(2), 1 + f(3), 2 + f(4), ..., n - 3 + f(n - 1), n - 2, n - 1}
 *
 * @author Chanmoey
 * @date 2023/7/18 9:47
 */
class Solution {

    private int[] memo;
    private int[] nums;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;
        this.memo = new int[nums.length];
        Arrays.fill(this.memo, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, search(i));
        }
        return res;
    }

    private int search(int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        if (this.memo[idx] != -1) {
            return this.memo[idx];
        }

        int res = 0;
        for (int i = idx; i < nums.length; i++) {
            res = Math.max(res, nums[idx] + search(i + 2));
        }

        this.memo[idx] = res;
        return res;
    }
}
