package com.moon.algorithmicinterview.array.no5;

/**
 * 75. Sort Colors
 * [0, zero] 1 1 i x x x [two, nums.length - 1]
 *
 * @author Chanmoey
 * @date 2023年06月14日
 */
class Solution1 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; i++) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i);
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
                i--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
