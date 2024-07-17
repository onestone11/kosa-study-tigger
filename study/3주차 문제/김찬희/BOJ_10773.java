import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int i=0; i<k; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) stack.pop();
            else stack.push(n);
        }

        while(!stack.isEmpty()) answer += stack.pop();
        
        System.out.println(answer);
    }
}