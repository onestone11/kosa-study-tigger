package temp_dev;

import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int maxRain = 0;
		int[][] region = new int[n][n];
		for (int i = 0; i < n; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			
			for (int j = 0; j < n; j++) {
				region[i][j] = tmp[j];
				
				maxRain = Math.max(maxRain, tmp[j]);
			} 
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		int res = 0;
		for (int r = 0; r <= maxRain + 1; r++) {
			int cnt = 0; 
			boolean[][] visited = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (region[i][j] > r && !visited[i][j]) {
						cnt++;
						visited[i][j] = true;
						dq.addLast(new int[] {i, j});
						
						while(!dq.isEmpty()) {
							int[] tmp = dq.pollFirst();
							int x = tmp[0];
							int y = tmp[1];
							
							for (int z = 0; z < 4; z++) {
								int xx = x + dx[z];
								int yy = y + dy[z];
								
								if(0 <= xx && xx < n && 0 <= yy && yy < n &&
									region[xx][yy] > r && !visited[xx][yy]) {
									visited[xx][yy] = true;
									dq.addLast(new int[] {xx, yy});
								}
							}
						}
					}
				}
			}
			
			res = Math.max(res, cnt);
		}
		
		System.out.println(res);
		
	}
}
