import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] tops = new int[n];
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 탑의 크기 배열을 미리 정수로 변환
        for(int k=0; k<n; k++) tops[k] = Integer.parseInt(input[k]);

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && tops[stack.peek()] <= tops[i]) {
                answer[stack.pop()] = i+1;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString());
    }
}
