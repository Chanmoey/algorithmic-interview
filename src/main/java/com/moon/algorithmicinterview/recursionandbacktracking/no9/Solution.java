package com.moon.algorithmicinterview.recursionandbacktracking.no9;

import java.util.*;

/**
 * 40. Combination Sum II
 * 错误，不够完善的方法，思路是没问题
 * @author Chanmoey
 * @date 2023/8/16
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();
    /**
     * 记录，每一个组合中，每一个位置，已经有了哪些元素
     */
    private final Map<Integer, Set<Integer>> map = new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int idx, int sum, List<Integer> curCombination) {
        if (sum == target) {
            res.add(curCombination);
            for (int i = 0; i < curCombination.size(); i++) {
                map.computeIfAbsent(i, k -> new HashSet<>()).add(curCombination.get(i));
            }
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            if (map.computeIfAbsent(curCombination.size(), k -> new HashSet<>()).contains(candidates[i])) {
                continue;
            }

            int tempSum = sum + candidates[i];
            if (tempSum <= target) {
                List<Integer> newCurCombination = new ArrayList<>(curCombination);
                newCurCombination.add(candidates[i]);
                dfs(candidates, target, i + 1, tempSum, newCurCombination);
            }
        }
    }
}
