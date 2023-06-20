package com.moon.algorithmicinterview.array.no16;

/**
 * 依旧是错误的答案
 *
 * @author Chanmoey
 * @date 2023年06月20日
 */
public class Solution1 {

    public String minWindow(String s, String t) {
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (char c : tChar) {
            tFreq[c]++;
        }

        int begin = 0;
        // 循环不变量[l,..r)为当前寻找到的字串
        int l = 0;
        int r = 0;
        // diff表示字串还差多少可以包含全部的t
        int diff = t.length();
        int minLen = s.length() + 1;
        while (r < s.length()) {
            // 没有包含全部子数组
            char rightChar = sChar[r];
            if (diff > 0) {
                // 表示当前访问的字符在t中
                if (tFreq[rightChar] != 0) {
                    // 此时，rightChar需要加进字串中
                    if (sFreq[rightChar] < tFreq[rightChar]) {
                        diff--;
                    }
                    sFreq[rightChar]++;
                }
                r++;
            } else {
                // 此时diff == 0，表示子串中已经包含了所有的t字符了，所有需要将l前移，不断缩小字串的方位
                char leftChar = sChar[l];
                // leftChar的频率高于t串中，相应字符的频率，所以可以将left的串去掉
                if (tFreq[leftChar] > 0) {
                    if (sFreq[leftChar] > tFreq[leftChar]) {
                        sFreq[leftChar]--;
                    } else {
                        // 此时leftChar出现的频率刚好等于t中相应字符出现的频率
                        // 如果去掉，就不满足minWindow的条件了
                        if (r - l < minLen) {
                            minLen = r - l;
                            begin = l;
                        }
                        sFreq[leftChar]--;
                        diff++;
                    }
                }
                l++;
            }
        }

        if (minLen == t.length() + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}
