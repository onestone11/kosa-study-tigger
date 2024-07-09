package fin;

import java.util.*;

// 트리의 부모 찾기
// 시간초과
public class BJ_11725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] parents = new int[n+1];

		Deque<Integer[]> dq = new ArrayDeque<>();
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			dq.add(new Integer[] {a, b});
		}
		
		while(dq.size() != 0) {
			Integer[] tmp = dq.removeFirst();
			int a = tmp[0];
			int b = tmp[1];
			
			if (parents[a] == 0 && parents[b] ==0 &&
					a != 1 && b != 1) {
				dq.add(new Integer[] {a, b});
			} else {
				
				if (a == 1) {
					parents[b] = 1;
					continue;
				}
				if (b == 1) {
					parents[a] = 1;
					continue;
				}
				
				if (parents[a] != 0) parents[b] = a;
				else parents[a] = b;
			}
		}
		
		
		for (int i = 2; i < n+1; i++) {
			System.out.println(parents[i]);
		}
		
		sc.close();
	}
}
