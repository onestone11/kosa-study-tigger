class Solution {
    public int solution(int storey) {
        int cnt = 0;
		
	while (storey > 0) {
		int last = storey % 10;
	
		if (last >= 6 || (last == 5 && (storey / 10) % 10 >= 5)) {
			storey += 10 - last;
			cnt += 10 - last;
			
		} else {
			storey -= last;
			cnt += last;
		}
	
		storey /= 10;
	}
	
	return cnt;
    }
}
