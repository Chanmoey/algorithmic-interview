package com.moon.algorithmicinterview.find.no12;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 * 思路：记录3、4两个数组的可能性（和，组合个数），然后在1、2中去查找符合的结果
 *
 * @author Chanmoey
 * @date 2023年06月28日
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;

        for (int k : nums1) {
            for (int j = 0; j < n; j++) {
                int target = -k - nums2[j];
                if (map.containsKey(target)) {
                    res += map.get(target);
                }
            }
        }

        return res;
    }
}
