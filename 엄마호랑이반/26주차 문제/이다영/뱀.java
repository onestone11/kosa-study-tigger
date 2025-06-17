import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		
		// 사과
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			board[x][y] = 2;
		}
		
		// 방향
		int l = Integer.parseInt(br.readLine());
		Map<Integer, String> move = new HashMap<>();
		for(int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			move.put(x, c);
		}
		
		
		board[0][0] = 1;
		Deque<int[]> snake = new ArrayDeque<>();
		snake.addLast(new int[] {0, 0});
		
		int d = 0;
		int[] dx = new int[] {0, 1, 0, -1};
		int[] dy = new int[] {1, 0, -1, 0};
		
		int time = 0;
		while(true) {
			time++;
			
			int[] head = snake.peekFirst();
			int nx = head[0] + dx[d];
			int ny = head[1] + dy[d];
			
			// 게임이 끝나는 경우
			if(0 > nx || nx >= n || 0 > ny || ny >= n || board[nx][ny] == 1) break;
				
			// 이동
			snake.addFirst(new int[] {nx, ny});
			
			if(board[nx][ny] == 2) {	// 사과가 있는 경우
				board[nx][ny] = 1;
				
			} else {					// 사과가 없는 경우
				board[nx][ny] = 1;
				int[] tail = snake.removeLast();
				board[tail[0]][tail[1]] = 0;
			}
			
			// 방향 전환
			if(move.containsKey(time)) {
				String c = move.get(time);
				
				if("D".equals(c)) {		// 우회전
					d = (d + 1) % 4;
					
				} else {
					d = (d + 3) % 4;	
				}
			}
		}
		
		System.out.print(time);
	}

}
