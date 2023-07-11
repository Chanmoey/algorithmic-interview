package com.moon.algorithmicinterview.stack.no2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 * 思路：栈
 * @author Chanmoey
 * @date 2023/7/11 11:58
 */
class Solution {

    Deque<Integer> stack = new ArrayDeque<>();

    public int evalRPN(String[] tokens) {
        for (String s : tokens) {
            if (isDigit(s)) {
                stack.addLast(Integer.parseInt(s));
            } else {
                operate(s);
            }
        }

        return stack.removeLast();
    }

    private boolean isDigit(String str) {
        return !"+".equals(str) && !"-".equals(str) && !"*".equals(str) && !"/".equals(str);
    }

    private void operate(String op) {
        // stack.size() must >= 2
        // [1, 2]
        Integer op1 = stack.removeLast();
        Integer op2 = stack.removeLast();
        switch (op) {
            case "+" -> stack.addLast(op2 + op1);
            case "-" -> stack.addLast(op2 - op1);
            case "*" -> stack.addLast(op2 * op1);
            case "/" -> stack.addLast(op2 / op1);
            default -> throw new IllegalArgumentException("?????? What are you doing?");
        }
    }
}
