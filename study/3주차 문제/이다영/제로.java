package main.java.org.example.codingtest;

import java.util.*;

// 제로
public class BJ_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> num = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                num.pollLast();
            } else {
                num.addLast(x);
            }
        }

        int total = 0;
        for (int x : num) {
            total += x;
        }

        System.out.println(total);
    }
}
