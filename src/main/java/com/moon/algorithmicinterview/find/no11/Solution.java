package com.moon.algorithmicinterview.find.no11;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * 思路：排序后2Sum
 *
 * @author Chanmoey
 * @date 2023年06月27日
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return target;
                } else {
                    int tempDiff = Math.abs(temp - target);
                    if (tempDiff < diff) {
                        diff = tempDiff;
                        res = temp;
                    }
                    if (temp < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
