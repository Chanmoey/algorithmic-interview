package com.moon.algorithmicinterview.recursionandbacktracking.no11;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * 找出nums的所有组合
 * @author Chanmoey
 * @date 2023/08/16
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     * 找出nums的所有组合
     * @param nums 数组
     * @param start 从start开始找组合
     * @param subSet 当前找到的组合
     */
    private void dfs(int[] nums, int start, List<Integer> subSet) {
        this.res.add(new ArrayList<>(subSet));

        for (int i = start; i < nums.length; i++) {
            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet);
            subSet.remove(subSet.size() - 1);
        }
    }
}
