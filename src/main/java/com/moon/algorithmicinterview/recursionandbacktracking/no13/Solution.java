package com.moon.algorithmicinterview.recursionandbacktracking.no13;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 *
 * @author Chanmoey
 * @date 2023/8/17
 */
class Solution {

    private static final int HOUR = 0;

    /**
     * if the num is an hour number, end with 0;
     * if the num is a minutes number, end with 1
     */
    private static final int[] nums = {
            1 << 1, 2 << 1 , 4 << 1, 8 << 1 ,
            (1 << 1) | 1, (2 << 1) | 1, (4 << 1) | 1, (8 << 1) | 1, (16 << 1) | 1, (32 << 1) | 1,
    };

    private final List<List<Integer>> numList = new ArrayList<>();
    private final List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        dfs(0, turnedOn, new ArrayList<>());
        toTimeString(numList);
        return res;
    }

    private void toTimeString(List<List<Integer>> numList) {
        for (List<Integer> list : numList) {
            int hour = 0;
            int minutes = 0;
            for (Integer num : list) {
                if ((num & 1) == HOUR) {
                    hour += (num >> 1);
                } else {
                    minutes += (num >> 1);
                }
            }
            // filter the illegal combination
            if (hour > 11 || minutes > 59) {
                continue;
            }
            String h = String.valueOf(hour);
            String m;
            if (minutes < 10) {
                m = "0" + minutes;
            } else {
                m = String.valueOf(minutes);
            }
            res.add(h + ":" + m);
        }
    }


    private void dfs(int start, int turnedOn, List<Integer> subArray) {
        if (turnedOn == subArray.size()) {
            this.numList.add(new ArrayList<>(subArray));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subArray.add(nums[i]);
            dfs(i + 1, turnedOn, subArray);
            subArray.remove(subArray.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.readBinaryWatch(1));
    }
}
