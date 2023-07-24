package com.moon.algorithmicinterview.dp.no14;

/**
 * @author Chanmoey
 * @date 2023/7/25
 */

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
class Solution1 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int halfSum = sum / 2;
        boolean[][] memo = new boolean[nums.length][halfSum + 1];
        // 容量为j时，[0, 0]能不能装满背包
        for (int j = 0; j <= halfSum; j++) {
            memo[0][j] = nums[0] == j;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= halfSum; j++) {
                if (nums[i] <= j) {
                    memo[i][j] = memo[i - 1][j] || memo[i-1][j-nums[i]];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[nums.length - 1][halfSum];
    }
}
