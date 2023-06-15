package com.moon.algorithmicinterview.array.no6;

/**
 * 88. Merge Sorted Array
 *
 * @author Chanmoey
 * @date 2023年06月15日
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int len = m + n;
        int[] nums = new int[len];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[idx] = nums1[i];
                i++;
            } else {
                nums[idx] = nums2[j];
                j++;
            }
            idx++;
        }

        while (i < m) {
            nums[idx++] = nums1[i++];
        }

        while (j < n) {
            nums[idx++] = nums2[j++];
        }

        System.arraycopy(nums, 0, nums1, 0, len);
    }
}
