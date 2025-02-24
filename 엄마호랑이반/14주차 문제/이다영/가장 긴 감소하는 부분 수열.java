import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		int len = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				
				len = Math.max(len, dp[i]);
			}
		}
		
		System.out.print(len);
	}
}
