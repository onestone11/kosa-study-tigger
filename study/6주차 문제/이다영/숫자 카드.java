package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 숫자카드

public class BJ_10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nData = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] mData = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String s : nData) {
            map.put(s, 1);
        }

        for(String s: mData) {
            if (map.containsKey(s)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}
