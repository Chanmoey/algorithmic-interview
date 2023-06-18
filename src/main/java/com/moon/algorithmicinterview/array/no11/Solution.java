package com.moon.algorithmicinterview.array.no11;

/**
 * 345. Reverse Vowels of a String
 * 反转元音字母
 *
 * @author Chanmoey
 * @date 2023年06月19日
 */
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (!isVowel(chars[l]) && l < r) {
                l++;
            }
            while (!isVowel(chars[r]) && l < r) {
                r--;
            }
            if (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
