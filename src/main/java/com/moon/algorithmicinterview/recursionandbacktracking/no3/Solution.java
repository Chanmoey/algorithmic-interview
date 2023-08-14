package com.moon.algorithmicinterview.recursionandbacktracking.no3;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * @author Chanmoey
 * @date 2023/08/14
 */
class Solution {

    private final List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    /**
     * 递归找到所有的回文字串
     * @param s 字符串
     * @param start 开始的索引（包括当前索引）
     * @param subArray 当前找到的所有回文
     */
    public void dfs(String s, int start, List<String> subArray) {
        if (start == s.length()) {
            res.add(subArray);
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String subString = s.substring(start, end);
            if (isPalindrome(subString)) {
                List<String> newSubArray = new ArrayList<>(subArray);
                newSubArray.add(subString);
                dfs(s, end, newSubArray);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
