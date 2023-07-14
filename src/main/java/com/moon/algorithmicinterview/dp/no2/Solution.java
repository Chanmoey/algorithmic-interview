package com.moon.algorithmicinterview.dp.no2;

import java.util.List;

/**
 * 120. Triangle
 * 思路：设最高层为n，从 MINf(n, i) = MIN(f(n-1, i)， f(n-1, i+1)) + 当前位置数
 * 思路是正确的，但是，存在大量重叠子问题，复杂度太高，所以不行
 * @author Chanmoey
 * @date 2023/7/15
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0);
    }

    /**
     * 递归
     * @param triangle 三角形
     * @param level 当前层级
     * @param idx 当前层级访问元素的位置
     * @return 最小路径
     */
    private int minimumTotal(List<List<Integer>> triangle, int level, int idx) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(idx);
        }

        int left = minimumTotal(triangle, level + 1, idx);
        int right = Integer.MAX_VALUE;
        if (idx + 1 < triangle.get(level + 1).size()) {
            right = minimumTotal(triangle, level + 1, idx + 1);
        }

        return triangle.get(level).get(idx) + Math.min(left, right);
    }
}
