package com.moon.algorithmicinterview.recursionandbacktracking.no8;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * 整体思想不变，优化了去重逻辑
 * @author Chanmoey
 * @date 2023/08/15
 */
class Solution1 {

    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            int tempSum = sum + candidates[i];
            if (tempSum <= target) {
                List<Integer> newCurCombination = new ArrayList<>(curCombination);
                newCurCombination.add(candidates[i]);
                // next start idx is still i, because the element can use any times
                dfs(candidates, target, i, tempSum, newCurCombination);
            }
        }
    }
}
