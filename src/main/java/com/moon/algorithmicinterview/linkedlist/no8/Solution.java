package com.moon.algorithmicinterview.linkedlist.no8;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 21. Merge Two Sorted Lists
 *
 * @author Chanmoey
 * @date 2023/7/3
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
            }
            tail = tail.next;
        }
        tail.next = null;
        return dummyHead.next;
    }
}
