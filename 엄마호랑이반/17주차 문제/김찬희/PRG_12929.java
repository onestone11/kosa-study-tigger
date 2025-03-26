import java.util.Stack;

class Solution {
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
