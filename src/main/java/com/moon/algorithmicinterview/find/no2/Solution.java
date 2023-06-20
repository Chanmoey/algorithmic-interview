package com.moon.algorithmicinterview.find.no2;

/**
 * 350. Intersection of Two Arrays II
 * 使用Map的思想
 *
 * @author Chanmoey
 * @date 2023年06月20日
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // map的索引充当key，存储的元素充当value，表示元素出现的频率
        int[] map = new int[1000];
        for (int n : nums1) {
            map[n]++;
        }
        int[] temp = new int[1000];
        int idx = 0;
        for (int i : nums2) {
            if (map[i] > 0) {
                temp[idx++] = i;
                map[i] --;
            }
        }

        int[] res = new int[idx];
        System.arraycopy(temp, 0, res, 0, idx);
        return res;
    }
}
