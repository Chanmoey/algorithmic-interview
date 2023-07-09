package com.moon.algorithmicinterview.linkedlist.no10;

import com.moon.algorithmicinterview.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 25. Reverse Nodes in k-Group
 * 思路：使用Deque
 *
 * @author Chanmoey
 * @date 2023/7/10
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> deque = new ArrayDeque<>(k);
        ListNode dummyHead = new ListNode(0, head);
        ListNode tempHead = dummyHead;
        ListNode next = dummyHead.next;
        while (next != null) {
            deque.addLast(next);
            next = next.next;
            if (deque.size() == k) {
                while (!deque.isEmpty()) {
                    tempHead.next = deque.removeLast();
                    tempHead = tempHead.next;
                }
            }
        }

        while (!deque.isEmpty()) {
            tempHead.next = deque.removeFirst();
            tempHead = tempHead.next;
        }
        tempHead.next = null;
        return dummyHead.next;
    }
}