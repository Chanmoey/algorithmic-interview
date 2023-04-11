package com.moon.algorithmicinterview.string;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Chanmoey
 * @date 2023年04月11日
 */
public class Number1 {

    /**
     * 桶排序
     */
    class Solution {
        public String arrangeWords(String text) {
            String[] strings = text.split(" ");
            ArrayList<String>[] buck = new ArrayList[100001];
            buck[strings[0].length()] = new ArrayList<>();
            buck[strings[0].length()].add(strings[0].toLowerCase());
            for (int i = 1; i < strings.length; i++) {
                String s = strings[i];
                if (buck[s.length()] == null) {
                    buck[s.length()] = new ArrayList<>();
                }
                buck[s.length()].add(s);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100001; i++) {
                if (buck[i] != null) {
                    while (!buck[i].isEmpty()) {
                        sb.append(buck[i].remove(0)).append(" ");
                    }
                }
            }

            sb.replace(sb.length() - 1, sb.length(), "");
            sb.replace(0, 1, String.valueOf(Character.toUpperCase(sb.charAt(0))));

            return sb.toString();
        }
    }

    /**
     * 桶排序，使用TreeMap
     */
    class Solution1 {
        public String arrangeWords(String text) {
            text = Character.toLowerCase(text.charAt(0)) + text.substring(1);
            String[] strings = text.split(" ");
            TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();
            for (String s : strings) {
                treeMap.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
            }
            StringBuilder sb = new StringBuilder();
            for (Integer len : treeMap.keySet()) {
                for (String s : treeMap.get(len)) {
                    sb.append(s).append(" ");
                }
            }

            sb.replace(sb.length() - 1, sb.length(), "");
            sb.replace(0, 1, String.valueOf(Character.toUpperCase(sb.charAt(0))));

            return sb.toString();
        }
    }
}
