import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] work = new int[n];
		work[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			work[i] = work[i-1] + Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int time = Integer.parseInt(br.readLine());
			
			int s = 0; int e = n-1;
			int res = 0;
			while (s <= e) {
				int idx = (s + e) / 2;
				
				if (work[idx] <= time) {
					res = idx + 1;
					s = idx + 1;
				} else {
					e = idx - 1;
				}
			}
			
			sb.append(res).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
