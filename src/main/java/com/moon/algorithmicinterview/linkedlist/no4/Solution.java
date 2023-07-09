package com.moon.algorithmicinterview.linkedlist.no4;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 86. Partition List
 * 思路，将比x小的挂在一个链表上，其他挂在另一个链表上，最后合并两个链表
 * @author Chanmoey
 * @date 2023/6/30
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = null;
        ListNode lessEnd = null;
        ListNode greater = null;
        ListNode greaterEnd = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (less == null) {
                    less = cur;
                    lessEnd = less;
                } else {
                    lessEnd.next = cur;
                    lessEnd = lessEnd.next;
                }
            } else {
                if (greater == null) {
                    greater = cur;
                    greaterEnd = greater;
                } else {
                    greaterEnd.next = cur;
                    greaterEnd = greaterEnd.next;
                }
            }
            cur = cur.next;
        }
        // 防止循环链表
        if (greaterEnd != null) {
            greaterEnd.next = null;
        }

        // 所有数都比x大，链表关系没变直接返回
        if (less == null) {
            return head;
        }
        lessEnd.next = greater;
        head = less;
        return head;
    }
}