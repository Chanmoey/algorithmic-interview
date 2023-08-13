package com.moon.algorithmicinterview.recursionandbacktracking.no2;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * @author Chanmoey
 * @date 2023/8/14
 */
class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(s, 0, "", 0);
        return res;
    }

    /**
     * 递归算法
     * @param s ip字符串
     * @param idx 从idx开始切割一个点分十进制的部分
     * @param prefix 已经找到的点分十进制（如0.0., 0.0.0.）
     * @param count 已经找到的淀粉十进制部分的个数
     */
    private void dfs(String s, int idx, String prefix, int count) {
        System.out.println(prefix);
        // 已经找到了3个，只剩最后一个
        if (count == 3) {
            if (idx >= s.length() || s.length() - idx > 3) {
                return;
            }
            String remaining = s.substring(idx);
            if (isValidIpSplit(remaining)) {
                res.add(prefix + remaining);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (idx + i <= s.length()) {
                String item = s.substring(idx, idx + i);
                if (isValidIpSplit(item)) {
                    dfs(s, idx + i, prefix + item + ".", count + 1);
                }
            }
        }
    }

    /**
     * s长度必须大于0
     * @param s s
     * @return 是否符合点分十进制的ip格式
     */
    private boolean isValidIpSplit(String s) {
        if (s.startsWith("0")) {
            return s.length() == 1;
        }

        if (s.length() > 3) {
            return false;
        }

        int num = 0;
        for (int i = 0; i < s.length() ; i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }

        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.restoreIpAddresses("25525511135");
    }
}
