import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] amount = new int[n];
		for(int i = 0; i < n; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		
		if (n < 3) {
			switch (n) {
			case 1 : 
				System.out.println(amount[0]);
				return;
				
			case 2 : 
				System.out.println(amount[0] + amount[1]);
				return;
			}
		}
		
		int[] dp = new int[n];
		dp[0] = amount[0];
		dp[1] = amount[0] + amount[1];
		dp[2] = maxVal(dp[0] + amount[2], amount[1] + amount[2], dp[1]);
		
		for(int i = 3; i < n; i++) {
			dp[i] = maxVal(dp[i-2]+amount[i], dp[i-3]+amount[i-1]+amount[i], dp[i-1]);
		}
		
		System.out.println(Math.max(dp[n-1], dp[n-2]));
		
	}
	
	public static int maxVal(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
	
}
