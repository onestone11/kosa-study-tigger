package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018_체스판다시칠하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] chessBoard = new char[8][8];
		char[][] bigBoard = new char[N][M];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					chessBoard[i][j] = 'W';
				} else {
					chessBoard[i][j] = 'B';
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(chessBoard[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				bigBoard[i][j] = c;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt1 = 0, cnt2 = 0;

				for (int p = 0; p < 8; p++) {
					for (int q = 0; q < 8; q++) {
						if (chessBoard[p][q] == bigBoard[p + i][q + j]) {
							cnt1++;
						} else {
							cnt2++;
						}
					}
				}

				min = Math.min(min, Math.min(cnt1, cnt2));
			}
		}

		System.out.println(min);
	}

}
