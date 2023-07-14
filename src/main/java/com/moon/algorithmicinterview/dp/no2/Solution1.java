package com.moon.algorithmicinterview.dp.no2;

import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 * 思路：记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/15
 */
class Solution1 {

    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] row : this.memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return minimumTotal(triangle, 0, 0);
    }

    /**
     * 递归
     *
     * @param triangle 三角形
     * @param level    当前层级
     * @param idx      当前层级访问元素的位置
     * @return 最小路径
     */
    private int minimumTotal(List<List<Integer>> triangle, int level, int idx) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(idx);
        }

        // 查看 level，idx 位置是否有结果
        if (this.memo[level][idx] != Integer.MIN_VALUE) {
            return this.memo[level][idx];
        }

        int left = minimumTotal(triangle, level + 1, idx);
        int right = Integer.MAX_VALUE;
        if (idx + 1 < triangle.get(level + 1).size()) {
            right = minimumTotal(triangle, level + 1, idx + 1);
        }

        this.memo[level][idx] = triangle.get(level).get(idx) + Math.min(left, right);
        return this.memo[level][idx];
    }
}
