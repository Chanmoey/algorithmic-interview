package com.moon.algorithmicinterview.dp.no14;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * 定义状态：f(n, sum)表示，在[0...n]个数字中，是否存在子数组的和为sun
 * 状态转移：f(n, sum) = f(n-1, sum) || f(n-1, sum - nums[n])
 * 分别表示：不考虑将n号物品装进子数组，那么sum不变，或者，考虑将n号物品装进子数组，那么sum改变
 * 重要两个状态有一个能使得sum为0，则说明f(n, sum)满足要求
 *
 * @author Chanmoey
 * @date 2023/7/25
 */
class Solution {

    private int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int halfSum = sum / 2;
        this.memo = new int[nums.length][halfSum + 1];
        for (int[] row : this.memo) {
            Arrays.fill(row, -1);
        }
        return search(nums, nums.length - 1, halfSum);
    }

    /**
     * 在[0...i]中，是否存在子数组使得sum为0
     */
    private boolean search(int[] nums, int i, int sum) {
        if (i < 0 || sum < 0) {
            return false;
        }

        if (sum == 0) {
            return true;
        }

        // -1表示没记忆，0表示不可以，1表示可以
        if (this.memo[i][sum] != -1) {
            return this.memo[i][sum] == 1;
        }

        boolean res = search(nums, i - 1, sum) || search(nums, i - 1, sum - nums[i]);
        this.memo[i][sum] = res ? 1 : 0;
        return res;
    }
}
