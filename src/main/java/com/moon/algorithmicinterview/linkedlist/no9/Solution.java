package com.moon.algorithmicinterview.linkedlist.no9;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * 思路：记录待反转的两个节点，然后反转这两个节点，但为了维护链表，额外记录这两个节点的前一个节点prev和后一个节点next
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            // 记录节点关系
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            ListNode next = node2.next;

            // 反转节点
            node2.next = node1;
            node1.next = next;
            prev.next = node2;

            // prev移动，继续下两个节点
            prev = node1;
        }
        head = dummyHead.next;
        // Help GC
        dummyHead.next = null;

        return head;
    }
}
