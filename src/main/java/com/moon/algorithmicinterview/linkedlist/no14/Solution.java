package com.moon.algorithmicinterview.linkedlist.no14;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * 思路：删除A节点，就要找到A的前一个节点，所以维护一个n+1的窗口，当窗口末尾为null，那么窗口的下一个节点就是待删除的
 * dummyHead -> 1 -> 2 -> 3 -> 4 -> 5 -> null 删除倒数第2个
 * p               q
 *
 * @author Chanmoey
 * @date 2023/7/10
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        ListNode p = dummyHead;
        while (q != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;
        return dummyHead.next;
    }
}
