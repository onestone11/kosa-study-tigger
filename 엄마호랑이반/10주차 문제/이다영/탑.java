package temp_dev;

import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] top = new int[n + 1];
		int[] receiver = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n+1; i++) {
			if (top[i-1] >= top[i]) {
				receiver[i] = i-1;
				
			} else {
				int idx = receiver[i-1];

				while (idx > 0 && top[idx] < top[i]) {
					idx = receiver[idx];
				}
				
				receiver[i] = idx;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			sb.append(receiver[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
}
