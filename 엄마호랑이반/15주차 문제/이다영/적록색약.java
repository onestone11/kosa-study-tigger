import java.util.*;
import java.io.*;

public class Main {
	private static int[][] pic;
	private static int[][] area;
	private static int[] dx = new int[] {0, 1, 0, -1};
	private static int[] dy = new int[] {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		pic = new int[n][n];
		for(int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			
			for (int j = 0; j < n; j++) {
				switch(tmp[j]) {
					case "R" : pic[i][j] = 1; break;
					case "G" : pic[i][j] = -1; break;
					case "B" : pic[i][j] = 2; break;
				}
			}
		}
		
		System.out.print(findRGB(n, true) + " " + findRGB(n, false));
	}
	
	public static int findRGB(int n, boolean can) {
		area = new int[n][n];
		Deque<int[]> dq = new ArrayDeque<>();
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(area[i][j] == 0) {
					cnt++;
					area[i][j] = cnt;
					dq.addLast(new int[] {i, j});
					
					while(!dq.isEmpty()) {
						int[] now = dq.pollFirst();
						int x = now[0];
						int y = now[1];
						
						for (int k = 0; k < 4; k++) {
							int xx = x + dx[k];
							int yy = y + dy[k];
							
							if (0 <= xx && xx < n && 0 <= yy && yy < n &&
								area[xx][yy] == 0) {
								
								if (can ? pic[x][y] == pic[xx][yy] : Math.abs(pic[x][y]) == Math.abs(pic[xx][yy])) {
									area[xx][yy] = cnt;
									dq.addLast(new int[] {xx, yy});
								}
							}
						}
					}
				}
			}
		}
		return cnt;
	}
}
