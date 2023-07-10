package com.moon.algorithmicinterview.linkedlist.no17;

import com.moon.algorithmicinterview.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 234. Palindrome Linked List
 * 思路：使用数组
 *
 * @author Chanmoey
 * @date 2023/7/10 10:58
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!Objects.equals(list.get(i), list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
