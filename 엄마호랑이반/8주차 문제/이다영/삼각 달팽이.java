import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] top = new int[n][n];
		
		int idx = 0;
		int now = 1; 
		int last = (n%2 == 0) ? (n+1)*(n/2) : (n+1)*(n/2) + (n+1)/2;
		int x = 0; int y = 0;
		int[] dx = new int[] {1, 0, -1};
		int[] dy = new int[] {0, 1, -1};
		while (now <= last) {
			top[x][y] = now;
			now++;
			
			int xx = x + dx[idx];
			int yy = y + dy[idx];
				
			if(0 <= xx && xx < n && 0 <= yy && yy < n && yy <= xx && top[xx][yy] == 0) {
				x = xx;
				y = yy;
			} else {
				idx = (idx + 1) % 3;
				x += dx[idx];
				y += dy[idx];
			}
			
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(top[i][j] > 0) {
					res.add(top[i][j]);
				}
			}
		}
		
		return res.stream()
				.mapToInt(Integer::intValue)
				.toArray();
    }
}
