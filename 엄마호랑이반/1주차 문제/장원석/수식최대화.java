import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 수식최대화 {

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}

	private static long solution(String expression) {
		long answer = 0;

		char[][] op = { { '*', '+', '-' }, { '*', '-', '+' }, { '+', '*', '-' }, { '+', '-', '*' }, { '-', '*', '+' },
				{ '-', '+', '*' } };

		String[] numbers = expression.split("\\*|\\+|\\-");
		List<String> numberList = new ArrayList<>(Arrays.asList(numbers));
		List<Character> signList = new ArrayList<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (!Character.isDigit(c)) {
				signList.add(c);
			}
		}

		for (int i = 0; i < 6; i++) {
			List<String> copyNumberList = new ArrayList<>();
			copyNumberList.addAll(numberList);
			List<Character> copySignList = new ArrayList<>();
			copySignList.addAll(signList);

			int j = 0;

			while (j < 3) {
				long sum = 0;

				int index = copySignList.indexOf(op[i][j]);
				if (index == -1) {
					j++;
					continue;
				}

				long num1 = Long.parseLong(copyNumberList.get(index));
				long num2 = Long.parseLong(copyNumberList.get(index + 1));

				if (copySignList.get(index) == '*')
					sum += (num1 * num2);
				else if (copySignList.get(index) == '+')
					sum += (num1 + num2);
				else if (copySignList.get(index) == '-')
					sum += (num1 - num2);

				copyNumberList.set(index, String.valueOf(sum));
				copyNumberList.remove(index + 1);
				copySignList.remove(index);
			}

			answer = Math.max(answer, Math.abs(Long.parseLong(copyNumberList.get(0))));
		}

		return answer;
	}

}
