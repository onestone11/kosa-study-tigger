import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int minimum = 0;
		int[] daily = new int[n];
		for (int i = 0; i < n; i++) {
			daily[i] = Integer.parseInt(br.readLine());
			
			minimum = Math.max(minimum, daily[i]);
		}
		
		int s = minimum; int e = 1000000000;
		int res = 0;
		while (s <= e) {
			int k = (s + e) / 2;	// 인출한 돈
			
			int cnt = 1;			// 인출 횟수
			int now = k;			// 현재 소유한 돈
			for (int i = 0; i < n; i++) {
				if (now < daily[i]) {
					cnt++;
					now = k;
				}
				now -= daily[i];
			}
			
			if (cnt <= m) {
				res = k;
				e = k - 1;
				
			} else {
				s = k + 1;
			}
			
		}
		
		System.out.println(res);
	}
}
