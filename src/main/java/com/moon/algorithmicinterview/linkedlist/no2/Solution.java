package com.moon.algorithmicinterview.linkedlist.no2;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 92. Reverse Linked List II
 * 思路：[left, right]之间的节点看出是整个链表，按照链表反转的思路来写就好
 * start指针指向left的前一个节点
 * end指针指向right的后一个节点
 * [l, r]反转之后，然后通过start和end将[r, l]连接回来
 *
 * @author Chanmoey
 * @date 2023/6/30
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode start = null;
        ListNode end;
        ListNode cur = head;

        // 确定l和r的位置
        ListNode l = null;
        ListNode r;
        for (int i = 1; i <= right; i++) {
            if (i == left - 1) {
                start = cur;
            }
            if (i == left) {
                l = cur;
            }
            if (i == right) {
                r = cur;
                break;
            }
            cur = cur.next;
        }
        r = cur;
        end = cur.next;
        // 开始反转
        ListNode prev = null;
        cur = l;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        if (start != null) {
            start.next = r;
            l.next = end;
            return head;
        }
        head = r;
        l.next = end;
        return head;
    }
}
