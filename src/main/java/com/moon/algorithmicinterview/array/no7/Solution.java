package com.moon.algorithmicinterview.array.no7;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * <p>
 * 1. 排序后直接取出
 * 2. 最大堆，取出第Kth个
 * 3. 快排思想partition
 *
 * @author Chanmoey
 * @date 2023年06月16日
 */
class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }

        int ret = -1;
        for (int i = 0; i < k; i++) {
            ret = pq.remove();
        }

        return ret;
    }
}
