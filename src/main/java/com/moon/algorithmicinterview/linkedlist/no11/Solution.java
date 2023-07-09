package com.moon.algorithmicinterview.linkedlist.no11;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 147. Insertion Sort List
 * 链表的插入排序：数组可以从后往前查看，但是链表只能从前往后遍历了
 *
 * @author Chanmoey
 * @date 2023/7/10
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            ListNode point = dummyHead;
            boolean isInsert = false;
            while (point.next != cur) {
                if (point.next.val > cur.val) {
                    // 插入到正确位置
                    cur.next = point.next;
                    point.next = cur;
                    // 维护链表
                    prev.next = next;
                    cur = prev.next;
                    isInsert = true;
                    break;
                } else {
                    point = point.next;
                }
            }
            if (!isInsert) {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }
}
