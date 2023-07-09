package com.moon.algorithmicinterview.linkedlist.no12;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 148. Sort List
 * 总体思路：归并排序
 * 1. 使用快慢指针，将链表一分为二
 *
 * @author Chanmoey
 * @date 2023/7/10
 */
class Solution {
    public ListNode sortList(ListNode head) {

        // 一个节点，不需要排序（递归终止条件）
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            // 速度为1
            slow = slow.next;
            // 速度为2
            fast = fast.next.next;
        }

        // slow.next为第二个链表
        ListNode head2 = slow.next;
        // 断开两个链表
        slow.next = null;
        head = this.sortList(head);
        head2 = this.sortList(head2);
        // 返回两个链表归并后的头节点
        return merge(head, head2);
    }

    // merge的逻辑，可以看no8
    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (p != null || q != null) {
            if (p == null) {
                tail.next = q;
                break;
            } else if (q == null) {
                tail.next = p;
                break;
            } else {
                if (p.val < q.val) {
                    tail.next = p;
                    p = p.next;
                } else {
                    tail.next = q;
                    q = q.next;
                }
            }
            tail = tail.next;
        }

        ListNode head = dummyHead.next;
        // Help GC
        dummyHead.next = null;
        return head;
    }
}
