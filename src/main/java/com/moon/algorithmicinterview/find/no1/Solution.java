package com.moon.algorithmicinterview.find.no1;

/**
 * 349. Intersection of Two Arrays
 * 使用集合的思想
 *
 * @author Chanmoey
 * @date 2023年06月20日
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 1表示该元素在nums1中存在，2表示该元素在nums1和nums2中都存在
        int[] set = new int[1000];
        int[] temp = new int[1000];
        int idx = 0;
        for (int n : nums1) {
            if (set[n] != 1) {
                set[n] ++;
            }
        }

        for (int i : nums2) {
            if (set[i] == 1) {
                temp[idx++] = i;
                set[i] ++;
            }
        }

        int[] res = new int[idx];
        System.arraycopy(temp, 0, res, 0, idx);

        return res;
    }
}