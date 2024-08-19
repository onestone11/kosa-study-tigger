package main.java.org.example.codingtest;

import java.util.*;

// 롤케이크 자르기

public class Pro_132265 {
    public static void main(String[] args) {
        System.out.println(Solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(Solution(new int[] {1, 2, 3, 1, 4}));
    }

    public static int Solution(int[] topping) {
        int type = 0;
        Map<Integer, Integer> older = new HashMap<>();
        for (int t : topping) {
            if (older.containsKey(t)) {
                older.put(t, older.get(t)+1);
            } else {
                older.put(t, 1);
                type++;
            }
        }

        int res = 0;
        Set<Integer> younger = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            younger.add(topping[i]);
            older.put(topping[i], older.get(topping[i])-1);

            if (older.get(topping[i]) == 0) type--;
            if (type == younger.size()) res++;
        }

        return res;
    }

}
