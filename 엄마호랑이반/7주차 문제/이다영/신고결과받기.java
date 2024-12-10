import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> userId = new HashMap<>();
        List<Set<String>> reporter = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            userId.put(id_list[i], i);
            reporter.add(new HashSet<>());
        }
        
        for (String r : report) {
            String[] tmp = r.split(" ");
            String er = tmp[0]; // 신고자
            String ed = tmp[1]; // 신고당한자
            
            int idx = userId.get(ed);
            reporter.get(idx).add(er);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            if(reporter.get(i).size() >= k) {
                for (String person : reporter.get(i)) {
                    int idx = userId.get(person);
                    answer[idx] += 1;
                }
            }
        }
                
        
        return answer;
    }
}
