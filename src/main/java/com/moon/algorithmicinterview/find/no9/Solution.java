package com.moon.algorithmicinterview.find.no9;

import java.util.*;

/**
 * 15. 3Sum
 * 思路： 第一层循环for-i，然后内层循环套用2Sum的思路
 * 难点：可以使用重复的元素，但是，最终结果又不能一样
 * 难点解决思路：记录数组重复个数，并在去重后的数组中，进行2Sum
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {
    // key: element of nums, value: freq of element
    // TreeMap保证keySet是有序的
    Map<Integer, Integer> counter = new TreeMap<>();

    public List<List<Integer>> threeSum(int[] nums) {

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        Object[] keySet = counter.keySet().toArray();
        Integer[] array = new Integer[keySet.length];
        for (int i = 0; i < keySet.length; i++) {
            array[i] = (Integer) keySet[i];
        }
        if (counter.containsKey(0) && counter.get(0) >= 3) {
            res.add(List.of(0, 0, 0));
        }
        System.out.println(Arrays.toString(array));
        // for i固定第一个元素
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] * 2 + array[j] == 0 && counter.get(array[i]) >= 2) {
                    res.add(List.of(array[i], array[i], array[j]));
                }

                if (array[j] * 2 + array[i] == 0 && counter.get(array[j]) >= 2) {
                    res.add(List.of(array[i], array[j], array[j]));
                }

                int temp = -array[i] - array[j];
                if (temp > array[j] && counter.containsKey(temp)) {
                    res.add(List.of(array[i], array[j], temp));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
