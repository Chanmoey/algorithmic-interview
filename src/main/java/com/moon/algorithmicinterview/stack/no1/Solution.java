package com.moon.algorithmicinterview.stack.no1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 * 思路：看代码
 * @author Chanmoey
 * @date 2023/7/12
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isLeft(c)) {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.getLast() != match(c)) {
                    return false;
                } else {
                    stack.removeLast();
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private char match(char c) {
        return switch (c) {
            case ')' -> '(';
            case '}' -> '{';
            case ']' -> '[';
            default -> throw new IllegalArgumentException("IllegalArgument");
        };
    }
}
