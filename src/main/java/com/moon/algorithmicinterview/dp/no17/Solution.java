package com.moon.algorithmicinterview.dp.no17;

/**
 * 474. Ones and Zeroes
 * <p>
 * 状态定义f(m, n)表示，当存在m个0，n个1时，最大能装入多少个子元素
 * 状态转移：遍历每一个字符串，每一个字符串的状态转移为：f(m, n) = max{f(m, n), f(m - 0的个数，n - 1的个数)}
 * 思路：使用动态规划算法
 *
 * @author Chanmoey
 * @date 2023/8/3
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // 从strs开始遍历，保证str只能使用一次
        for (String str : strs) {
            int[] zeroAndOne = getZeroAndOne(str);
            int zeroNum = zeroAndOne[0];
            int oneNum = zeroAndOne[1];
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getZeroAndOne(String str) {
        int[] freq = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                freq[0]++;
            } else {
                freq[1]++;
            }
        }

        return freq;
    }
}