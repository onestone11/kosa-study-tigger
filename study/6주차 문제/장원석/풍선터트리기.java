package Programmers.LV3;

public class 풍선터트리기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, -1, -5 }));
		System.out.println(solution(new int[] { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 }));
	}

	private static int solution(int[] a) {
		int answer = 2;
		int N = a.length;

		int[] leftMinValues = new int[N];
		int[] rightMinValues = new int[N];

		int min = a[0];
		for (int i = 1; i < N - 1; i++) {
			leftMinValues[i] = min;
			min = Math.min(min, a[i]);
		}

		min = a[N - 1];
		for (int i = N - 2; i > 0; i--) {
			rightMinValues[i] = min;
			min = Math.min(min, a[i]);
		}

		for (int i = 1; i < N - 1; i++) {
			if (leftMinValues[i] < a[i] && rightMinValues[i] < a[i])
				continue;

			answer++;
		}

		return answer;
	}
}
