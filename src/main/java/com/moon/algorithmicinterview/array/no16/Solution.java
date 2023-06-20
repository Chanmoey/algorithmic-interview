package com.moon.algorithmicinterview.array.no16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 76. Minimum Window Substring
 * 错误的答案
 * @author Chanmoey
 * @date 2023年06月20日
 */
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        } else if (s.equals(t)) {
            return t;
        } else if (t.length() == 1) {
            for (int i = 0; i < s.length();i++) {
                if (s.charAt(i) == t.charAt(0)) {
                    return t;
                }
            }
            return "";
        }

        Set<Character> tSet = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            tSet.add(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.put('*', t.length());


        int l = 0;
        int r;
        for (; l < s.length(); l++) {
            if (tSet.contains(s.charAt(l))) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                map.put('*', map.get('*') - 1);
                break;
            }
        }

        int resLen = Integer.MAX_VALUE;
        String res = "";
        for (r = l + 1; r < s.length(); r++) {
            if (tSet.contains(s.charAt(r))) {
                if (map.get(s.charAt(r)) > 0) {
                    map.put('*', map.get('*') - 1);
                }
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
            }

            // 找到了答案
            if (map.get('*') == 0) {
                if (resLen > (r - l + 1)) {
                    res = s.substring(l, r + 1);
                    resLen = res.length();
                }

                if (map.get(s.charAt(l)) >= 0) {
                    map.put('*', map.get('*') + 1);
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                l++;
                while (l < r) {
                    if (tSet.contains(s.charAt(l))) {
                        if (map.get('*') == 0 && (resLen > (r - l + 1))) {
                                res = s.substring(l, r + 1);
                                resLen = res.length();

                        }
                        if (map.get(s.charAt(l)) == 0) {
                            break;
                        }
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    }
                    l++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minWindow("aaflslflsldkalskaaa", "aa");
    }
}
