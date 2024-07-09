package fin;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        char[] str1Arr = str1.toUpperCase().toCharArray();
        char[] str2Arr = str2.toUpperCase().toCharArray();

        Deque<String> dq1 = makeDq(str1Arr);
        Deque<String> dq2 = makeDq(str2Arr);

        if (dq1.size() == 0 && dq2.size() == 0) return 65536;
        
        int inter = 0;
        int range = dq1.size();
        for (int i = 0; i < range; i++) {
            String s1 = dq1.removeFirst();

            if (dq2.contains(s1)) {
                dq2.remove(s1);
                inter += 1;
            } else {
                dq1.add(s1);
            }

            if (dq2.size() == 0) break;
        }

        double jacquard =  (double) inter / (dq1.size() + inter + dq2.size());
        jacquard *= 65536;
        
        return (int) jacquard;
    }
    
    public static Deque<String> makeDq(char[] strArr) {
        Deque<String> dq = new ArrayDeque<>();

        for (int i = 0; i < strArr.length-1; i++) {
            char first = strArr[i];
            char second = strArr[i+1];

            if (checkStr(first, second)) {
                String tmp = "" + first + second;
                dq.add(tmp);
            }
        }

        return dq;
    }
    
    public static boolean checkStr(char first, char second){
        int f = first;
        int s = second;
        
        if (f < 65 || f > 90) return false;
        if (s < 65 || s > 90) return false;

        return true;
    }
}