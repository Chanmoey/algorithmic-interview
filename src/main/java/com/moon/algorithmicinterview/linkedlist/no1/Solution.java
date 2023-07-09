package com.moon.algorithmicinterview.linkedlist.no1;

/**
 * @author Chanmoey
 * @date 2023年07月09日
 */

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 206.Reverse Linked List
 * 反转链表：思路，需要记录当前节点cur的前一个节点prev，这样才能反转指针，且记录下一个节点next，这样才能遍历下去
 *
 * @author Chanmoey
 * @date 2023/6/30 11:35
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            // 保存下一个节点
            next = cur.next;
            // 反转
            cur.next = prev;
            // 反转后cur成为prev
            prev = cur;
            // 向后遍历
            cur = next;
        }
        return prev;
    }
}
