package com.moon.algorithmicinterview.linkedlist.no15;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 61. Rotate List
 * 选择链表，先统计链表的长度，然后将倒数k个元素移动到前面
 *
 * @author Chanmoey
 * @date 2023/7/10 10:22
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null) {
            return head;
        }

        int size = size(head);
        k = k % size;

        if (k == 0) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; i < size - k; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode end= cur;
        while (end.next != null) {
            end = end.next;
        }
        end.next = head;
        head = cur;
        prev.next = null;
        return head;
    }

    private int size(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}
