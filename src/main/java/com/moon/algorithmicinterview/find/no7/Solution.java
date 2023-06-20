package com.moon.algorithmicinterview.find.no7;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 * 根据字符出现的频率排序
 * 思路：用Map记录字符及其对应的频率
 *
 * @author Chanmoey
 * @date 2023年06月21日
 */
class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(2 * s.length());
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        char[] chars = new char[s.length()];
        int idx = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> peek = pq.remove();
            int freq = peek.getValue();
            while (freq > 0) {
                chars[idx++] = peek.getKey();
                freq--;
            }
        }

        return new String(chars);
    }
}
