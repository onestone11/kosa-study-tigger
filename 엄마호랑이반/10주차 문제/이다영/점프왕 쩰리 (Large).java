package temp_dev;

import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] jump = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				jump[i][j] = Integer.parseInt(st.nextToken());
			}
		}W
		
		int[] dx = new int[] {1, 0};
		int[] dy = new int[] {0, 1};
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[] {0, 0});
		visited[0][0] = true;
		
		String res = "Hing";
		while (!dq.isEmpty()) {
			int[] tmp = dq.pollFirst();
			int x = tmp[0];
			int y = tmp[1];
			
			if (jump[x][y] <= 0) {
				if (jump[x][y] == -1) res = "HaruHaru";
				break;
			}
			
			for (int z = 0; z < 2; z++) {
				int xx = x + (dx[z] * jump[x][y]);
				int yy = y + (dy[z] * jump[x][y]);
				
				if(0 <= xx && xx < n && 0 <= yy && yy < n && !visited[xx][yy]) {
					visited[xx][yy] = true;
					dq.addLast(new int[] {xx, yy});
				}
			}
		}
		
		System.out.print(res);
	}
	
}
