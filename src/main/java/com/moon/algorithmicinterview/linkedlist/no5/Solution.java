package com.moon.algorithmicinterview.linkedlist.no5;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 328. Odd Even Linked List
 * 思路 oddHead收集奇数idx的元素，evenHead收集偶数idx的元素
 *
 * @author Chanmoey
 * @date 2023/7/3
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = head;
        ListNode oddTail = oddHead;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        if (evenHead == null) {
            return oddHead;
        }
        boolean isOdd = true;
        ListNode cur = head.next.next;
        while (cur != null) {
            if (isOdd) {
                oddTail.next = cur;
                oddTail = oddTail.next;
            } else {
                evenTail.next = cur;
                evenTail = evenTail.next;
            }
            isOdd = !isOdd;
            cur = cur.next;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }
}