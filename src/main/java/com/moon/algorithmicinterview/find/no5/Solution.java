package com.moon.algorithmicinterview.find.no5;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * 使用Map，将pattern与s之间建立关系
 * 错误的答案
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        // 只记录了pattern -> s之间的关系
        // "abba" -> "dog dog dog dog" 这样就有问题
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), words[i]);
            }
        }

        return true;
    }
}
