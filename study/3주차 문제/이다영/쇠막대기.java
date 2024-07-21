package main.java.org.example.codingtest;

import java.util.*;
import java.io.*;

// 쇠막대기
public class BJ_10799 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split("");

        boolean laser = false;
        int cnt = 0;
        Deque<String> piece = new ArrayDeque<>();
        for (String a : arr) {
            if (a.equals("(")){
                laser = true;
                piece.addLast("(");
            } else {
                if (laser) {
                    piece.pollLast();
                    cnt += piece.size();
                    laser = false;
                } else {
                    piece.pollLast();
                    cnt += 1;
                }
            }
        }

        System.out.print(cnt);
    }
}
