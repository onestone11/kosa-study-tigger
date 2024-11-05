package org.example.codingtest;

import static java.lang.Integer.*;

import java.util.*;

// 튜플
public class Programmers_64065 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(Solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(Solution("{{20,111},{111}}")));
    }

    public static int[] Solution(String s) {
        String str = s.substring(1, s.length() - 1)
            .replace("},{", "/").replace("{", "").replace("}", "");

        String[] set = str.split("/");
        Arrays.sort(set, Comparator.comparingInt(String::length));

        int[] tuple = new int[set.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tuple.length; i++) {
            String[] tmp = set[i].split(",");

            for (String t : tmp) {
                int key = Integer.parseInt(t);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                    tuple[i] = key;
                }
            }
        }

        return tuple;
    }
}
