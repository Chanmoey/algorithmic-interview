package com.moon.algorithmicinterview.array.no13;

/**
 * 209. Minimum Size Subarray Sum
 *
 * @author Chanmoey
 * @date 2023年06月19日
 */
class Solution {
    /**
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int r = -1; // 开始时，窗口无元素
        int res = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < target) {
                r++;
                sum += nums[r];
            } else {
                if (sum >= target) {
                    res = Math.min(res, r - l + 1);
                    sum -= nums[l];
                    l++;
                } else {
                    break;
                }
            }
        }


        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
    }
}
