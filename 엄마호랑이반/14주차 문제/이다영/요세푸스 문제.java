import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			dq.addLast(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 1;
		while (dq.size() > 1) {
			int now = dq.pollFirst();
			
			if (cnt == k) {
				sb.append(now).append(", ");
				cnt = 1;
			} else {
				dq.addLast(now);
				cnt++;
			}
		}
		
		sb.append(dq.pollFirst()).append(">");
		System.out.print(sb.toString());
		
		sc.close();
	}
}
