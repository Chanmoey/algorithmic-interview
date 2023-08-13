package com.moon.algorithmicinterview.recursionandbacktracking.no1;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * @author Chanmoey
 * @date 2023/8/14
 */
class Solution {

    private final List<String> res = new ArrayList<>();

    private static final String[] LETTER_MAP =
            {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 找到所有可能的组合
     * @param digits 数字字符串
     * @param idx 使用哪个数字
     * @param prefix idx之前数字所组成的字串
     */
    private void findCombination(String digits, int idx, String prefix) {
        if (idx == digits.length()) {
            res.add(prefix);
            return;
        }

        String letter = LETTER_MAP[digits.charAt(idx) - '0'];
        for (char c : letter.toCharArray()) {
            findCombination(digits, idx + 1, prefix + c);
        }
    }
}
