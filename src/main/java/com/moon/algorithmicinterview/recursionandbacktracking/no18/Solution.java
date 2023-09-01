package com.moon.algorithmicinterview.recursionandbacktracking.no18;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * @author Chanmoey
 * @date 2023/8/29
 */
class Solution {

    private boolean[] col;
    private boolean[] rightUp;
    private boolean[] leftUp;
    private List<List<Integer>> idxList;

    public List<List<String>> solveNQueens(int n) {
        // 列，ture表示该列已经有皇后了
        this.col = new boolean[n];
        this.rightUp = new boolean[2 * n - 1];
        this.leftUp = new boolean[2 * n - 1];
        this.idxList = new ArrayList<>();
        combination(0, n, new ArrayList<>());

        return buildStringList(idxList, n);
    }

    private List<List<String>> buildStringList(List<List<Integer>> idxList, int n) {
        List<List<String>> res = new ArrayList<>();
        for (List<Integer> list : idxList) {
            List<String> temp = new ArrayList<>();
            for (Integer i : list) {
                StringBuilder sb = new StringBuilder();
                int j = 0;
                for (; j < i; j++) {
                    sb.append(".");
                }
                sb.append('Q');
                j++;
                for (; j < n; j++) {
                    sb.append(".");
                }
                temp.add(sb.toString());
            }
            res.add(temp);
        }

        return res;
    }

    /**
     * 考虑在x行放置皇后
     * @param x x
     * @param list 当前找的的序列
     */
    private void combination(int x, int n, List<Integer> list) {

        if (x == n) {
            idxList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !rightUp[x + i] && !leftUp[x - i + n - 1]) {
                col[i] = true;
                rightUp[x + i] = true;
                leftUp[x - i + n - 1] = true;
                list.add(i);
                combination(x + 1, n, list);
                list.remove(list.size() - 1);
                col[i] = false;
                rightUp[x + i] = false;
                leftUp[x - i + n - 1] = false;
            }
        }
    }
}
