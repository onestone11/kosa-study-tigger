package main.java.org.example.others;

import java.util.*;

// 같은 숫자는 싫어
public class Pro_12906 {
    public static void main(String[] args) {
        Solution(new int[] {1,1,3,3,0,1,1});
    }

    public static int[] Solution(int[] arr) {
        Stack<Integer> chk = new Stack<>();
        for (int a : arr) {
            if (chk.empty()) {
                chk.push(a);
            } else {
                if (chk.peek() != a) {
                    chk.push(a);
                }
            }
        }

        int[] answer = new int[chk.size()];
        for (int i = 0; i < chk.size(); i++) {
            answer[i] = chk.get(i);
        }

        return answer;
    }
}
