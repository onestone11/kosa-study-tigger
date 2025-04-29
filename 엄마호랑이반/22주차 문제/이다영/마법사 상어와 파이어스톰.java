public class Boj {
	private static int n;
	private static int q;
	private static int[][] ice;
	private static int[] dx = new int[] {0, 1, 0, -1}; 
	private static int[] dy = new int[] {1, 0, -1, 0};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		// 얼음판 초기화
		n = (int) Math.pow(2, n);
		ice = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		// 파이어스톰
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			int level = Integer.parseInt(st.nextToken());
			
			fireStorm(level);
		}
		
		// 얼음의 합 구하기
		System.out.println(getSum());
	
		// 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
		System.out.println(getSize());
	}
	
	
	public static void fireStorm(int lev) {
		int l = (int) Math.pow(2, lev);
		int[][] tmp = new int[n][n];
		
		// 부분 격자 시계방향 회전
		for(int r = 0; r < n; r += l) {
			for (int c = 0; c < n; c += l) {
				rotate(tmp, l, r, c);
			}
		}
		
		// 얼음 양 감소
		melt(tmp);
		ice = tmp;
	}

	private static void rotate(int[][] tmp, int l, int r, int c) {
		for(int x = 0; x < l; x++) {
			for (int y = 0; y < l; y++) {
				tmp[r+y][c+(l-1-x)] = ice[r+x][c+y];
			}
		}
	}
	
	private static void melt(int[][] tmp) {
		int[][] origin = new int[n][n]; 
		for (int i = 0; i < n; i++) {
			origin[i] = tmp[i].clone();
		}
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				int cnt = 0;
				
				if (origin[x][y] == 0) continue;
				
				for (int z = 0; z < 4; z++) {
					int xx = x + dx[z];
					int yy = y + dy[z];
					
					if (0 <= xx && xx < n && 0 <= yy && yy < n &&
						origin[xx][yy] > 0) {
						cnt++;
					}
				}
				
				if (cnt < 3) {
					tmp[x][y] -= 1;
				}
			}
		}
	}


	private static int getSum() {
		int cnt = 0;
		
		for(int[] row : ice) {
			for (int r : row) {
				cnt += r;
			}
		}
		
		return cnt;
	}


	private static int getSize() {
		int size = 0;
		boolean[][] visited = new boolean[n][n];
		Deque<int[]> dq = new ArrayDeque<>();
		
		for(int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int cnt = 0; 
				
				if (ice[r][c] > 0 && !visited[r][c]) {
					cnt++;
					visited[r][c] = true;
					dq.addLast(new int[] {r, c});
				}
				
				while (!dq.isEmpty()) {
					int[] now = dq.pollFirst();
					int x = now[0];
					int y = now[1];
					
					for (int z = 0; z < 4; z++) {
						int xx = x + dx[z];
						int yy = y + dy[z];
						
						if (0 <= xx && xx < n && 0 <= yy && yy < n &&
							ice[xx][yy] > 0 && !visited[xx][yy]) {
							
							cnt++;
							visited[xx][yy] = true;
							dq.addLast(new int[] {xx, yy});
						}
					}
				}
				
				size = Math.max(size, cnt);
			}
		}
		
		return size; 
	}
}
