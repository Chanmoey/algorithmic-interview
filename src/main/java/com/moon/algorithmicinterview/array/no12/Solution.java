package com.moon.algorithmicinterview.array.no12;

/**
 * 11. Container With Most Water
 * 接雨水
 *
 * @author Chanmoey
 * @date 2023年06月19日
 */
class Solution {

    private int area = 0;

    /**
     * 对撞指针
     * l左侧开始，r右侧开始，如果height[r] < height[l]则r++,以此类推
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        maxArea(height, 0, height.length - 1);
        return area;
    }

    // [r, l]
    public void maxArea(int[] height, int l, int r) {
        if (l >= r) {
            return;
        }

        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else if (height[l] > height[r]) {
                r--;
            } else {
                l++;
                r--;
            }
        }
    }
}
