package com.moon.algorithmicinterview.find.no9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用双指针
 *
 * @author Chanmoey
 * @date 2023年06月26日
 */
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 固定第一个元素，另外两个元素使用2Sum
        for (int i = 0; i < nums.length - 2; i++) {
            // 重复元素从第一个开始考虑，第一个元素特殊考虑
            if (i == 0 || nums[i - 1] != nums[i]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                        // 过滤重复元素
                        while (j < k && nums[j + 1] == nums[j]) {
                            j++;
                        }
                        while (j < k && nums[k - 1] == nums[k]) {
                            k--;
                        }
                        // 去到新的元素上去
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return res;
    }
}
