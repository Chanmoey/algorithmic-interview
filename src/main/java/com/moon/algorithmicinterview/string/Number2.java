package com.moon.algorithmicinterview.string;

/**
 * @author Chanmoey
 * @date 2023年04月19日
 */
public class Number2 {

    /**
     * 只考虑字母与数字，忽略大小写
     */
    class Solution {
        public boolean isPalindrome(String s) {
            // 1. 保留字母与数字
            s = getAlphabeticAndDigit(s);
            // 双指针，首尾判断是否相等
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        private String getAlphabeticAndDigit(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    sb.append(Character.toLowerCase(c));
                } else if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    /**
     * 性能更高的版本
     */
    class Solution1 {
        public boolean isPalindrome(String s) {
            int sLength = s.length();
            char[] stringList = new char[sLength];

            String upperString = s.toUpperCase();
            char[] c = upperString.toCharArray();

            int length = 0;
            for (int i = 0; i < sLength; i++) {
                if (isUpperAlphabetAndNumber(c[i])) {
                    stringList[length++] = c[i];
                }
            }

            if (length == 0) {
                return true;
            }

            int i = 0;
            int j = length - 1;
            while (i <= j) {
                if (stringList[i] != stringList[j]) {
                    return false;
                }
                i++;
                j--;

            }
            return true;
        }

        private boolean isUpperAlphabetAndNumber(char c) {
            return (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0');
        }
    }
}
