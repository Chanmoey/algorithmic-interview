package com.moon.algorithmicinterview.find.no16;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 * abs(i-j) <= k，那么这个窗口实际大小的值为k+1
 * 维持一个k+1大小的窗口，在窗口内寻找
 *
 * @author Chanmoey
 * @date 2023年06月28日
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        int i = 0;
        // 构建一个k大小的查询表
        Set<Integer> set = new HashSet<>();
        for (; i < k && i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        for (; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            // 删除窗口最前面的元素，并添加最新元素
            set.remove(nums[i - k]);
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
    }
}
