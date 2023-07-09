package com.moon.algorithmicinterview.linkedlist.no13;

import com.moon.algorithmicinterview.utils.ListNode;

/**
 * 237. Delete Node in a Linked List
 * 删除指定的node节点
 * 思路：直接将node下一个节点的值，覆盖掉node的值，那么，就相当于删除了node
 * 然后，维护链表就可以了
 * @author Chanmoey
 * @date 2023/7/10
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        // 待删除的节点为最后一个节点
        if (node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
