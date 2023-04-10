package com.moon.algorithmicinterview.math;

/**
 * @author Chanmoey
 * @date 2023年04月10日
 */
public class Number1 {
    /**
     * n 为偶数 1   3  5 7 9
     *         +4 +2                     求前 n / 2 项偶数的和 n * n / 4
     * n 为奇数 1   3   5   7   9   11
     *        +5  +3  +1                 求前 n / 2 项奇数的和 (n * n - 1) / 4
     */
    static class Solution {
        public int minOperations(int n) {
            return ((n * n) - (n & 1)) >> 1;
        }
    }
}
