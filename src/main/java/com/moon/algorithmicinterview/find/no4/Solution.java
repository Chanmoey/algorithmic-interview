package com.moon.algorithmicinterview.find.no4;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * 使用Set记录中间结果，如果有重复的，则不算Happy Number
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int temp = 0;
            // 计算中间结果：慢慢拆解各位数
            while (n != 0) {
                int unit = n % 10;
                temp += unit * unit;
                n /= 10;
            }
            if (temp == 1) {
                return true;
            }
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
            n = temp;
        }
    }
}
