import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String> arr = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean isNum = false;
        
        int startIdx = 1;
        for(int i=1; i<s.length()-1; i++) {
            if(s.indexOf("}", i) == i) {
                arr.add(s.substring(startIdx, i+1));
                i+=2;
                startIdx = i;
            }
        }
    
        arr.sort(Comparator.comparingInt(String::length));
        
        int idx = 0;
        for(String temp : arr) {
            for(int j=0; j<temp.length(); j++) {
                char currentChar = temp.charAt(j);
                if(Character.isDigit(currentChar) && !isNum) {          // 숫자를 처음 만났을 때
                    sb.append(currentChar + "");
                    isNum = true;
                } else if(Character.isDigit(currentChar) && isNum) {    // 숫자가 2자리 이상일 때
                    sb.append(currentChar + "");
                } else {                                               // 숫자가 아닌 문자일 때
                    if(sb.length() > 0) {
                        int n = Integer.parseInt(sb.toString());
                        if(!hm.containsKey(n)) {
                            hm.put(n, idx);
                            idx++;
                        }
                    }
                    sb.setLength(0);
                    isNum = false;
                }
            }     
        }
        
        int[] answer = new int[hm.size()];
        
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) answer[entry.getValue()] = entry.getKey();
        return answer;
    }
}
