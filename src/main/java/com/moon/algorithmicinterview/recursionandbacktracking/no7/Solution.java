package com.moon.algorithmicinterview.recursionandbacktracking.no7;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * @author Chanmoey
 * @date 2023/8/15
 */
class Solution {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k > n || k <= 0) {
            return res;
        }

        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    /**
     * 递归找到所有的组合数
     * @param n n
     * @param k k
     * @param i 考虑将i加入到组合中
     * @param curCombine 当前找到的组合数
     */
    public void dfs(int n, int k, int i, List<Integer> curCombine) {

        // 调试使用，提交时删掉
        System.out.println("curCombine: " + curCombine);

        if (k == curCombine.size()) {
            res.add(curCombine);
            return;
        }

        for (int cur = i; cur <= n; cur++) {
            List<Integer> newCurCombine = new ArrayList<>(curCombine);
            newCurCombine.add(cur);
            dfs(n, k, cur + 1, newCurCombine);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.combine(4, 2);
    }
}
