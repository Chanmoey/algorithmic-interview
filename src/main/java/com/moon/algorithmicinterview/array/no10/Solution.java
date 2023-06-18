package com.moon.algorithmicinterview.array.no10;

/**
 * 344. Reverse String
 *
 * @author Chanmoey
 * @date 2023年06月19日
 */
class Solution {
    /**
     * 反转字符串，使用对撞指针
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
