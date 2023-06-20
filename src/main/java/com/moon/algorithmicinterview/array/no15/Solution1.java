package com.moon.algorithmicinterview.array.no15;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * 思路，通过滑动窗口，判断串口内的字符串是不是p的Anagrams
 * 难点：怎么判断窗口内的字符串时P的Anagrams
 * 方案：使用频率map
 *
 * @author Chanmoey
 * @date 2023年06月20日
 */
class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }
        int[] sFeq = new int[26];
        int[] pFeq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFeq[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        List<Integer> res = new ArrayList<>();
        for (; r < p.length() - 1; r++) {
            sFeq[s.charAt(r) - 'a']++;
        }
        // 保持窗口
        for (; r < s.length(); r++, l++) {
            sFeq[s.charAt(r) - 'a']++;
            if (isAnagrams(sFeq, pFeq)) {
                res.add(l);
            }
            sFeq[s.charAt(l) - 'a']--;
        }

        return res;
    }

    private boolean isAnagrams(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
