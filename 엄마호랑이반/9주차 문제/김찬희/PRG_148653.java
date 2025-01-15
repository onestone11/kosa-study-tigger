class Solution {
    public int solution(int storey) {
        int answer = 0;
        int i = 1;
            
        while(storey != 0) {
            int num = storey % (int) Math.pow(10, i) / (int) Math.pow(10, i-1);
            
            // 해당 자릿수가 5일 때, 다음 자릿수를 고려해야 함
            if(num == 5) {
                int next = storey % (int) Math.pow(10, i+1) / (int) Math.pow(10, i);                
                // 다음 자릿수가 5 이상일 때
                if(next >= 5) {
                    int temp = ((int) Math.pow(10, i) - num * (int) Math.pow(10, i-1));
                    storey += temp;
                    answer += (temp / Math.pow(10, i-1));
                } else {
                    storey -= Math.pow(10, i-1) * num;
                    answer += num;
                }
            } else if (num > 5) {   // 해당 자릿수가 5 초과일 때
                int temp = ((int) Math.pow(10, i) - num * (int) Math.pow(10, i-1));
                storey += temp;
                answer += (temp / Math.pow(10, i-1));
            } else {                // 해당 자릿수가 5 미만일 때
                storey -= Math.pow(10, i-1) * num;
                answer += num;
            }
            i++;
        }
        return answer;
    }
}
