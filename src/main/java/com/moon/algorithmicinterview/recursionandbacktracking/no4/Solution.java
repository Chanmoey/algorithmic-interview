package com.moon.algorithmicinterview.recursionandbacktracking.no4;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * @author Chanmoey
 * @date 2023/08/14
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        this.visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return res;
    }

    /**
     * 递归找到所有的排列
     * @param nums 原始数组
     * @param subPermute 目前找到的排列
     */
    private void dfs(int[] nums, List<Integer> subPermute) {
        if (nums.length == subPermute.size()) {
            res.add(subPermute);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                List<Integer> newSubPermute = new ArrayList<>(subPermute);
                newSubPermute.add(nums[i]);
                visited[i] = true;
                dfs(nums, newSubPermute);
                // 恢复状态
                visited[i] = false;
            }
        }
    }
}
