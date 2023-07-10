package com.moon.algorithmicinterview.linkedlist.no16;

import com.moon.algorithmicinterview.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 143. Reorder List
 * 思路：使用Deque，一前一后pop出来
 *
 * @author Chanmoey
 * @date 2023/7/10 10:51
 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addLast(head);
            head = head.next;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!deque.isEmpty()) {
            tail.next = deque.removeFirst();
            tail = tail.next;
            if (!deque.isEmpty()) {
                tail.next = deque.removeLast();
                tail = tail.next;
            }
        }
        tail.next = null;
        head = dummyHead.next;
    }
}
