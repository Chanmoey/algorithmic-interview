package com.moon.algorithmicinterview.array.no1;

/**
 * 扫描一遍，把非0拿出来
 *
 * @author Chanmoey
 * @date 2023年06月13日
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int[] noZero = new int[nums.length];
        int idx = 0;

        // 取出非0
        for (int num : nums) {
            if (num != 0) {
                noZero[idx++] = num;
            }
        }

        // 放回非0
        for (int i = 0; i < nums.length; i++) {
            if (i < idx) {
                nums[i] = noZero[i];
            } else {
                nums[i] = 0;
            }
        }
    }
}
