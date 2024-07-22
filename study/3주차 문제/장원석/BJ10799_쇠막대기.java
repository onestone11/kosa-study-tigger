import java.util.ArrayDeque;
import java.util.Scanner;

public class BJ10799_쇠막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		ArrayDeque<Character> stack = new ArrayDeque<>();
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(')
				stack.push(c);
			else {
				stack.pop();

				if (str.charAt(i - 1) == '(')
					cnt += stack.size();
				else if (str.charAt(i - 1) == ')')
					cnt += 1;
			}
		}

		System.out.println(cnt);

	}

}
