import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String[] str = br.readLine().split("");
        int count = 0;
        
        for(int i=0; i<str.length; i++) {
            if(str[i].equals(")")) {
                // 레이저
                if(str[i-1].equals("(")) {
                    stack.pop();
                    count += stack.size();
                }
                // 막대
                else {
                    count++;
                    stack.pop();
                }
            }
            else stack.push(str[i]);
        }
        System.out.println(count);
        br.close();
    }
}
