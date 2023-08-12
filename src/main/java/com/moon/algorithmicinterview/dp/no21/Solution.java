package com.moon.algorithmicinterview.dp.no21;

import java.util.ArrayList;
import java.util.List;

/**
 * 376. Wiggle Subsequence
 * 最长上升子序列
 *
 * @author Chanmoey
 * @date 2023/8/13
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        List<Integer> array = this.deleteDuplicateElement(nums);

        if (array.size() <= 2) {
            return array.size();
        }

        int[] diffArray = getDiffArray(array);
        int[] dp = new int[diffArray.length];
        dp[0] = 1;
        for (int i = 1; i < diffArray.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((diffArray[i] > 0 && diffArray[j] < 0) ||
                        (diffArray[i] < 0 && diffArray[j] > 0)) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }

        return dp[dp.length - 1] + 1;
    }

    private int[] getDiffArray(List<Integer> array) {
        int[] diff = new int[array.size() - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = array.get(i + 1) - array.get(i);
        }
        return diff;
    }

    private List<Integer> deleteDuplicateElement(int[] nums) {

        List<Integer> ret = new ArrayList<>();

        ret.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                ret.add(nums[i]);
            }
        }

        return ret;
    }
}
