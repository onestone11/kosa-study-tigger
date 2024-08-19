package main.java.org.example.codingtest;

import java.util.*;

// 문자열 압축
public class Pro_60057 {
    public static void main(String[] args) {
        System.out.println(Solution("aabbaccc"));
        System.out.println(Solution("ababcdcdababcdcd"));
        System.out.println(Solution("abcabcdede"));
        System.out.println(Solution("abcabcabcabcdededededede"));
        System.out.println(Solution("xababcdcdababcdcd"));
    }

    public static int Solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length(); i++) {
            Deque<String> stack = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j + i <= s.length(); j += i) {
                String tmp = s.substring(j, j + i);

                if(!stack.isEmpty() && !stack.getLast().equals(tmp)) {
                    if(stack.size() == 1) {
                        sb.append(stack.pollLast());
                    } else {
                        sb.append(stack.size()).append(stack.pollLast());
                        stack.clear();
                    }
                }

                stack.addLast(tmp);
            }

            if(!stack.isEmpty()){
                if (stack.size() == 1) {
                    sb.append(stack.pollLast());
                } else {
                    sb.append(stack.size()).append(stack.pollLast());
                }
            }

            if (s.length() % i != 0) {
                int n = s.length() - (s.length() % i);
                sb.append(s.substring(n));
            }

            answer = Math.min(answer, sb.length());

        }
        return answer;
    }
}
