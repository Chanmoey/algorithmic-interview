package com.moon.algorithmicinterview.array.no4;

/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * @author Chanmoey
 * @date 2023年06月13日
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int dup = 1;
        int top = 0;

        for (int i = 1; i < nums.length; i++) {
            // 找到连续相等的
            if (nums[i] == nums[top]) {
                if (dup == 1) {
                    if (i != top + 1) {
                        nums[++top] = nums[i];
                    } else {
                        top++;
                    }
                    dup++;
                }
                // 找到不相等的
            } else {
                if (top + 1 == i) {
                    top++;
                } else {
                    nums[++top] = nums[i];
                }
                dup = 1;
            }
        }

        return top + 1;
    }
}
