import java.util.Scanner;

public class BJ1913_달팽이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();

		int[][] map = new int[N][N];
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int ansX = 0;
		int ansY = 0;

		int x = N / 2;
		int y = N / 2;
		int d = 0;

		for (int i = 1; i <= N * N; i++) {
			map[x][y] = i;

			int nx = x + dx[d];
			int ny = y + dy[d];

			if (map[nx][ny] > 0) {
				d--;
				if (d < 0)
					d = 3;

				nx = x + dx[d];
				ny = y + dy[d];
			}

			d++;
			if (d > 3)
				d = 0;

			x = nx;
			y = ny;

//			for (int i1 = 0; i1 < N; i1++) {
//				for (int j1 = 0; j1 < N; j1++) {
//					System.out.print(map[i1][j1] + " ");
//				}
//				System.out.println();
//			}
//
//			System.out.println("=============");
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
				if (map[i][j] == A) {
					ansX = i + 1;
					ansY = j + 1;
				}
			}
			sb.append("\n");
		}
		sb.append(ansX).append(" ").append(ansY);

		System.out.println(sb.toString());
	}

}
