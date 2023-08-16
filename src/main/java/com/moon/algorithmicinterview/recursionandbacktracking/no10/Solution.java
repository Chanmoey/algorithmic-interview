package com.moon.algorithmicinterview.recursionandbacktracking.no10;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * @author Chanmoey
 * @date 2023/08/16
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 0, k, n, new ArrayList<>());
        return res;
    }

    /**
     * 在[0, 9]中选择k个数，使得k个数的和为n
     * @param start 从start开始选择数加入组合中
     * @param sum 目前组合中数字的和
     * @param n 目标
     * @param combination 目前找到的组合
     */
    private void dfs(int start, int sum, int k, int n, List<Integer> combination) {
        if (combination.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(combination));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            int tempSum = sum + i;
            if (tempSum <= n && combination.size() < k) {
                combination.add(i);
                dfs(i+1, tempSum, k, n, combination);
                combination.remove(combination.size()-1);
            }
        }
    }
}
