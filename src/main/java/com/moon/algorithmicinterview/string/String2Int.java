package com.moon.algorithmicinterview.string;

/**
 * @author Chanmoey
 * @date 2023/7/18
 */
public class String2Int {

    public int stringToInt(String str) {

        // TODO: 判断字符串符合整数格式（包括在int范围内）

        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res = res * 10 + (str.charAt(i) - '0');
        }
        return res;

        Integer.parseInt()
    }
}
