package com.moon.algorithmicinterview.dp.no18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 * 状态定义：f(n)表示，字串从[0, n)时，是否可以由单词字典中的单词构成，单词可以重复使用。
 * 状态转移：f(n) = f(i) && dickWork.contains(s.subString(i + 1, n))
 * @author Chanmoey
 * @date 2023/8/6
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = -1; j < i && !dp[i]; j++) {
                if ((j < 0 || dp[j]) && wordSet.contains(s.substring(j+1, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
