package com.moon.algorithmicinterview.find.no15;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * 思路：每个点对0点求斜率，并记录下相同斜率的个数
 * tip：为了避免浮点误差，使用String存储斜率，比如（3，4）的斜率是4/3。
 * 因此每个点，需要求最大公约数，然后约到最简
 *
 * @author Chanmoey
 * @date 2023年06月28日
 */
public class Solution {

    public int maxPoints(int[][] points) {
        int res = points.length >= 2 ? 2 : 1;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    String slope = getSlope(points[i], points[j]);
                    if (map.containsKey(slope)) {
                        int freq = map.get(slope) + 1;
                        map.put(slope, freq);
                        res = Math.max(res, freq);
                    } else {
                        map.put(slope, 2);
                    }
                }
            }
        }
        return res;
    }

    public static String getSlope(int[] a, int[] b) {
        // 计算斜率的分子和分母
        int numerator = a[1] - b[1];
        int denominator = a[0] - b[0];
        // 垂直直线，斜率为无穷（+-无穷都一样）
        if (denominator == 0) {
            return "+";
        }

        // 使用最大公约数约简分数
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
