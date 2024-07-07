package Programmers.LV2;

import java.util.Stack;

public class 올바른괄호 {
	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}

	private static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		char[] charArray = s.toCharArray();

		for (char c : charArray) {
			if (c == '(')
				stack.push(c);

			else {
				if (stack.isEmpty()) {
					answer = false;
					break;
				}

				stack.pop();
			}
		}
		
		if(!stack.isEmpty())
			answer = false;

		return answer;
	}
}
