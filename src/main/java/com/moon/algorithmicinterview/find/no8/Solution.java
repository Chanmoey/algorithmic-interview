package com.moon.algorithmicinterview.find.no8;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * 规定只有一个解，不能使用相同元素
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tempTarget = target - nums[i];
            if (map.containsKey(tempTarget)) {
                return new int[]{map.get(tempTarget), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
