package com.moon.algorithmicinterview.linkedlist.no7;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 203. Remove Linked List Elements
 * 思路：dummyHead统一删除逻辑
 *
 * @author Chanmoey
 * @date 2023/7/3
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        // 待删除元素的前一个元素
        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                // prev不移动，为了删除重复的元素
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}
