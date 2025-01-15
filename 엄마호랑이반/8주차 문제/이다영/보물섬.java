package temp_dev;

import java.util.*;
import java.io.*;

public class TestClass {
	
	public static int a;
	public static int b;
	public static String[][] island;
	public static int result = 0; 
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 String[] ab = br.readLine().split(" ");
		 a = Integer.parseInt(ab[0]);
		 b = Integer.parseInt(ab[1]);
		 island = new String[a][b];
		 
		 for (int i = 0; i < a; i++) {
			 island[i] = br.readLine().split("");
		 }
		 
		 for (int x = 0; x < a; x++) {
			 for (int y = 0; y < b; y++) {
				 if(!"W".equals(island[x][y])) {
					 bfs(x, y);
				 }
			 }
		 }
		 
		 System.out.println(result);
	}
	
	public static void bfs(int sx, int sy) {
		int[] dx = new int[] {0, 1, 0, -1};
		int[] dy = new int[] {-1, 0, 1, 0};
		int[][] dis = new int[a][b];
		for(int i = 0; i < a; i++) {
			Arrays.fill(dis[i], -1);
		}
		dis[sx][sy] = 0;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[]{sx, sy});
		
		int cnt = 0;
		while (!dq.isEmpty()) {
			int[] tmp = dq.pollFirst();
			int x = tmp[0]; 
			int y = tmp[1];
			
			for (int z = 0; z < 4; z++) {
				int xx = x + dx[z];
				int yy = y + dy[z];
				
				if ( 0 <= xx && xx < a && 0 <= yy && yy < b && 
					"L".equals(island[xx][yy]) && 
					dis[xx][yy] == -1) {
					
					dis[xx][yy] = dis[x][y] + 1; 
					dq.addLast(new int[] {xx, yy});
					cnt = dis[xx][yy];
				}
			}
			
			result = Math.max(cnt , result);
		}
	}
}
