package com.moon.algorithmicinterview.find.no6;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> front2Back = new HashMap<>();
        Map<Character, Character> back2Front = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // s -> t建立了关系
            if (front2Back.containsKey(s.charAt(i))) {
                if (!front2Back.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
                if (!back2Front.containsKey(t.charAt(i))
                        || !back2Front.get(t.charAt(i)).equals(s.charAt(i))) {
                    return false;
                }
                // 如果s -> pattern建立了关系
            } else if (back2Front.containsKey(t.charAt(i))) {
                if (!back2Front.get(t.charAt(i)).equals(s.charAt(i))) {
                    return false;
                }
                if (!front2Back.containsKey(s.charAt(i))
                        || !front2Back.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                front2Back.put(s.charAt(i), t.charAt(i));
                back2Front.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}
