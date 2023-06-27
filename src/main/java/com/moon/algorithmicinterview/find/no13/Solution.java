package com.moon.algorithmicinterview.find.no13;

import java.util.*;

/**
 * 49. Group Anagrams
 * 思路：将所有字符串排好序，做成key，然后收集到一起。
 *
 * @author Chanmoey
 * @date 2023年06月28日
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sort = sortStr(str);
            map.computeIfAbsent(sort, k -> new ArrayList<>()).add(str);
        }

        return map.values().stream().toList();
    }

    private String sortStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
