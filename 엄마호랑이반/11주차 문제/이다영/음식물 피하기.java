import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 int m = Integer.parseInt(st.nextToken());
		 int k = Integer.parseInt(st.nextToken());
		 
		 int[][] road = new int[n+1][m+1]; 
		 for (int i = 0; i < k; i++) {
			 st = new StringTokenizer(br.readLine());
			 int r = Integer.parseInt(st.nextToken());
			 int c = Integer.parseInt(st.nextToken());
			 
			 road[r][c] = 1;
		 }
		 
		 int[] dx = new int[] {-1, 0, 1, 0};
		 int[] dy = new int[] {0, 1, 0, -1};
		 Deque<int[]> dq = new ArrayDeque<>();
		 
		 int compost = 0;
		 for (int i = 1; i < n+1; i++) {
			 for (int j = 1; j < m+1; j++) {
				 if (road[i][j] == 1) {
					 road[i][j] = 0;
					 dq.addLast(new int[] {i, j});
					 
					 int tmp = 0;
					 while(!dq.isEmpty()) {
						 int[] now = dq.pollFirst();
						 int x = now[0];
						 int y = now[1];
						 tmp++;
						 
						 for (int z = 0; z < 4; z++) {
							 int xx = x + dx[z];
							 int yy = y + dy[z];
							 
							 if (0 < xx && xx <= n && 0 < yy && yy <= m &&
								 road[xx][yy] == 1) {
								 road[xx][yy] = 0;
								 dq.addLast(new int[] {xx, yy});
							 }
						 }
					 }
					 
					 compost = Math.max(compost, tmp);
				 }
			 }
		 }
		 
		 System.out.print(compost);
	}
}
