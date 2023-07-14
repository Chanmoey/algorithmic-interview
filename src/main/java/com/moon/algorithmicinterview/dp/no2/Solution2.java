package com.moon.algorithmicinterview.dp.no2;

import java.util.List;

/**
 * 120. Triangle
 * 思路：动态规划，从最下层往上遍历，遍历之后，最顶层就是结果了
 *
 * @author Chanmoey
 * @date 2023/7/15
 */
public class Solution2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int triangleMaxLevel = triangle.size() - 1;
        // 最底层就是triangle原来的数，已经确定了，所以从倒数第二层开始
        for (int level = triangleMaxLevel - 1; level >= 0; level--) {
            for (int idx = 0; idx < triangle.get(level).size(); idx++) {
                int left = triangle.get(level + 1).get(idx);
                int right = triangle.get(level + 1).get(idx + 1);
                triangle.get(level).set(idx, Math.min(left, right) + triangle.get(level).get(idx));
            }
        }

        return triangle.get(0).get(0);
    }
}
