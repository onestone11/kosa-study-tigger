public class 타겟넘버 {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
		System.out.println(solution(new int[] { 4, 1, 2, 1 }, 4));
	}

	static int count;

	private static int solution(int[] numbers, int target) {
		count = 0;
		dfs(0, 0, numbers, target);

		return count;
	}

	private static void dfs(int depth, int sum, int[] numbers, int target) {
		if (depth == numbers.length) {
			if (sum == target) {
				count++;
			}
			return;
		}

		int plus = sum + numbers[depth];
		int minus = sum - numbers[depth];

		dfs(depth + 1, plus, numbers, target);
		dfs(depth + 1, minus, numbers, target);
	}
}
