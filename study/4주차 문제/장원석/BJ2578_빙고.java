import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2578_빙고 {
	static int[][] board = new int[5][5];
	static boolean[][] bingo = new boolean[5][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Loop: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int target = Integer.parseInt(st.nextToken());
				findNumber(target);
				answer++;
				
//				for (int k = 0; k < 5; k++) {
//					for (int k2 = 0; k2 < 5; k2++) {
//						if(bingo[k][k2])
//							System.out.print(1 + " ");
//						else
//							System.out.print(0 + " ");
//					}
//					System.out.println();
//				}
//				
//				System.out.println(target);
//				System.out.println("=============");

				if (checkBingo()) {
					break Loop;
				}

			}
		}
		
		System.out.println(answer);
	}

	private static void findNumber(int target) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == target) {
					bingo[i][j] = true;
					return;
				}
			}
		}
	}

	private static boolean checkBingo() {
		int cnt = 0;

		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if (!bingo[i][j]) {
					flag = false;
					break;
				}
			}

			if (flag)
				cnt++;
			if (cnt >= 3)
				return true;
		}

		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if (!bingo[j][i]) {
					flag = false;
					break;
				}
			}

			if (flag)
				cnt++;
			if (cnt >= 3)
				return true;
		}

		boolean flag1 = true;
		for (int i = 0; i < 5; i++) {
			if (!bingo[i][i]) {
				flag1 = false;
				break;
			}
		}
		if (flag1)
			cnt++;
		if (cnt >= 3)
			return true;

		boolean flag2 = true;
		for (int i = 0; i < 5; i++) {
			if (!bingo[i][4 - i]) {
				flag2 = false;
				break;
			}
		}
		if (flag2)
			cnt++;
		if (cnt >= 3)
			return true;

		return false;
	}
}
