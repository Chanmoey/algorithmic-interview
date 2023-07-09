package com.moon.algorithmicinterview.linkedlist.no3;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * 思路，point指针固定，cur向前移动，如果point.val != cur.val，则建立关系
 *
 * @author Chanmoey
 * @date 2023/6/30
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode point = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (point.val != cur.val) {
                point.next = cur;
                point = cur;
            }
            cur = cur.next;
        }
        point.next = null;
        return head;
    }
}