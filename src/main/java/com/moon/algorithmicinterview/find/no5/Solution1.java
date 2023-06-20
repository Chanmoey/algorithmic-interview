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
class Solution1 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> front2Back = new HashMap<>();
        Map<String, Character> back2Front = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            // 如果pattern -> s建立了关系
            if (front2Back.containsKey(pattern.charAt(i))) {
                if (!front2Back.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
                if (!back2Front.containsKey(words[i]) || !back2Front.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }
                // 如果s -> pattern建立了关系
            } else if (back2Front.containsKey(words[i])) {
                if (!back2Front.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }
                if (!front2Back.containsKey(pattern.charAt(i)) || !front2Back.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                front2Back.put(pattern.charAt(i), words[i]);
                back2Front.put(words[i], pattern.charAt(i));
            }
        }

        return true;
    }
}
