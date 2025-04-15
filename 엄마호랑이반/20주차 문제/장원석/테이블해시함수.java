import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 테이블해시함수 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 2, 2, 6 }, { 1, 5, 10 }, { 4, 2, 9 }, { 3, 8, 3 } }, 2, 2, 3));
	}

	public static int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;

		Arrays.sort(data, (a1, a2) -> {
			if (a1[col - 1] == a2[col - 1])
				return Integer.compare(a2[0], a1[0]);

			return Integer.compare(a1[col - 1], a2[col - 1]);
		});

//		System.out.println(Arrays.deepToString(data));

		List<Integer> sList = new ArrayList<>();

		for (int i = row_begin - 1; i < row_end; i++) {
			int sum = 0;

			for (int d : data[i]) {
				int s = d % (i + 1);
//				System.out.println(String.format("%d = %d mod %d", s, d, i + 1));
				sum += s;
			}

			sList.add(sum);
		}

//		System.out.println(sList);

		for (int i : sList) {
			answer ^= i;
		}

		return answer;
	}
}
