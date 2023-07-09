package com.moon.algorithmicinterview.find.no18;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * 维护一个滑动窗口，在滑动窗口内，查询
 *
 * @author Chanmoey
 * @date 2023/6/29 12:35
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> orderSet = new TreeSet<Long>();
        // 创建一个indexDiff大小的窗口，实际查找大小应该是indexDiff + 1
        int i;
        for (i = 0; i < indexDiff; i++) {
            if (orderSet.ceiling((long) nums[i] - (long) valueDiff) != null &&
                    orderSet.ceiling((long) nums[i] - (long) valueDiff) <= (long) nums[i] + (long) valueDiff) {
                return true;
            }
            orderSet.add((long) nums[i]);
        }

        for (; i < nums.length; i++) {
            if (orderSet.ceiling((long) nums[i] - (long) valueDiff) != null &&
                    orderSet.ceiling((long) nums[i] - (long) valueDiff) <= (long) nums[i] + (long) valueDiff) {
                return true;
            } else {
                orderSet.remove((long) nums[i - indexDiff]);
                orderSet.add((long) nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 1);
    }
}