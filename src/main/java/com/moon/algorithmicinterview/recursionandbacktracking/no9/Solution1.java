package com.moon.algorithmicinterview.recursionandbacktracking.no9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * 错误，不够完善的方法，思路是没问题
 *
 * @author Chanmoey
 * @date 2023/8/16
 */
class Solution1 {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int idx, int sum, List<Integer> curCombination) {
        if (sum == target) {
            res.add(curCombination);
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            if (i > idx && candidates[i - 1] == candidates[i]) {
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
