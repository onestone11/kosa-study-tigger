import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580_스도쿠 {

	static int[][] table;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		table = new int[9][9];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		sudoku(0, 0);

	}

	private static void sudoku(int row, int col) {
		// 다음 행으
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}

		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(table[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);

			System.exit(0);
		}

		// 현재 위치가 0인 경우 (빈칸)
		if (table[row][col] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isPossible(row, col, num)) {
					table[row][col] = num;

					sudoku(row, col + 1);

					table[row][col] = 0;
				}
			}
		} else {
			sudoku(row, col + 1);
		}
	}

	private static boolean isPossible(int row, int col, int num) {
		// 행 중복 검사
		for (int i = 0; i < 9; i++) {
			if (table[row][i] == num) {
				return false;
			}
		}

		// 열 중복 검사
		for (int i = 0; i < 9; i++) {
			if (table[i][col] == num) {
				return false;
			}
		}

		// 3 X 3 중복 검사
		int nr = (row / 3) * 3;
		int nc = (col / 3) * 3;
		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if (table[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

}
