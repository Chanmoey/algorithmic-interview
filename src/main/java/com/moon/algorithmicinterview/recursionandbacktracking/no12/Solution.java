package com.moon.algorithmicinterview.recursionandbacktracking.no12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * @author Chanmoey
 * @date 2023/08/16
 */
class Solution {
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
            if (i > start && nums[i-1] == nums[i]) {
                continue;
            }
            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet);
            subSet.remove(subSet.size() - 1);
        }
    }
}
