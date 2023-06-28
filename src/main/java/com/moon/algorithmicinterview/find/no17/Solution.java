package com.moon.algorithmicinterview.find.no17;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * 典型的查找问题，直接遍历+Set即可
 *
 * @author Chanmoey
 * @date 2023年06月28日
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
