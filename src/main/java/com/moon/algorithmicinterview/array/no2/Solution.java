package com.moon.algorithmicinterview.array.no2;

/**
 * 27.Remove Element
 *
 * @author Chanmoey
 * @date 2023年06月13日
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (k != i) {
                    nums[k] = nums[i];
                }
                k++;
            }
        }

        return k;
    }
}
