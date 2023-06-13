package com.moon.algorithmicinterview.array.no1;

/**
 * 扫描一遍，把非0移动到前面，并将此时遍历的位置置为0
 *
 * @author Chanmoey
 * @date 2023年06月13日
 */
class Solution1 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
