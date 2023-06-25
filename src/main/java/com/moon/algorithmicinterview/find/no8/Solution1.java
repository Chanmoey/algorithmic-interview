package com.moon.algorithmicinterview.find.no8;

import java.util.Arrays;

/**
 * 1. Two Sum
 * 规定只有一个解，不能使用相同元素
 * 思路：排序后用双指针
 * <p>
 * 错误的答案！！！因为需要返回元素的索引，排序后，索引的位置变了
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp == target) {
                return new int[]{i, j};
            } else if (temp < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}
