import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static int[][] ocean;
	private static int[] dx = new int[] {0, 1, 0, -1};
	private static int[] dy = new int[] {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ocean = new int[n][n];
		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ocean[i][j] = Integer.parseInt(st.nextToken());
				
				if (ocean[i][j] == 9) {
					x = i; y = j;
					ocean[i][j] = 0;
				}
			}
		}
		
		int time = 0;
		int size = 2; 
		int ate = 0;
		while (true) {
			int[] fish = findFish(x, y, size);
			
			if (fish == null) break;
			
			ocean[fish[0]][fish[1]] = 0;
			ate++;
			time += fish[2];
					
			x = fish[0];
			y = fish[1];
			
			if(ate == size) {
				size++;
				ate = 0;
			}
		}
		
		System.out.println(time);
	}
	
	public static int[] findFish(int x, int y, int size) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		dq.addLast(new int[] {x, y, 0});
		visited[x][y] = true;
		
		List<int[]> fish = new ArrayList<>();
		int dis = Integer.MAX_VALUE;
		
		while(!dq.isEmpty()) {
			int[] now = dq.pollFirst();
			int nx = now[0], ny = now[1], nd = now[2];
			
			if (0 < ocean[nx][ny] && ocean[nx][ny] < size) {
				if (nd <= dis) {
					if (nd < dis) {
						dis = nd;
						fish.clear();
					}
					
					fish.add(new int[] {nx, ny, nd});
				}
			}
			
			for (int z = 0; z < 4; z++) {
				int xx = nx + dx[z];
				int yy = ny + dy[z];
				
				if (0 <= xx && xx < n && 0 <= yy && yy < n &&
					!visited[xx][yy] && ocean[xx][yy] <= size) {
					
					visited[xx][yy] = true;
					dq.add(new int[] {xx, yy, nd+1});
				}
			}
		}
		
		if (fish.size() > 0) {
			Collections.sort(fish, (o1, o2) -> {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			});
			
			return fish.get(0);
		}
		return null;
	}
}
