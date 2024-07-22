import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ10773_제로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> stack = new ArrayDeque();
		
		for (int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0)
				stack.pop();
			else
				stack.push(N);
		}
		
		int answer = 0;
		while(!stack.isEmpty())
			answer += stack.pop();
		
		System.out.println(answer);
	}

}
