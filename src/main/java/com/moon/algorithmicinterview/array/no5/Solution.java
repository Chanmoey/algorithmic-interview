package com.moon.algorithmicinterview.array.no5;

/**
 * 75. Sort Colors
 * 计数排序思想
 *
 * @author Chanmoey
 * @date 2023年06月14日
 */
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            int j;
            for (j = idx; j < idx + count[i]; j++) {
                nums[j] = i;
            }
            idx = j;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortColors(new int[]{2,0,2,1,1,0});
    }
}
