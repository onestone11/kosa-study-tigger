import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works) {
			heap.add(w);
		}
		
		for (int i = n; i > 0; i--) {
			int tmp = heap.poll();
			tmp -= 1; 
			heap.add(tmp);
		}
		
		long answer = 0;
		for (int h : heap) {
			if (h < 0) continue;
			
			answer += Math.pow(h, 2);
		}
        return answer;
    }
}
