package com.moon.algorithmicinterview.find.no14;


import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * 思路： i j k，i到j与j到k的距离相等。
 * 那么，以每一个元素为j，再次遍历其他元素到它的距离，并记录下来
 * 遍历查找表，计算次数
 *
 * @author Chanmoey
 * @date 2023年06月28日
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int j = 0; j < points.length; j++) {
            Map<Integer, Integer> map = new HashMap<>(2 * points.length);
            for (int i = 0; i < points.length; i++) {
                if (i != j) {
                    int distance = dis(points[i], points[j]);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }
            for (int freq : map.values()) {
                if (freq >= 2) {
                    // 排列思想：第一次有freq种选择，第二次有freq-1中选择
                    res += freq * (freq - 1);
                }
            }
        }
        return res;
    }

    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}