package com.moon.algorithmicinterview.dp.no1;

/**
 * 70. Climbing Stairs
 * 误区：为什么不是f(n) = f(n-1) + f(n-2) + 2
 * 想爬上n阶楼梯，必须先爬上n-1阶楼梯或者n-2阶楼梯，那么从n-1到n阶楼梯的方式只有一种，所以0爬到n阶楼梯的方式和从0爬到n-1的走法是一样的。
 * n-2阶楼梯也同理
 * 做法：使用记忆化搜索
 *
 * @author Chanmoey
 * @date 2023/7/14
 */
public class Solution {

    private int[] memo;

    public int climbStairs(int n) {
        this.memo = new int[n + 1];
        return recursion(n);
    }

    private int recursion(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (this.memo[n] != 0) {
            return this.memo[n];
        }

        this.memo[n] = recursion(n - 1) + recursion(n-2);
        return this.memo[n];
    }
}
