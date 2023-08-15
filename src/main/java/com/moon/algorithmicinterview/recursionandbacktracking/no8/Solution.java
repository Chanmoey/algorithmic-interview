package com.moon.algorithmicinterview.recursionandbacktracking.no8;

import java.util.*;

/**
 * 39. Combination Sum
 * @author Chanmoey
 * @date 2023/08/15
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();
    private final Set<String> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> curCombination) {
        int sum = getSum(curCombination);
        if (sum == target) {
            curCombination.sort(Comparator.comparingInt(a -> a));
            String str = curCombination.toString();
            if (!set.contains(str)){
                res.add(curCombination);
                set.add(str);
            }
            return;
        } else if (sum > target) {
            return;
        }

        for (int candidate : candidates) {
            if (candidate + sum <= target) {
                List<Integer> newCurCombination = new ArrayList<>(curCombination);
                newCurCombination.add(candidate);
                dfs(candidates, target, newCurCombination);
            }
        }
    }

    private int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }
}
