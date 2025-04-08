public class 연속펄스부분수열의합 {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 2, 3, -6, 1, 3, -1, 2, 4 }));
	}

	public static long solution(int[] sequence) {
		long answer = 0;

		int sign = -1;

		long purse1 = 0;
		long purse2 = 0;

		for (int num : sequence) {
			purse1 += sign * num;
			purse2 += (-1) * sign * num;

			// 펄스 수열은 무조건 음수 또는 양수로 나눠진다. 즉, 최대값을 구하는 문제에서 음수가 되는 경우는 신경쓰지 않아도 된다.
			purse1 = Math.max(0, purse1);
			purse2 = Math.max(0, purse2);

			answer = Math.max(answer, Math.max(purse1, purse2));

			sign *= -1;
		}

		return answer;
	}
}
