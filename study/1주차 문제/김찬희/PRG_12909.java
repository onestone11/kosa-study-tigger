import java.util.Stack;

public class PRG_12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(stack.isEmpty()) return false;
                else stack.pop();
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
