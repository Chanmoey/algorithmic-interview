package com.moon.algorithmicinterview.array.no15;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 * 思路，通过滑动窗口，判断串口内的字符串是不是p的Anagrams
 * 难点：怎么判断窗口内的字符串时P的Anagrams
 * 方案：使用HashMap
 *
 * @author Chanmoey
 * @date 2023年06月20日
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }
        List<Integer> res = new ArrayList<>();
        Set<Character> pSet = new HashSet<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pSet.add(c);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        pMap.put('T', p.length());

        int l = 0;
        int r = 0;
        for (; r < p.length() - 1; r++) {
            if (pSet.contains(s.charAt(r))) {
                if (pMap.get(s.charAt(r)) > 0) {
                    pMap.put('T', pMap.get('T') - 1);
                }
                pMap.put(s.charAt(r), pMap.get(s.charAt(r)) - 1);
            }
        }
        // 保持窗口
        for (; r < s.length(); r++) {
            if (pSet.contains(s.charAt(r))) {
                if (pMap.get(s.charAt(r)) > 0) {
                    pMap.put('T', pMap.get('T') - 1);
                }
                pMap.put(s.charAt(r), pMap.get(s.charAt(r)) - 1);
            }
            if (pMap.get('T') == 0) {
                res.add(l);
            }
            if (pSet.contains(s.charAt(l))) {
                if (pMap.get(s.charAt(l)) >= 0) {
                    pMap.put('T', pMap.get('T') + 1);
                }
                pMap.put(s.charAt(l), pMap.get(s.charAt(l)) + 1);
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findAnagrams("cbaebabacd", "abc");
    }
}
