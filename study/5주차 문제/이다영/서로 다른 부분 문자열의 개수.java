package main.java.org.example.codingtest;

import java.io.*;
import java.util.*;

// 서로 다른 부분 문자열의 개수
public class BJ_11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");

        Set<String> str = new HashSet<>();
        int len = s.length;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder(s[i]);
            str.add(sb.toString());

            for (int j = i+1; j < len; j++) {
                sb.append(s[j]);
                str.add(sb.toString());
            }
        }

        System.out.println(str.size());
    }
}
