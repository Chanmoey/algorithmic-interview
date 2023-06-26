package com.moon.algorithmicinterview.find.no10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * 思路：排序，固定第一个，固定第二个，然后对于第三个和第四个使用2Sum
 *
 * @author Chanmoey
 * @date 2023年06月27日
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        long longTarget = target;
        for (int i = 0; i < nums.length - 3; i++) {
            // 首位特殊考虑，去除重复元素
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 首位图书考虑，去除重复元素
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 找到了
                    long tmp = (long) nums[i] + (long) nums[j] + nums[left] + nums[right];
                    if (tmp == longTarget) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        // 去除重复元素
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (tmp < target) {
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
