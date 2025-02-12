import java.util.*;

class Solution {
    private static int[] timeList;
    
    public long solution(int n, int[] times) {
        long minTime = 0;
		timeList = times; 
		Arrays.sort(timeList);
		
		long s = timeList[0];
		long e = 10000L*1000000000L;
		while (s <= e) {
			long tot = (s + e) / 2;
			
			if (check(tot) >= n) {
				minTime = tot;
				e = tot - 1;
				
			} else {
				s = tot + 1;
			}
		}
		
		return minTime ;
    }
    
    public static long check(long tot) {
		long cnt = 0;
		
		for (int time : timeList) {
			cnt += tot / time;
		}
		
		return cnt;
	}
}
