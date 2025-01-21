import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Map<String, Integer> subject = new HashMap<>();
        Stack<String> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<plans.length; i++) subject.put(plans[i][0], Integer.parseInt(plans[i][2]));
        
        // 시작 시간 오름차순으로 정렬
        for(int j=0; j<plans.length-1; j++) {
            for(int k=j+1; k<plans.length; k++) {
                String[] time1 = plans[j][1].split(":");
                String[] time2 = plans[k][1].split(":");
                
                if(Integer.parseInt(time1[0]) > Integer.parseInt(time2[0])) {
                    String[] temp = plans[k];
                    plans[k] = plans[j];
                    plans[j] = temp;
                } else if(Integer.parseInt(time1[0]) == Integer.parseInt(time2[0])) {
                    if(Integer.parseInt(time1[1]) > Integer.parseInt(time2[1])) {
                        String[] temp = plans[k];
                        plans[k] = plans[j];
                        plans[j] = temp;
                    }
                }
            }
        }
        
        for(int idx=0; idx<plans.length-1; idx++) {
            String sub = plans[idx][0];
            String[] currTime = plans[idx][1].split(":");
            String[] nextTime = plans[idx+1][1].split(":");
            
            int ct = Integer.parseInt(currTime[0]) * 60 + Integer.parseInt(currTime[1]);
            int nt = Integer.parseInt(nextTime[0]) * 60 + Integer.parseInt(nextTime[1]);
            
            int can = nt - ct;
            int haveTo = subject.get(sub);
            
            while(can > 0) {
                // 시간 안에 과제를 다 못할 경우
                if(can - haveTo < 0) {
                    stack.push(sub);
                    subject.replace(sub, haveTo - can);
                    can -= haveTo;
                } else if(can - haveTo > 0) {
                    // 과제를 다 하고도 시간이 남음
                    can -= haveTo;
                    subject.replace(sub, 0);
                    answer.add(sub);
                    
                    if(!stack.isEmpty()) {
                        sub = stack.pop();
                        haveTo = subject.get(sub);
                    } else can = 0;
                } else {
                    answer.add(sub);
                    subject.replace(sub, 0);
                    can = 0;
                }
            }
        }
        
        // plans의 마지막 과목 처리해줘야 함.
        answer.add(plans[plans.length-1][0]);
        subject.remove(plans[plans.length-1][0]);
            
        while(!stack.isEmpty()) answer.add(stack.pop());
        
        return answer.stream().toArray(String[]::new);
    }
}
