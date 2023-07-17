package com.moon.algorithmicinterview.dp.no6;

import java.util.Arrays;

/**
 * 91. Decode Ways
 * 以"11106"为例，索引start为0的位置，可以由"1101" + "106"的可能是组成，以此类推
 * 思路：记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/17
 */
class Solution {

    private int[] memo;

    public int numDecodings(String s) {
        this.memo = new int[s.length() + 1];
        Arrays.fill(this.memo, -1);
        // ""有一种表示方式，那就什么都不表示
        this.memo[s.length()] = 1;
        return search(s, 0);
    }

    public int search(String s, int start) {
        if (this.memo[start] != -1) {
            return this.memo[start];
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        int res = search(s, start + 1);
        if (start + 1 < s.length() && Integer.parseInt(s.substring(start, start + 2)) <= 26) {
            res += search(s, start + 2);
        }
        this.memo[start] = res;
        return res;
    }
}
