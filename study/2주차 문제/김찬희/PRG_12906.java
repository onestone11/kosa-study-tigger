import java.util.Stack;

public class PRG_12906 {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int number : arr) {
            if(stack.isEmpty()) stack.push(number);

            if(stack.peek() != number) {
                stack.push(number);
            }
        }

        int[] answer = new int[stack.size()];

        for(int i=answer.length-1; i>-1; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}