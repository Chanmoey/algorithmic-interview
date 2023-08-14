package com.moon.algorithmicinterview.recursionandbacktracking.no6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 *
 * @author Chanmoey
 * @date 2023/08/14
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();
    private final Set<String> set = new HashSet<>();
    private boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            String permuteStr = subPermute.toString();
            if (!set.contains(permuteStr)) {
                res.add(subPermute);
                set.add(permuteStr);
            }
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
