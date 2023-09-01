package com.moon.algorithmicinterview.recursionandbacktracking.no20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 37. Sudoku Solver
 *
 * @author Chanmoey
 * @date 2023/8/30
 */
class Solution {

    /**
     * 记录每行使用过的数字
     */
    private Map<Integer, Set<Integer>> row = new HashMap<>();
    /**
     * 记录每列使用过的数字
     */
    private Map<Integer, Set<Integer>> col = new HashMap<>();
    /**
     * 记录每个3*3的格子使用过的数字
     */
    private Map<String, Set<Integer>> subBoard = new HashMap<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            row.put(i, new HashSet<>());
            for (int j = 0; j < board[0].length; j++) {
                col.computeIfAbsent(j, k -> new HashSet<>());
                String key = i / 3 + "" + j / 3;
                subBoard.computeIfAbsent(key, k -> new HashSet<>());
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row.get(i).add(num);
                    col.get(j).add(num);
                    subBoard.get(key).add(num);
                }
            }
        }
        combination(board, 0, 0);
    }

    /**
     * 考虑在x，y处，放入数字
     * @param board 棋盘
     * @param x 行坐标
     * @param y 列坐标
     */
    public boolean combination(char[][] board, int x, int y) {
        if (x >= 9) {
            // 成功找到了一个解，不需要回退
            return false;
        }
        // 已经有数字了，直接下一个
        if (board[x][y] != '.') {
            if (y == 8) {
                return combination(board, x + 1, 0);
            } else {
                return combination(board, x, y + 1);
            }
        }

        String key = x / 3 + "" + y / 3;
        for (int i = 1; i <= 9; i++) {
            if (row.get(x).contains(i) || col.get(y).contains(i) || subBoard.get(key).contains(i)) {
                continue;
            }
            board[x][y] = (char) ('0' + i);
            row.get(x).add(i);
            col.get(y).add(i);
            subBoard.get(key).add(i);
            boolean returnBack;
            if (y == 8) {
                returnBack = combination(board, x + 1, 0);
            } else {
                returnBack =  combination(board, x, y + 1);
            }
            if (returnBack) {
                board[x][y] = '.';
                row.get(x).remove(i);
                col.get(y).remove(i);
                subBoard.get(key).remove(i);
            } else {
                return false;
            }
        }
        // 上面的1到9都尝试过，无法找到解，说明之前出错了，需要回滚
        return true;
    }
}