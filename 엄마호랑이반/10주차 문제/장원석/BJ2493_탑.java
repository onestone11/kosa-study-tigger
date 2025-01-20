import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];

		Stack<int[]> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				int[] now = stack.peek();

				if (now[0] < target)
					stack.pop();
				else
					break;
			}

			if (stack.isEmpty())
				answer[i] = 0;
			else
				answer[i] = stack.peek()[1] + 1;

			stack.push(new int[] { target, i });

		}

		StringBuilder sb = new StringBuilder();
		for (int i : answer) {
			sb.append(i).append(" ");
		}

		System.out.println(sb.toString());
	}

}
