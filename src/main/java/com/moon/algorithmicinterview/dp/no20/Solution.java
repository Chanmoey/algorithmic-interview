package com.moon.algorithmicinterview.dp.no20;

/**
 * 300. Longest Increasing Subsequence
 * @author Chanmoey
 * @date 2023/8/12
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // [0...i]能组成的最长上升子序列
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, lis[j] + 1);
                }
            }
            lis[i] = tempMax;
            res = Math.max(res, tempMax);
        }

        return res;
    }
}
