package com.moon.algorithmicinterview.math;

import java.util.Map;

/**
 * 求最大公约数：欧几里得算法
 * 两个数x，y的最大公约数是指同时整除x和y的最大因子，记为gcd(x, y)。当gcd(x, y) == 1，则x和y互素
 * <p>
 * 欧几里得算法的时间复杂度O(log(max(x, y)))
 *
 * @author Chanmoey
 * @date 2023年04月12日
 */
public class Gcd {

    public static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        return gcd0(max, min);
    }

    public static int gcd0(int max, int min) {
        if (min == 0) {
            return max;
        }
        return gcd0(min, (max % min));
    }

    public static void main(String[] args) {
        System.out.println(gcd(319, 377));
    }
}
