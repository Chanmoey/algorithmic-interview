package com.moon.algorithmicinterview.array.no16;

/**
 * 正确的答案
 *
 * @author Chanmoey
 * @date 2023年06月20日
 */
public class Solution2 {

    public String minWindow(String s, String t) {
        int[] count = new int[256];
        int[] tSet = new int[256];

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (char c : tChar) {
            tSet[c]++;
            count[c] ++;
        }

        int begin = 0;
        // 循环不变量[l,..r)为当前寻找到的字串
        int l = 0;
        int r = 0;
        // cnt表示当前字串包含t字符的个数（超过的不算）
        int cnt = 0;
        int minLen = sChar.length + 1;
        while (r < s.length()) {
            char right = sChar[r];
            // right 在t中
            if (tSet[right] != 0) {
                count[right] --;
                if (count[right] >= 0) {
                    // 当前子串中，收纳了一个有效的字符
                    cnt ++;
                }
            }
            while (cnt == t.length()) {
                char left = sChar[l];
                int newLen = r - l + 1;
                if (newLen < minLen) {
                    minLen = newLen;
                    begin = l;
                }
                if (tSet[left] > 0) {
                    count[left] ++;
                    if (count[left] > 0) {
                        // 去除了一个有效字符
                        cnt --;
                    }
                }
                l++;
            }
            r++;
        }

        if (minLen == (sChar.length + 1)) {
            return "";
        }
        return new String(sChar, begin, minLen);
    }
}
