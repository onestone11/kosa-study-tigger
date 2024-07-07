package fin;

import java.util.Stack;

public class Pro_12909 {
	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}
	
	public static boolean solution(String s) {
		
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			String tmp = s.charAt(i) + "";
			
			if (tmp.equals("(")) stack.push(tmp);
			else {
				if (stack.size() == 0) return false;
				else {
					String peek = stack.pop();
					
					if (peek.equals(")")) return false;
				}
			}
			
			if (stack.size() > s.length()-(i+1)) return false;
		}
		
		return true;
	}
}
