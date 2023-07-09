package com.moon.algorithmicinterview.linkedlist.no6;

import com.moon.algorithmicinterview.utils.ListNode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * 思路1：反转两个链表，然后按照LeetCode 2的思路进行两数相加
 * 思路2：将两个链表还原成数字，两个数字相加，然后再头插法构成结果链表，单数int或long都会溢出
 * 思路3: 使用栈，最终决定思路3
 *
 * @author Chanmoey
 * @date 2023/7/3
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1Stack.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Stack.add(l2.val);
                l2 = l2.next;
            }
        }
        ListNode dummyHead = new ListNode();
        int carry = 0;
        int v1;
        int v2;
        int tempSum;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            if (!l1Stack.isEmpty()) {
                v1 = l1Stack.pop();
            } else {
                v1 = 0;
            }
            if (!l2Stack.isEmpty()) {
                v2 = l2Stack.pop();
            } else {
                v2 = 0;
            }
            tempSum = v1 + v2 + carry;
            if (tempSum >= 10) {
                dummyHead.next = new ListNode(tempSum % 10, dummyHead.next);
                carry = tempSum / 10;
            } else {
                dummyHead.next = new ListNode(tempSum, dummyHead.next);
                carry = 0;
            }
        }
        if (carry != 0) {
            dummyHead.next = new ListNode(carry, dummyHead.next);
        }
        return dummyHead.next;
    }
}
