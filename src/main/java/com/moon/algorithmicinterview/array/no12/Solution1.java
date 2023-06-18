package com.moon.algorithmicinterview.array.no12;

/**
 * 11. Container With Most Water
 *
 * @author Chanmoey
 * @date 2023年06月19日
 */
class Solution1 {


    /**
     * 对撞指针
     * l左侧开始，r右侧开始，如果height[r] < height[l]则r++,以此类推
     *
     * @param height
     * @return
     */
    // [r, l]
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;

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
        return area;
    }
}
