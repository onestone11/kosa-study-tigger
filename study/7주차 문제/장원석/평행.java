package Programmers.LV0;

public class 평행 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } }));
		System.out.println(solution(new int[][] { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } }));

	}

	private static int solution(int[][] dots) {

		int[] index = { 1, 2, 3 };

		for (int i = 1; i < 4; i++) {
			double line1 = (dots[0][1] - dots[i][1]) / (double) (dots[0][0] - dots[i][0]);

			int i2 = 0, i3 = 0;
			for (int j : index) {
				if (j != i) {
					if (i2 == 0 && i3 == 0)
						i2 = j;
					else if (i2 != 0 && i3 == 0)
						i3 = j;
				}
			}

			double line2 = (dots[i2][1] - dots[i3][1]) / (double) (dots[i2][0] - dots[i3][0]);

			if (line1 == line2)
				return 1;
		}

		return 0;
	}
}
