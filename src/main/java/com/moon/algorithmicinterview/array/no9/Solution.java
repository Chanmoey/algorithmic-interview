package com.moon.algorithmicinterview.array.no9;

/**
 * 125. Valid Palindrome
 *
 * @author Chanmoey
 * @date 2023年06月19日
 */
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = new char[s.length()];
        int length = getAllLowercaseLettersAndDigit(s, chars);

        int l = 0;
        int r = length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * @param s
     * @return 字符数组长度
     */
    public int getAllLowercaseLettersAndDigit(String s, char[] chars) {
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                chars[idx++] = c;
            } else if (Character.isLetter(c)) {
                chars[idx++] = Character.toLowerCase(c);
            }
        }
        return idx;
    }
}
