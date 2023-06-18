package com.moon.algorithmicinterview.array.no7;

/**
 * 215. Kth Largest Element in an Array
 * <p>
 * 1. 排序后直接取出
 * 2. 最大堆，取出第Kth个
 * 3. 快排思想partition
 * 假设5个元素，找出第2大的，那么就是在升序排序的数组中，找出倒数第2个，也就是5-2 nums.length - Kth
 *
 * @author Chanmoey
 * @date 2023年06月16日
 */
class Solution1 {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    // 循环不变量：[l, r]
    private int quickSort(int[] arr, int l, int r, int k) {
        int idx = arr.length - k;
        int p = partition(arr, 0, r);
        if (p == idx) {
            return arr[p];
        }

        if (p < idx) {
            return quickSort(arr, p + 1, r, k);
        } else {
            return quickSort(arr, l, p - 1, k);
        }
    }

    /**
     * [l, r]区间内进行Partition
     */
    private int partition(int[] nums, int l, int r) {
        // 标定点 nums[l] t
        // 循环不变量：[l + 1, le] <= t   [gt, nums.length - 1] > t
        int gt = r + 1;
        int t = nums[l];
        int i = l + 1;
        while (i < gt) {
            if (nums[i] > t) {
                swap(nums, i, --gt);
            } else {
                i++;
            }
        }

        // 上面的while条件，导致i == gt，越界了
        swap(nums, l, --i);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
