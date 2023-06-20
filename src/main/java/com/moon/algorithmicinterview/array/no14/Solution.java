package com.moon.algorithmicinterview.array.no14;

/**
 * 3. Longest Substring Without Repeating Characters
 * 滑动窗口，保证窗口内的元素不重复
 * @author Chanmoey
 * @date 2023年06月20日
 */
class Solution {

    /**
     * 存储元素索引+1，即标识重复元素时，l的下一个位置，也可以用来判断是否存在重复元素
     */
    private final int[] map = new int[256];

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;
        for (; r < s.length(); r++) {
            // 清空[l-重复元素]之间的map记录
            if (map[s.charAt(r)] != 0) {
                for (; l < map[s.charAt(r)]; l++) {
                    map[s.charAt(l)] = 0;
                }
                len = r - l + 1;
            } else {
                len++;
                maxLen = Math.max(maxLen, len);
            }
            // 无论是否有重复元素，都要存储r的元素
            map[s.charAt(r)] = r + 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
