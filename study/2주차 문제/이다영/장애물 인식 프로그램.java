package fin;

import java.io.*;
import java.util.*;

// 장애물 인식 프로그램
public class Softeer_6282 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < n; j ++) {
				map[i][j] = line.charAt(j) - '0';	// '0' 문자를 빼서 정수로 변환
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		List<Integer> ans = new ArrayList<>();
		Deque<Integer[]> dq = new ArrayDeque<>();
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				
				if (map[x][y] == 1 && visited[x][y] == false) {
					int cnt = 1; 
					dq.addLast(new Integer[] {x, y});
					visited[x][y] = true;
					
					while (!dq.isEmpty()) {
						Integer[] tmp = dq.removeFirst();
						int nowX = tmp[0];
						int nowY = tmp[1];
						
						for (int z = 0; z < 4; z++) {
							int nextX = nowX + dx[z];
							int nextY = nowY + dy[z];
							
							if (0 <= nextX && nextX < n &&
								0 <= nextY && nextY < n &&
								map[nextX][nextY] == 1 &&
								visited[nextX][nextY] == false) {
								cnt++;
								visited[nextX][nextY] = true;
								dq.addLast(new Integer[] {nextX, nextY});
							}
						}
					}
					ans.add(cnt);
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int a : ans) {
			System.out.println(a);
		}
	}
}
