package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ7576_토마토 {

	static class Tomato {
		int x, y, day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

		@Override
		public String toString() {
			return x + " " + y + " " + day;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[N][M];
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		ArrayDeque<Tomato> queue = new ArrayDeque<>();
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new Tomato(i, j, 0));
				}
			}
		}

		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			max = Math.max(max, tomato.day);
			
//			System.out.println(tomato.toString());
			
			for (int d = 0; d < 4; d++) {
				int nx = tomato.x + dx[d];
				int ny = tomato.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				
				if(box[nx][ny] != 0)
					continue;
				
				queue.add(new Tomato(nx, ny, tomato.day + 1));
				box[nx][ny] = 1;
			}
		}

		Flag: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					max = -1;
					break Flag;
				}
			}
		}

		System.out.println(max);
	}

}
