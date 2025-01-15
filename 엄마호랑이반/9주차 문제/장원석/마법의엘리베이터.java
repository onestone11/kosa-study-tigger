public class 마법의엘리베이터 {

	public static void main(String[] args) {
		System.out.println(solution(16));
		System.out.println(solution(2554));
		System.out.println(solution(1354));
	}

	private static int solution(int storey) {

		int answer = 0;

		while (storey > 0) {
			int number = storey % 10;
			int next = (storey / 10) % 10;

			// 현재 자리수가 5보다 크다
			if (number > 5) {
				answer += (10 - number);
				storey += 10;
			} else if (number == 5 && next >= 5) {
				answer += 5;
				storey += 10;
			} else {
				answer += number;
			}

			storey /= 10;
		}

		return answer;
	}

}
