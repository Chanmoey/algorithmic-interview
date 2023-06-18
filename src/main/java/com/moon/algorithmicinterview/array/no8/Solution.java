package com.moon.algorithmicinterview.array.no8;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * 在非降序数组中，找到两个元素，使得两个元素之和 = target，答案唯一
 * 思路1：暴力
 * 思路2：二分搜索，寻找 target - nums[i]
 * 思路3：对撞指针
 *
 * @author Chanmoey
 * @date 2023年06月18日
 */
class Solution {
    // 定义两个指针，l从数组左侧开始，r从数组右侧开始
    // 如果 numbers[l] + numbers[r] < target, 则l++
    // 如果 numbers[l] + numbers[r] > target, 则r--
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{};
    }
}
