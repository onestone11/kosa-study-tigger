import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1303_전쟁_전투 {
	static int N, M, cnt = 0, wPower = 0, bPower = 0;
	static char[][] warMap;
	static boolean[][] visited;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		warMap = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String strInput = br.readLine();
			for (int j = 0; j < M; j++) {
				warMap[i][j] = strInput.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					dfs(i, j, warMap[i][j]);
					
					if(warMap[i][j] == 'W') {
						wPower += ( cnt * cnt );
					} else {
						bPower += ( cnt * cnt );
					}
					
					cnt = 0;
				}
			}
		}
		
		System.out.println(wPower + " " + bPower);
	}
	
	public static void dfs(int x, int y, char target) {
		visited[x][y] = true;
		cnt++;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			
			if(visited[nx][ny] || warMap[nx][ny] != target)
				continue;
			
			dfs(nx, ny, target);
		}
	}

}
