import java.util.Scanner;

public class BJ9663_NQueen {

	static int N, count = 0;
	static int[] array;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new int[N];

		dfs(0);

		System.out.println(count);
	}

	private static void dfs(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			array[depth] = i;

			if (Possibility(depth)) {
				dfs(depth + 1);
			}
		}
	}

	/*
	 * 가로 세로 대각선 판별해야 됨
	 * 세로: dfs가 세로로 한줄에 말 하나씩 놓으며 판별하므로 생각 X
	 * 가로: 현재 말과 이전의 말 비교 하였을때 배열에 저장된 값이 같다면 false
	 * 대각선: 위치의 차 = 값의 차가 되는 경우에 false
	 */
	private static boolean Possibility(int d) {

		// 현재 위치의 말을 이전 위치의 말들과 비교하였을 때
		for (int i = 0; i < d; i++) {

			// 가로로 같은 위치에 놓인 경우
			if (array[d] == array[i]) {
				return false;
			}

			// 대각선 상 같은 위치에 놓인 경우
			// 한칸 차이의 말의 경우 대각선도 한칸, 두칸 차이의 말의 경우 대각선도 두칸 차이가 남
			else if (Math.abs(d - i) == Math.abs(array[d] - array[i])) {
				return false;
			}
		}

		return true;
	}

}
