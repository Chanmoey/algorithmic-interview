package com.moon.algorithmicinterview.array.no3;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * @author Chanmoey
 * @date 2023年06月13日
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // top指向去重完成数组的最后一个元素，默认[0, 0]为去重完成
        int top = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[top] != nums[i]) {
                if (top + 1 != i) {
                    nums[++top] = nums[i];
                } else {
                    top++;
                }

            }
        }

        return top + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{1, 1, 2});
    }
}
