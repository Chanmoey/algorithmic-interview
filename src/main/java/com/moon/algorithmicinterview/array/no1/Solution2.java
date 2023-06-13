package com.moon.algorithmicinterview.array.no1;

/**
 * Solution1的思路，只是进一步优化
 *
 * @author Chanmoey
 * @date 2023年06月13日
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != idx) {
                    temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                }
                idx++;
            }
        }
    }
}
