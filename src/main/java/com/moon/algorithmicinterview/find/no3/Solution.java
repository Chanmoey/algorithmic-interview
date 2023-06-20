package com.moon.algorithmicinterview.find.no3;

/**
 * 242. Valid Anagram
 * 使用Map的思想，记录每个字符对应的频数，每个字母对应的频数相同，则为Anagram
 * 由于只包含小写字母，所以不需要使用HashMap，用数组代替即可
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            tMap[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sMap[i] != tMap[i]) {
                return false;
            }
        }

        return true;
    }
}
